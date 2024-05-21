package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public final class BattleRankUp extends GameCensusEvent {

    private final String battleRank;
    private final Long characterId;
    private final Long zoneId;
    private final Instant timestamp;

    @JsonCreator
    public BattleRankUp(@JsonProperty("world_id") WorldId worldId,
                        @JsonProperty("event_name") CensusEventName eventName,
                        @JsonProperty("battle_rank") String battleRank,
                        @JsonProperty("character_id") Long characterId,
                        @JsonProperty("zone_id") Long zoneId,
                        @JsonProperty("timestamp") Instant timestamp) {
        super(worldId, eventName);
        this.battleRank = battleRank;
        this.characterId = characterId;
        this.zoneId = zoneId;
        this.timestamp = timestamp;
    }

    public String getBattleRank() {
        return battleRank;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }


    @Override
    public String toString() {
        return "BattleRankUp{" +
                super.toString() +
                "battleRank='" + battleRank + '\'' +
                ", characterId=" + characterId +
                ", zoneId=" + zoneId +
                ", timestamp=" + timestamp +
                '}';
    }
}
