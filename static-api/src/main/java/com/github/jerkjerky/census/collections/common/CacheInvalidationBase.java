package com.github.jerkjerky.census.collections.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public abstract class CacheInvalidationBase {

    private final Instant fetchInstant;

    protected CacheInvalidationBase(Instant fetchInstant) {
        this.fetchInstant = fetchInstant;
    }

    @JsonProperty("fetchInstant")
    public Instant getFetchInstant() {
        return fetchInstant;
    }
}
