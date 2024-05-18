package com.github.jerkjerky.census.eventstreaming.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ServiceType {
    @JsonProperty("event")      EVENT,
    @JsonProperty("push")       PUSH,
}
