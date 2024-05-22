package com.github.jerkjerky.census.collections.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.jerkjerky.census.collections.common.CachingRedirect;
import lombok.Getter;
import lombok.SneakyThrows;
import okhttp3.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class StaticContentClient {

    public static final Duration CACHE_INVALIDATION_TIME = Duration.of(2, ChronoUnit.HOURS);

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private final String serviceId;
    private final OkHttpClient httpClient;
    private final Map<Class<?>, CachingRedirect> cachingRedirectMap;
    private final Duration cacheInvalidationDuration;

    @Getter
    private final OutfitClient outfitClient;
    @Getter
    private final CharacterClient characterClient;

    public StaticContentClient(String serviceId) {
        this(serviceId, CACHE_INVALIDATION_TIME);
    }

    public StaticContentClient(String serviceId,
                               Duration cacheInvalidationDuration) {
        this.serviceId = serviceId;
        this.httpClient = new OkHttpClient.Builder()
                .addInterceptor(new ServiceIdInterceptor(serviceId))
                .build();
        this.cachingRedirectMap = new HashMap<>();
        this.cacheInvalidationDuration = cacheInvalidationDuration;
        this.outfitClient = new OutfitClient(this, objectMapper, cachingRedirectMap, cacheInvalidationDuration);
        this.characterClient = new CharacterClient(this, objectMapper, cachingRedirectMap, cacheInvalidationDuration);
    }

    @SneakyThrows
    <T> T makeRequest(Request request, TypeReference<T> typeReference) {
        try(Response response = this.httpClient.newCall(request).execute()){
            return objectMapper.readValue(response.body().bytes(), typeReference);
        }
    }

}