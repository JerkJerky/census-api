package com.github.jerkjerky.census.eventstreaming.models.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jerkjerky.census.eventstreaming.models.ServiceEventType;
import com.github.jerkjerky.census.eventstreaming.models.ServiceType;
import com.github.jerkjerky.census.eventstreaming.models.game.GameCensusEvent;

public final class PayloadServiceEvent extends BasicCensusEvent {

    private ServiceType service;
    private ServiceEventType type;
    private GameCensusEvent payload;


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

    public GameCensusEvent getPayload() {
        return payload;
    }

    @JsonProperty("payload")
    void setPayload(GameCensusEvent payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "PayloadServiceEvent{" +
                "service=" + service +
                ", type=" + type +
                ", payload=" + payload +
                '}';
    }
}
