package io.github.jerkjerky.census.collections.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.jerkjerky.census.collections.common.CachingRedirect;
import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StaticContentClient {

    private static final Logger logger = LoggerFactory.getLogger(StaticContentClient.class);

    public static final Duration CACHE_INVALIDATION_TIME = Duration.of(2, ChronoUnit.HOURS);

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private final String serviceId;
    private final OkHttpClient httpClient;
    private final Map<Class<?>, CachingRedirect> cachingRedirectMap;


    @Getter
    private final OutfitClient outfitClient;
    @Getter
    private final CharacterClient characterClient;
    @Getter
    private final ExperienceClient experienceClient;
    @Getter
    private final LocationClient locationsClient;

    public StaticContentClient(String serviceId) {
        this(serviceId, CACHE_INVALIDATION_TIME);
    }

    public StaticContentClient(String serviceId,
                               Duration cacheInvalidationDuration) {
        this.serviceId = Objects.requireNonNull(serviceId);
        this.httpClient = new OkHttpClient.Builder()
                .addInterceptor(new ServiceIdInterceptor(serviceId))
                .build();
        this.cachingRedirectMap = new HashMap<>();
        this.outfitClient = new OutfitClient(this, cachingRedirectMap, cacheInvalidationDuration);
        this.characterClient = new CharacterClient(this, cachingRedirectMap, cacheInvalidationDuration);
        this.experienceClient = new ExperienceClient(this, cachingRedirectMap);
        this.locationsClient = new LocationClient(this, cachingRedirectMap);
    }

    <T> T makeRequest(Request request, TypeReference<T> typeReference) {
        try {
            String responseString = makeRequestInner(request);
            return objectMapper.readValue(responseString, typeReference);
        } catch (Throwable throwable) {
            logger.error("Failure during access to census via HTTP", throwable);
            throw new RuntimeException(throwable);
        }
    }

    protected String makeRequestInner(Request request) throws IOException {
        try(Response response = this.httpClient.newCall(request).execute()){
            return response.body().string();
        }
    }

}
