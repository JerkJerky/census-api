package io.github.jerkjerky.census.collections.client;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

final class ServiceIdInterceptor implements Interceptor {
    private final String serviceId;

    ServiceIdInterceptor(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public @NotNull Response intercept(Chain chain) throws IOException {
        HttpUrl url = chain.request().url();
        HttpUrl.Builder httpUrlWithInjectedServiceId = new HttpUrl.Builder()
                .scheme(url.scheme())
                .username(url.username())
                .password(url.password())
                .host(url.host())
                .port(url.port())
                .addEncodedPathSegment("s:" + this.serviceId);
        url.pathSegments().forEach(httpUrlWithInjectedServiceId::addPathSegment);
        url.queryParameterNames().forEach(s -> httpUrlWithInjectedServiceId.addQueryParameter(s, url.queryParameter(s)));
        httpUrlWithInjectedServiceId.addEncodedQueryParameter("c:limit", String.valueOf(5000));
        HttpUrl newHttpUrl = httpUrlWithInjectedServiceId.build();
        Request newRequest = chain.request().newBuilder()
                .url(newHttpUrl)
                .build();
        return chain.proceed(newRequest);
    }
}
