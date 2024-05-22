package com.github.jerkjerky.census.collections.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jerkjerky.census.collections.character.Character;
import com.github.jerkjerky.census.collections.character.CharacterResponse;
import com.github.jerkjerky.census.collections.common.CachingRedirect;
import com.github.jerkjerky.census.collections.outfit.Outfit;
import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;
import okhttp3.HttpUrl;
import okhttp3.Request;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CharacterClient {
    private static final HttpUrl CENSUS_OUTFIT_URL = HttpUrl.parse("https://census.daybreakgames.com/get/ps2:v2/character");

    private final StaticContentClient staticContentClient;
    private final Map<Class<?>, CachingRedirect> cachingRedirectMap;
    private final Duration cacheInvalidationDuration;
    private final ChronicleMap<Long, Character> characterByIdCache;
    private final ChronicleMap<String, Character> characterByNameCache;


    CharacterClient(StaticContentClient staticContentClient,
                    ObjectMapper objectMapper,
                    Map<Class<?>, CachingRedirect> cachingRedirectMap,
                    Duration cacheInvalidationDuration){
        this.staticContentClient = staticContentClient;
        this.cachingRedirectMap = cachingRedirectMap;
        CachingRedirect<Character> cachingRedirect = new CachingRedirect<>(Character.class, this::cacheCharacter);
        this.cachingRedirectMap.put(cachingRedirect.getHandlingClass(), cachingRedirect);
        this.cacheInvalidationDuration = cacheInvalidationDuration;

        this.characterByIdCache = ChronicleMapBuilder.of(Long.class, Character.class)
                .name("character_by_id_cache")
                .entries(20_000)
                .averageValueSize(500)
                .valueMarshallers((in, using) -> Character.cacheDeserialize(in, objectMapper),(out, toWrite) -> Character.cacheSerialize(out, objectMapper, toWrite))
                .create();
        this.characterByNameCache = ChronicleMapBuilder.of(String.class, Character.class)
                .name("character_by_name_cache")
                .entries(20_000)
                .averageValueSize(500)
                .averageKeySize(4)
                .valueMarshallers((in, using) -> Character.cacheDeserialize(in, objectMapper),(out, toWrite) -> Character.cacheSerialize(out, objectMapper, toWrite))
                .create();
    }

    private void cacheResponse(CharacterResponse characterResponse) {
        List<Character> characters = characterResponse.getCharacters();
        if (characters == null){
            return;
        }
        for (Character character : characters) {
            cacheCharacter(character);
        }
    }

    private void cacheCharacter(Character character) {
        this.characterByIdCache.put(character.getCharacterId(), character);
        this.characterByNameCache.put(character.getCharacterName().getFirst().toLowerCase(), character);
        CachingRedirect<Outfit> cachingRedirect = this.cachingRedirectMap.get(Outfit.class);
        if (cachingRedirect != null) {
            cachingRedirect.cache(Outfit.fromCharacterOutfitData(character.getCharacterOutfitData()));
        }
    }

    public Character fetchCharacterById(Long characterId) {
        Character character = characterByIdCache.get(characterId);
        if (character != null && character.getFetchInstant().plus(cacheInvalidationDuration).isBefore(Instant.now())){
            return character;
        }
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_OUTFIT_URL.newBuilder()
                        .addQueryParameter("character_id", String.valueOf(characterId))
                        .addEncodedQueryParameter("c:join", "outfit_member_extended")
                        .build())
                .build();
        TypeReference<CharacterResponse> outfitTypeReference = new TypeReference<>(){};
        CharacterResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        cacheResponse(outfitResponse);
        return Optional.ofNullable(outfitResponse.getCharacters()).map(List::getFirst).orElse(null);
    }

    public Character fetchCharacterByName(String characterName) {
        Character character = characterByNameCache.get(characterName);
        if (character != null && character.getFetchInstant().plus(cacheInvalidationDuration).isBefore(Instant.now())){
            return character;
        }
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_OUTFIT_URL.newBuilder()
                        .addQueryParameter("name.first_lower", String.valueOf(characterName).toLowerCase())
                        .addEncodedQueryParameter("c:join", "outfit_member_extended")
                        .build())
                .build();
        TypeReference<CharacterResponse> outfitTypeReference = new TypeReference<>(){};
        CharacterResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        cacheResponse(outfitResponse);
        return Optional.ofNullable(outfitResponse.getCharacters()).map(List::getFirst).orElse(null);
    }

    public List<Character> fetchCharacterByName(String characterName, SearchModifier searchModifier) {
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_OUTFIT_URL.newBuilder()
                        .addQueryParameter("name.first_lower", searchModifier.getModifier() + String.valueOf(characterName).toLowerCase())
                        .addEncodedQueryParameter("c:join", "outfit_member_extended")
                        .build())
                .build();
        TypeReference<CharacterResponse> outfitTypeReference = new TypeReference<>(){};
        CharacterResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        cacheResponse(outfitResponse);
        return Optional.ofNullable(outfitResponse.getCharacters()).orElse(Collections.emptyList());
    }

}
