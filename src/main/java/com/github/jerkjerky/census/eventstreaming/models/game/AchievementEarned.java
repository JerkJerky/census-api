package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class AchievementEarned extends GameCensusEvent {

    private Long characterId;
    private WorldId worldId;
    private Long achievementId;
    private Long zoneId;
    private Instant timestamp;


    public Long getCharacterId() {
        return characterId;
    }

    @JsonProperty("character_id")
    void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public WorldId getWorldId() {
        return worldId;
    }

    @JsonProperty("world_id")
    void setWorldId(WorldId worldId) {
        this.worldId = worldId;
    }

    public Long getAchievementId() {
        return achievementId;
    }

    @JsonProperty("achievement_id")
    void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
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
}
