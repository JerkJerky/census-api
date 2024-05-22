package com.github.jerkjerky.census.collections.client;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

final class ServiceIdInterceptor implements Interceptor {
    private final String serviceId;

    ServiceIdInterceptor(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public @NotNull Response intercept(Chain chain) throws IOException {
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
