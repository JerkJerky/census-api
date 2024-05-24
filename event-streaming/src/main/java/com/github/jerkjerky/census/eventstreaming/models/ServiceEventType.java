package io.github.jerkjerky.census.eventstreaming.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ServiceEventType {
    @JsonProperty("connectionStateChanged")     CONNECTION_STATE_CHANGED,
    @JsonProperty("serviceStateChanged")        SERVICE_STATE_CHANGED,
    @JsonProperty("serviceMessage")             SERVICE_MESSAGE,
    @JsonProperty("heartbeat")                  HEARTBEAT,
}
