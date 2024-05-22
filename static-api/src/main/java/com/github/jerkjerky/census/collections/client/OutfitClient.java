package com.github.jerkjerky.census.collections.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jerkjerky.census.collections.outfit.Outfit;
import com.github.jerkjerky.census.collections.outfit.OutfitResponse;
import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;
import okhttp3.HttpUrl;
import okhttp3.Request;

import java.util.List;


public class OutfitClient {

    private static final HttpUrl CENSUS_OUTFIT_URL = HttpUrl.parse("https://census.daybreakgames.com/get/ps2:v2/outfit");

    private final StaticContentClient staticContentClient;
    private final ChronicleMap<Long, Outfit> outfitIdCache;
    private final ChronicleMap<String, Outfit> outfitAliasCache;


    OutfitClient(StaticContentClient staticContentClient,
                 ObjectMapper objectMapper){
        this.staticContentClient = staticContentClient;
        this.outfitIdCache = ChronicleMapBuilder.of(Long.class, Outfit.class)
                .name("outfit_by_id_cache")
                .entries(20_000)
                .averageValueSize(500)
                .valueMarshallers((in, using) -> Outfit.cacheDeserialize(in, objectMapper),(out, toWrite) -> Outfit.cacheSerialize(out, objectMapper, toWrite))
                .create();
        this.outfitAliasCache = ChronicleMapBuilder.of(String.class, Outfit.class)
                .name("outfit_by_alias_cache")
                .entries(20_000)
                .averageValueSize(500)
                .averageKeySize(4)
                .valueMarshallers((in, using) -> Outfit.cacheDeserialize(in, objectMapper),(out, toWrite) -> Outfit.cacheSerialize(out, objectMapper, toWrite))
                .create();
    }

    private void cacheOutfit(Outfit outfit) {
        this.outfitIdCache.put(outfit.getOutfitId(), outfit);
        this.outfitAliasCache.put(outfit.getAlias(), outfit);
    }

    public Outfit fetchOutfitByAlias(String alias) {
        Outfit outfit = outfitAliasCache.get(alias);
        if (outfit != null){
            return outfit;
        }
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_OUTFIT_URL.newBuilder()
                        .addQueryParameter("alias_lower", alias.toLowerCase())
                        .build())
                .build();
        TypeReference<OutfitResponse> outfitTypeReference = new TypeReference<>(){};
        OutfitResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        outfitResponse.getOutfitList().forEach(this::cacheOutfit);
        return outfitResponse.getOutfitList().getFirst();
    }

    public List<Outfit> fetchOutfitByAlias(String alias, SearchModifier searchModifier) {
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_OUTFIT_URL.newBuilder()
                        .addQueryParameter("alias_lower", searchModifier.getModifier() + alias.toLowerCase())
                        .build())
                .build();
        TypeReference<OutfitResponse> outfitTypeReference = new TypeReference<>(){};
        OutfitResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        outfitResponse.getOutfitList().forEach(this::cacheOutfit);
        return outfitResponse.getOutfitList();
    }

    public Outfit fetchOutfitById(long outfitId) {
        Outfit outfit = outfitIdCache.get(outfitId);
        if (outfit != null) {
            return outfit;
        }
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_OUTFIT_URL.newBuilder()
                        .addQueryParameter("outfit_id", String.valueOf(outfitId))
                        .build())
                .build();
        TypeReference<OutfitResponse> outfitTypeReference = new TypeReference<>(){};
        OutfitResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        outfitResponse.getOutfitList().forEach(this::cacheOutfit);
        return outfitResponse.getOutfitList().getFirst();
    }

    public List<Outfit> fetchOutfitsById(long outfitId, SearchModifier searchModifier) {
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_OUTFIT_URL.newBuilder()
                        .addQueryParameter("outfit_id", searchModifier.getModifier() + outfitId)
                        .build())
                .build();
        TypeReference<OutfitResponse> outfitTypeReference = new TypeReference<>(){};
        OutfitResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        outfitResponse.getOutfitList().forEach(this::cacheOutfit);
        return outfitResponse.getOutfitList();
    }

    public List<Outfit> fetchOutfitsByMemberCount(long memberCount, SearchModifier searchModifier) {
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_OUTFIT_URL.newBuilder()
                        .addQueryParameter("member_count", searchModifier.getModifier() + memberCount)
                        .build())
                .build();
        TypeReference<OutfitResponse> outfitTypeReference = new TypeReference<>(){};
        OutfitResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        outfitResponse.getOutfitList().forEach(this::cacheOutfit);
        return outfitResponse.getOutfitList();
    }

    public List<Outfit> fetchOutfitsWithName(String name, SearchModifier searchModifier) {
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_OUTFIT_URL.newBuilder()
                        .addQueryParameter("name_lower", searchModifier.getModifier() + name.toLowerCase())
                        .build())
                .build();
        TypeReference<OutfitResponse> outfitTypeReference = new TypeReference<>(){};
        OutfitResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        outfitResponse.getOutfitList().forEach(this::cacheOutfit);
        return outfitResponse.getOutfitList();
    }




}
