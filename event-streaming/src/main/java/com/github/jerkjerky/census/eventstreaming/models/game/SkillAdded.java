package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class SkillAdded extends GameCensusEvent {
    private final Long characterId;
    private final Long skillId;
    private final Long zoneId;
    private final Instant timestamp;

    @JsonCreator
    public SkillAdded(@JsonProperty("world_id") WorldId worldId,
                      @JsonProperty("event_name") CensusEventName eventName,
                      @JsonProperty("character_id") Long characterId,
                      @JsonProperty("skill_id") Long skillId,
                      @JsonProperty("zone_id") Long zoneId,
                      @JsonProperty("timestamp") Instant timestamp) {
        super(worldId, eventName);
        this.characterId = characterId;
        this.skillId = skillId;
        this.zoneId = zoneId;
        this.timestamp = timestamp;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "SkillAdded{" +
                super.toString() +
                "characterId=" + characterId +
                ", skillId=" + skillId +
                ", zoneId=" + zoneId +
                ", timestamp=" + timestamp +
                '}';
    }
}
