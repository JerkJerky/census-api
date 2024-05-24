package com.github.jerkjerky.census.collections.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.jerkjerky.census.collections.common.CachingRedirect;
import com.github.jerkjerky.census.collections.experience.Experience;
import com.github.jerkjerky.census.collections.experience.ExperienceAwardType;
import com.github.jerkjerky.census.collections.experience.ExperienceResponse;
import okhttp3.HttpUrl;
import okhttp3.Request;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ExperienceClient {
    private static final HttpUrl CENSUS_EXPERIENCE_URL = HttpUrl.parse("https://census.daybreakgames.com/get/ps2:v2/experience");

    private final StaticContentClient staticContentClient;
    private final Map<Class<?>, CachingRedirect> cachingRedirectMap;
    private final Cache<Long, Experience> experienceCache;
    private final Cache<Long, ExperienceAwardType> experienceAwardTypeCache;


    ExperienceClient(StaticContentClient staticContentClient,
                    Map<Class<?>, CachingRedirect> cachingRedirectMap) {
        this.staticContentClient = staticContentClient;
        this.cachingRedirectMap = cachingRedirectMap;

        this.experienceCache = Caffeine.newBuilder()
                .maximumSize(20_000)
                .build();
        this.experienceAwardTypeCache = Caffeine.newBuilder()
                .maximumSize(20_000)
                .build();
        cachingRedirectMap.put(Experience.class, new CachingRedirect<>(Experience.class, this::cacheExperience));
        cachingRedirectMap.put(ExperienceAwardType.class, new CachingRedirect<>(ExperienceAwardType.class, this::cacheExperienceAwardType));
    }

    private void cacheExperience(Experience experience){
        this.experienceCache.put(experience.getId(), experience);
        Optional.ofNullable(experience.getExperienceAwardType())
                .ifPresent(this::cacheExperienceAwardType);
    }

    private void cacheExperienceAwardType(ExperienceAwardType experienceAwardType) {
        this.experienceAwardTypeCache.put(experienceAwardType.getTypeId(), experienceAwardType);
    }


    public Experience fetchExperienceById(Long experienceId) {
        long estimatedSize = experienceCache.estimatedSize();
        if (estimatedSize > 0) {
            return experienceCache.getIfPresent(experienceId);
        }
        fetchAllExperienceInfo();
        return experienceCache.getIfPresent(experienceId);
    }

    public ExperienceAwardType fetchExperienceAwardTypeById(Long experienceAwardTypeById) {
        long estimatedSize = experienceAwardTypeCache.estimatedSize();
        if (estimatedSize > 0) {
            return experienceAwardTypeCache.getIfPresent(experienceAwardTypeById);
        }
        fetchAllExperienceInfo();
        return experienceAwardTypeCache.getIfPresent(experienceAwardTypeById);
    }

    private void fetchAllExperienceInfo() {
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_EXPERIENCE_URL.newBuilder()
                        .addEncodedQueryParameter("c:join", "experience_award_type")
                        .build())
                .build();
        TypeReference<ExperienceResponse> outfitTypeReference = new TypeReference<>(){};
        ExperienceResponse experienceResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        List<Experience> experienceList = experienceResponse.getExperienceList();
        if (experienceList == null){
            return;
        }
        experienceList.forEach(this::cacheExperience);
    }
}
