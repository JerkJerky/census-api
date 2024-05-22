package com.github.jerkjerky.census.collections.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jerkjerky.census.collections.common.CachingRedirect;
import com.github.jerkjerky.census.collections.outfit.Outfit;
import com.github.jerkjerky.census.collections.outfit.OutfitResponse;
import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;
import okhttp3.HttpUrl;
import okhttp3.Request;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;


public class OutfitClient {

    private static final HttpUrl CENSUS_OUTFIT_URL = HttpUrl.parse("https://census.daybreakgames.com/get/ps2:v2/outfit");
    public static final Duration CACHE_INVALIDATION_TIME = Duration.of(1, ChronoUnit.HOURS);

    private final StaticContentClient staticContentClient;
    private final Map<Class<?>, CachingRedirect> cachingRedirectMap;
    private final Duration cacheInvalidationDuration;
    private final ChronicleMap<Long, Outfit> outfitIdCache;
    private final ChronicleMap<String, Outfit> outfitAliasCache;


    OutfitClient(StaticContentClient staticContentClient,
                 ObjectMapper objectMapper,
                 Map<Class<?>, CachingRedirect> cachingRedirectMap,
                 Duration cacheInvalidationDuration){
        this.staticContentClient = staticContentClient;
        this.cachingRedirectMap = cachingRedirectMap;
        CachingRedirect<Outfit> outfitCachingRedirect = new CachingRedirect<>(Outfit.class, this::cacheOutfit);
        this.cachingRedirectMap.put(outfitCachingRedirect.getHandlingClass(), outfitCachingRedirect);
        this.cacheInvalidationDuration = cacheInvalidationDuration;

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

    private void cacheResponse(OutfitResponse outfitResponse) {
        List<Outfit> outfitList = outfitResponse.getOutfitList();
        if (outfitList == null){
            return;
        }
        for (Outfit outfit : outfitList) {
            cacheOutfit(outfit);
        }
    }

    private void cacheOutfit(Outfit outfit) {
        this.outfitIdCache.put(outfit.getOutfitId(), outfit);
        this.outfitAliasCache.put(outfit.getAlias(), outfit);
    }

    public Outfit fetchOutfitByAlias(String alias) {
        Outfit outfit = outfitAliasCache.get(alias);
        if (outfit != null && outfit.getFetchInstant().plus(cacheInvalidationDuration).isBefore(Instant.now())){
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
        cacheResponse(outfitResponse);
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
        cacheResponse(outfitResponse);
        return outfitResponse.getOutfitList();
    }

    public Outfit fetchOutfitById(long outfitId) {
        Outfit outfit = outfitIdCache.get(outfitId);
        if (outfit != null && outfit.getFetchInstant().plus(cacheInvalidationDuration).isBefore(Instant.now())) {
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
        cacheResponse(outfitResponse);
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
        cacheResponse(outfitResponse);
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
        cacheResponse(outfitResponse);
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
        cacheResponse(outfitResponse);
        return outfitResponse.getOutfitList();
    }

}
