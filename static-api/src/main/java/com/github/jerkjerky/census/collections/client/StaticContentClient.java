package com.github.jerkjerky.census.collections.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.SneakyThrows;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class StaticContentClient {

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private final String serviceId;
    private final OkHttpClient httpClient;

    @Getter
    private final OutfitClient outfitClient;


    public StaticContentClient(String serviceId) {
        this.serviceId = serviceId;
        this.httpClient = new OkHttpClient.Builder()
                .addInterceptor(new ServiceIdInterceptor(serviceId))
                .build();
        this.outfitClient = new OutfitClient(this, objectMapper);
    }

    @SneakyThrows
    <T> T makeRequest(Request request, TypeReference<T> typeReference) {
        try(Response response = this.httpClient.newCall(request).execute()){
            return objectMapper.readValue(response.body().bytes(), typeReference);
        }
    }


    static final class ServiceIdInterceptor implements Interceptor {
        private final String serviceId;
        ServiceIdInterceptor(String serviceId) {
            this.serviceId = serviceId;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            HttpUrl url = chain.request().url();
            List<String> pathSegments = url.pathSegments();
            HttpUrl.Builder httpUrlWithInjectedServiceId = url.newBuilder()
                    .setPathSegment(0, this.serviceId)
                    .addEncodedQueryParameter("c:limit", String.valueOf(5000));
            pathSegments.forEach(httpUrlWithInjectedServiceId::addPathSegment);
            Request newRequest = chain.request().newBuilder()
                    .url(httpUrlWithInjectedServiceId.build())
                    .build();
            return chain.proceed(newRequest);
        }
    }


}
