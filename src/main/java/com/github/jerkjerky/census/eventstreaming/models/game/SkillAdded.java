package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class SkillAdded extends GameCensusEvent {
    private Long characterId;
    private Long skillId;
    private WorldId worldId;
    private Long zoneId;
    private Instant timestamp;

    public Long getCharacterId() {
        return characterId;
    }

    @JsonProperty("character_id")
    void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public Long getSkillId() {
        return skillId;
    }

    @JsonProperty("skill_id")
    void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public WorldId getWorldId() {
        return worldId;
    }

    @JsonProperty("world_id")
    void setWorldId(WorldId worldId) {
        this.worldId = worldId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    @JsonProperty("zone_id")
    void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    void setTimestamp(String timestamp) {
        this.timestamp = Instant.ofEpochMilli(Long.parseLong(timestamp));
    }

    @Override
    public String toString() {
        return "SkillAdded{" +
                "characterId=" + characterId +
                ", skillId=" + skillId +
                ", worldId=" + worldId +
                ", zoneId=" + zoneId +
                ", timestamp=" + timestamp +
                '}';
    }
}
