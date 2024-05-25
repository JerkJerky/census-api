package io.github.jerkjerky.census.eventstreaming.models.service;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(ConnectedServiceEvent.class),
        @JsonSubTypes.Type(EndpointOnlineServiceEvent.class),
        @JsonSubTypes.Type(HeartbeatServiceEvent.class),
        @JsonSubTypes.Type(HelpServiceEvent.class),
        @JsonSubTypes.Type(PayloadServiceEvent.class),
        @JsonSubTypes.Type(SubscriptionInfoServiceEvent.class),
})

public abstract sealed class BasicCensusEvent
        permits ConnectedServiceEvent, EndpointOnlineServiceEvent, HeartbeatServiceEvent, HelpServiceEvent, PayloadServiceEvent, SubscriptionInfoServiceEvent {
}
