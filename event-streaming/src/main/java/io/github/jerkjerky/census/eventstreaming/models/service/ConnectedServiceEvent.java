package io.github.jerkjerky.census.eventstreaming.models.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.jerkjerky.census.eventstreaming.models.ServiceEventType;
import io.github.jerkjerky.census.eventstreaming.models.ServiceType;

public final class ConnectedServiceEvent extends BasicCensusEvent {

    private ServiceType service;
    private ServiceEventType type;
    private Boolean isConnected;


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

    public Boolean getConnected() {
        return isConnected;
    }

    @JsonProperty("connected")
    void setConnected(Boolean connected) {
        isConnected = connected;
    }


    @Override
    public String toString() {
        return "ConnectedServiceEvent{" +
                "service=" + service +
                ", type=" + type +
                ", isConnected=" + isConnected +
                '}';
    }
}
