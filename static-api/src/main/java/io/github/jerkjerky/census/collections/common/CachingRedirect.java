package io.github.jerkjerky.census.collections.common;

import lombok.Getter;

import java.util.function.Consumer;

public class CachingRedirect<T> {

    @Getter
    private final Class<T> handlingClass;
    private final Consumer<T> cachingConsumer;

    public CachingRedirect(Class<T> handlingClass,
                           Consumer<T> cachingConsumer) {
        this.handlingClass = handlingClass;
        this.cachingConsumer = cachingConsumer;
    }

    public void cache(T objectToBeCached) {
        cachingConsumer.accept(objectToBeCached);
    }

}
