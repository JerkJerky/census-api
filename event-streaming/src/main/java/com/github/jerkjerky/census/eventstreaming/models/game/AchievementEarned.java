package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class AchievementEarned extends GameCensusEvent {

    private final Long characterId;
    private final Long achievementId;
    private final Long zoneId;
    private final Instant timestamp;

    @JsonCreator
    public AchievementEarned(@JsonProperty("world_id") WorldId worldId,
                             @JsonProperty("event_name") CensusEventName eventName,
                             @JsonProperty("character_id") Long characterId,
                             @JsonProperty("achievement_id") Long achievementId,
                             @JsonProperty("zone_id") Long zoneId,
                             @JsonProperty("timestamp") Instant timestamp) {
        super(worldId, eventName);
        this.characterId = characterId;
        this.achievementId = achievementId;
        this.zoneId = zoneId;
        this.timestamp = timestamp;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public Long getAchievementId() {
        return achievementId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "AchievementEarned{" +
                super.toString() +
                "characterId=" + characterId +
                ", achievementId=" + achievementId +
                ", zoneId=" + zoneId +
                ", timestamp=" + timestamp +
                '}';
    }
}
