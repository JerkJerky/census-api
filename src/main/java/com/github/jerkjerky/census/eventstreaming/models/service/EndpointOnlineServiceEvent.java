package com.github.jerkjerky.census.eventstreaming.models.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jerkjerky.census.eventstreaming.models.ServiceEventType;
import com.github.jerkjerky.census.eventstreaming.models.ServiceType;

public final class EndpointOnlineServiceEvent extends BasicCensusEvent {

    private ServiceType service;
    private ServiceEventType type;
    private String detail;
    private Boolean online;

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

    public String getDetail() {
        return detail;
    }

    @JsonProperty("detail")
    void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean getOnline() {
        return online;
    }

    @JsonProperty("online")
    void setOnline(Boolean online) {
        this.online = online;
    }

}
