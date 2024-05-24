package com.github.jerkjerky.census.collections.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.jerkjerky.census.collections.common.CachingRedirect;
import com.github.jerkjerky.census.collections.outfit.Outfit;
import com.github.jerkjerky.census.collections.outfit.OutfitResponse;
import okhttp3.HttpUrl;
import okhttp3.Request;

import java.time.Duration;
import java.util.List;
import java.util.Map;


public class OutfitClient {

    private static final HttpUrl CENSUS_OUTFIT_URL = HttpUrl.parse("https://census.daybreakgames.com/get/ps2:v2/outfit");

    private final StaticContentClient staticContentClient;
    private final Map<Class<?>, CachingRedirect> cachingRedirectMap;
    private final Cache<Long, Outfit> outfitIdCache;
    private final Cache<String, Outfit> outfitAliasCache;


    OutfitClient(StaticContentClient staticContentClient,
                 Map<Class<?>, CachingRedirect> cachingRedirectMap,
                 Duration cacheInvalidationDuration){
        this.staticContentClient = staticContentClient;
        this.cachingRedirectMap = cachingRedirectMap;
        CachingRedirect<Outfit> outfitCachingRedirect = new CachingRedirect<>(Outfit.class, this::cacheOutfit);
        this.cachingRedirectMap.put(outfitCachingRedirect.getHandlingClass(), outfitCachingRedirect);

        this.outfitIdCache = Caffeine.newBuilder()
                .maximumSize(20_000)
                .expireAfterWrite(cacheInvalidationDuration)
                .build();
        this.outfitAliasCache = Caffeine.newBuilder()
                .maximumSize(20_000)
                .expireAfterWrite(cacheInvalidationDuration)
                .build();
    }

    private void cacheOutfit(Outfit outfit) {
        this.outfitIdCache.put(outfit.getOutfitId(), outfit);
        this.outfitAliasCache.put(outfit.getAlias(), outfit);
    }

    public Outfit fetchOutfitByAlias(String alias) {
        Outfit cachedOutfit = outfitAliasCache.getIfPresent(alias);
        if (cachedOutfit != null){
            return cachedOutfit;
        }
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_OUTFIT_URL.newBuilder()
                        .addQueryParameter("alias_lower", alias.toLowerCase())
                        .build())
                .build();
        TypeReference<OutfitResponse> outfitTypeReference = new TypeReference<>(){};
        OutfitResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        List<Outfit> outfitList = outfitResponse.getOutfitList();
        if (outfitList != null) {
            for (Outfit outfit : outfitList) {
                cacheOutfit(outfit);
            }
        }
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
        List<Outfit> outfitList = outfitResponse.getOutfitList();
        if (outfitList != null) {
            for (Outfit outfit : outfitList) {
                cacheOutfit(outfit);
            }
        }
        return outfitResponse.getOutfitList();
    }

    public Outfit fetchOutfitById(long outfitId) {
        Outfit cachedOutfit = outfitIdCache.getIfPresent(outfitId);
        if (cachedOutfit != null){
            return cachedOutfit;
        }
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_OUTFIT_URL.newBuilder()
                        .addQueryParameter("outfit_id", String.valueOf(outfitId))
                        .build())
                .build();
        TypeReference<OutfitResponse> outfitTypeReference = new TypeReference<>(){};
        OutfitResponse outfitResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        List<Outfit> outfitList = outfitResponse.getOutfitList();
        if (outfitList != null) {
            for (Outfit outfit : outfitList) {
                cacheOutfit(outfit);
            }
        }
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
        List<Outfit> outfitList = outfitResponse.getOutfitList();
        if (outfitList != null) {
            for (Outfit outfit : outfitList) {
                cacheOutfit(outfit);
            }
        }
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
        List<Outfit> outfitList = outfitResponse.getOutfitList();
        if (outfitList != null) {
            for (Outfit outfit : outfitList) {
                cacheOutfit(outfit);
            }
        }
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
        List<Outfit> outfitList = outfitResponse.getOutfitList();
        if (outfitList != null) {
            for (Outfit outfit : outfitList) {
                cacheOutfit(outfit);
            }
        }
        return outfitResponse.getOutfitList();
    }

}
