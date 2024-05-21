package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public final class ContinentUnlock extends GameCensusEvent {
    private final Long zoneId;
    private final String triggeringFaction;
    private final String previousFaction;
    private final Long vsPopulation;
    private final Long ncPopulation;
    private final Long trPopulation;
    private final Long metagameEventId;
    private final String eventType;
    private final Instant timestamp;

    @JsonCreator
    public ContinentUnlock(@JsonProperty("world_id") WorldId worldId,
                           @JsonProperty("event_name") CensusEventName eventName,
                           @JsonProperty("zone_id") Long zoneId,
                           @JsonProperty("triggering_faction") String triggeringFaction,
                           @JsonProperty("previous_faction") String previousFaction,
                           @JsonProperty("vs_population") Long vsPopulation,
                           @JsonProperty("nc_population") Long ncPopulation,
                           @JsonProperty("tr_population") Long trPopulation,
                           @JsonProperty("metagame_event_id") Long metagameEventId,
                           @JsonProperty("event_type") String eventType,
                           @JsonProperty("timestamp") Instant timestamp) {
        super(worldId, eventName);
        this.zoneId = zoneId;
        this.triggeringFaction = triggeringFaction;
        this.previousFaction = previousFaction;
        this.vsPopulation = vsPopulation;
        this.ncPopulation = ncPopulation;
        this.trPopulation = trPopulation;
        this.metagameEventId = metagameEventId;
        this.eventType = eventType;
        this.timestamp = timestamp;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public String getTriggeringFaction() {
        return triggeringFaction;
    }

    public String getPreviousFaction() {
        return previousFaction;
    }

    public Long getVsPopulation() {
        return vsPopulation;
    }

    public Long getNcPopulation() {
        return ncPopulation;
    }

    public Long getTrPopulation() {
        return trPopulation;
    }

    public Long getMetagameEventId() {
        return metagameEventId;
    }

    public String getEventType() {
        return eventType;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ContinentUnlock{" +
                super.toString() +
                ", zoneId=" + zoneId +
                ", triggeringFaction='" + triggeringFaction + '\'' +
                ", previousFaction='" + previousFaction + '\'' +
                ", vsPopulation=" + vsPopulation +
                ", ncPopulation=" + ncPopulation +
                ", trPopulation=" + trPopulation +
                ", metagameEventId=" + metagameEventId +
                ", eventType='" + eventType + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
