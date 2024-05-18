package com.github.jerkjerky.census.eventstreaming.models.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public final class SubscriptionInfoServiceEvent extends BasicCensusEvent {
    private Map<String, Object> subscriptions;

    public Map<String, Object> getSubscriptions() {
        return subscriptions;
    }

    @JsonProperty("subscription")
    void setSubscriptions(Map<String, Object> subscriptions) {
        this.subscriptions = subscriptions;
    }


    @Override
    public String toString() {
        return "SubscriptionInfoServiceEvent{" +
                "subscriptions=" + subscriptions +
                '}';
    }
}
