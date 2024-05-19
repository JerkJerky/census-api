package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class MetagameEvent extends GameCensusEvent {
    private final WorldId worldId;
    private final String experienceBonus;
    private final String factionNc;
    private final String factionTr;
    private final String factionVs;
    private final String instanceId;
    private final String metagameEventId;
    private final String metagameEventState;
    private final Long zoneId;
    private final Instant timestamp;

    public MetagameEvent(@JsonProperty("world_id") WorldId worldId,
                         @JsonProperty("experience_bonus") String experienceBonus,
                         @JsonProperty("faction_nc") String factionNc,
                         @JsonProperty("faction_tr") String factionTr,
                         @JsonProperty("faction_vs") String factionVs,
                         @JsonProperty("instance_id") String instanceId,
                         @JsonProperty("metagame_event_id") String metagameEventId,
                         @JsonProperty("metagame_event_state") String metagameEventState,
                         @JsonProperty("zone_id") Long zoneId,
                         @JsonProperty("timestamp") String timestamp) {
        this.worldId = worldId;
        this.experienceBonus = experienceBonus;
        this.factionNc = factionNc;
        this.factionTr = factionTr;
        this.factionVs = factionVs;
        this.instanceId = instanceId;
        this.metagameEventId = metagameEventId;
        this.metagameEventState = metagameEventState;
        this.zoneId = zoneId;
        this.timestamp = Instant.ofEpochMilli(Long.parseLong(timestamp));
    }

    public WorldId getWorldId() {
        return worldId;
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
                "worldId=" + worldId +
                ", experienceBonus='" + experienceBonus + '\'' +
                ", factionNc='" + factionNc + '\'' +
                ", factionTr='" + factionTr + '\'' +
                ", factionVs='" + factionVs + '\'' +
                ", instanceId='" + instanceId + '\'' +
                ", metagameEventId='" + metagameEventId + '\'' +
                ", metagameEventState='" + metagameEventState + '\'' +
                ", zoneId=" + zoneId +
                ", timestamp=" + timestamp +
                '}';
    }
}
