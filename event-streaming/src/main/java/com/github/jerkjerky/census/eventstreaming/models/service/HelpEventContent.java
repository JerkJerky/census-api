package com.github.jerkjerky.census.eventstreaming.models.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelpEventContent {

    private String service;
    private String action;

    @JsonProperty("service")
    public void setService(String service) {
        this.service = service;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    public String getService() {
        return service;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "HelpEventContent{" +
                "service='" + service + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
