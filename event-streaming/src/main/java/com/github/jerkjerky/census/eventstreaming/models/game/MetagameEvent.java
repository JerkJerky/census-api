package io.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public final class MetagameEvent extends GameCensusEvent {
    private final String experienceBonus;
    private final String factionNc;
    private final String factionTr;
    private final String factionVs;
    private final String instanceId;
    private final String metagameEventId;
    private final String metagameEventState;
    private final String metagameEventStateName;
    private final Long zoneId;
    private final Instant timestamp;

    @JsonCreator
    public MetagameEvent(@JsonProperty("world_id") WorldId worldId,
                         @JsonProperty("event_name") CensusEventName eventName,
                         @JsonProperty("experience_bonus") String experienceBonus,
                         @JsonProperty("faction_nc") String factionNc,
                         @JsonProperty("faction_tr") String factionTr,
                         @JsonProperty("faction_vs") String factionVs,
                         @JsonProperty("instance_id") String instanceId,
                         @JsonProperty("metagame_event_id") String metagameEventId,
                         @JsonProperty("metagame_event_state") String metagameEventState,
                         @JsonProperty("metagame_event_state_name") String metagameEventStateName,
                         @JsonProperty("zone_id") Long zoneId,
                         @JsonProperty("timestamp") String timestamp) {
        super(worldId, eventName);
        this.experienceBonus = experienceBonus;
        this.factionNc = factionNc;
        this.factionTr = factionTr;
        this.factionVs = factionVs;
        this.instanceId = instanceId;
        this.metagameEventId = metagameEventId;
        this.metagameEventState = metagameEventState;
        this.metagameEventStateName = metagameEventStateName;
        this.zoneId = zoneId;
        this.timestamp = Instant.ofEpochMilli(Long.parseLong(timestamp));
    }
    public String getExperienceBonus() {
        return experienceBonus;
    }

    public String getFactionNc() {
        return factionNc;
    }

    public String getFactionTr() {
        return factionTr;
    }

    public String getFactionVs() {
        return factionVs;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getMetagameEventId() {
        return metagameEventId;
    }

    public String getMetagameEventState() {
        return metagameEventState;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "MetagameEvent{" +
                super.toString() +
                "experienceBonus='" + experienceBonus + '\'' +
                ", factionNc='" + factionNc + '\'' +
                ", factionTr='" + factionTr + '\'' +
                ", factionVs='" + factionVs + '\'' +
                ", instanceId='" + instanceId + '\'' +
                ", metagameEventId='" + metagameEventId + '\'' +
                ", metagameEventState='" + metagameEventState + '\'' +
                ", metagameEventStateName='" + metagameEventStateName + '\'' +
                ", zoneId=" + zoneId +
                ", timestamp=" + timestamp +
                "} ";
    }
}
