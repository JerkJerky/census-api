package com.github.jerkjerky.census.eventstreaming.models.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jerkjerky.census.eventstreaming.models.ServiceEventType;
import com.github.jerkjerky.census.eventstreaming.models.ServiceType;

import java.time.Instant;
import java.util.Map;

public final class HeartbeatServiceEvent extends BasicCensusEvent {
    private ServiceType service;
    private ServiceEventType type;
    private Instant timestamp;
    private Map<String, Boolean> heartbeatInfo;

    public ServiceType getService() {
        return service;
    }

    @JsonProperty("service")
    void setService(ServiceType service) {
        this.service = service;
    }

    public ServiceEventType getType() {
        return type;
    }

    @JsonProperty("type")
    void setType(ServiceEventType type) {
        this.type = type;
    }


    public Instant getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = Instant.ofEpochMilli(Long.parseLong(timestamp));
    }

    public Map<String, Boolean> getHeartbeatInfo() {
        return heartbeatInfo;
    }

    @JsonProperty("online")
    void setHeartbeatInfo(Map<String, Boolean> heartbeatInfo) {
        this.heartbeatInfo = heartbeatInfo;
    }

    @Override
    public String toString() {
        return "HeartbeatServiceEvent{" +
                "service=" + service +
                ", type=" + type +
                ", heartbeatInfo=" + heartbeatInfo +
                '}';
    }
}
