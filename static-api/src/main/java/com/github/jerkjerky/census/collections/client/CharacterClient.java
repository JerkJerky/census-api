package com.github.jerkjerky.census.collections.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.jerkjerky.census.collections.character.Character;
import com.github.jerkjerky.census.collections.character.CharacterResponse;
import com.github.jerkjerky.census.collections.common.CachingRedirect;
import com.github.jerkjerky.census.collections.outfit.Outfit;
import okhttp3.HttpUrl;
import okhttp3.Request;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CharacterClient {
    private static final HttpUrl CENSUS_OUTFIT_URL = HttpUrl.parse("https://census.daybreakgames.com/get/ps2:v2/character");

    private final StaticContentClient staticContentClient;
    private final Map<Class<?>, CachingRedirect> cachingRedirectMap;
    private final Cache<Long, Character> characterByIdCache;
    private final Cache<String, Character> characterByNameCache;


    CharacterClient(StaticContentClient staticContentClient,
                    Map<Class<?>, CachingRedirect> cachingRedirectMap,
                    Duration cacheInvalidationDuration){
        this.staticContentClient = staticContentClient;
        this.cachingRedirectMap = cachingRedirectMap;
        CachingRedirect<Character> cachingRedirect = new CachingRedirect<>(Character.class, this::cacheCharacter);
        this.cachingRedirectMap.put(cachingRedirect.getHandlingClass(), cachingRedirect);

        this.characterByIdCache = Caffeine.newBuilder()
                .maximumSize(20_000)
                .expireAfterWrite(cacheInvalidationDuration)
                .build();
        this.characterByNameCache = Caffeine.newBuilder()
                .maximumSize(20_000)
                .expireAfterWrite(cacheInvalidationDuration)
                .build();
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
        return characterByIdCache.get(characterId, key -> {
            Request request = new Request.Builder()
                    .get()
                    .url(CENSUS_OUTFIT_URL.newBuilder()
                            .addQueryParameter("character_id", String.valueOf(key))
                            .addEncodedQueryParameter("c:join", "outfit_member_extended")
                            .build())
                    .build();
            TypeReference<CharacterResponse> outfitTypeReference = new TypeReference<>(){};
            CharacterResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
            List<Character> characters = outfitResponse.getCharacters();
            if (characters != null) {
                for (Character character : characters) {
                    this.characterByNameCache.put(character.getCharacterName().getFirst().toLowerCase(), character);
                    CachingRedirect<Outfit> cachingRedirect = this.cachingRedirectMap.get(Outfit.class);
                    if (cachingRedirect != null) {
                        cachingRedirect.cache(Outfit.fromCharacterOutfitData(character.getCharacterOutfitData()));
                    }
                }
            }
            return Optional.ofNullable(outfitResponse.getCharacters()).map(List::getFirst).orElse(null);
        });
    }

    public Character fetchCharacterByName(String characterName) {
        return characterByNameCache.get(characterName, key -> {
            Request request = new Request.Builder()
                    .get()
                    .url(CENSUS_OUTFIT_URL.newBuilder()
                            .addQueryParameter("name.first_lower", String.valueOf(key).toLowerCase())
                            .addEncodedQueryParameter("c:join", "outfit_member_extended")
                            .build())
                    .build();
            TypeReference<CharacterResponse> outfitTypeReference = new TypeReference<>(){};
            CharacterResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
            List<Character> characters = outfitResponse.getCharacters();
            if (characters != null) {
                for (Character character : characters) {
                    this.characterByIdCache.put(character.getCharacterId(), character);
                    CachingRedirect<Outfit> cachingRedirect = this.cachingRedirectMap.get(Outfit.class);
                    if (cachingRedirect != null) {
                        cachingRedirect.cache(Outfit.fromCharacterOutfitData(character.getCharacterOutfitData()));
                    }
                }
            }
            return Optional.ofNullable(outfitResponse.getCharacters()).map(List::getFirst).orElse(null);
        });
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
        List<Character> characters = outfitResponse.getCharacters();
        if (characters != null) {
            for (Character character : characters) {
                this.characterByIdCache.put(character.getCharacterId(), character);
                this.characterByNameCache.put(character.getCharacterName().getFirst().toLowerCase(), character);
                CachingRedirect<Outfit> cachingRedirect = this.cachingRedirectMap.get(Outfit.class);
                if (cachingRedirect != null) {
                    cachingRedirect.cache(Outfit.fromCharacterOutfitData(character.getCharacterOutfitData()));
                }
            }
        }
        return Optional.ofNullable(outfitResponse.getCharacters()).orElse(Collections.emptyList());
    }

}
