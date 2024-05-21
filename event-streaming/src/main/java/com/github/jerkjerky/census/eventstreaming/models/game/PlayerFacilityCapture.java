package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class PlayerFacilityCapture extends GameCensusEvent {
    private final Long characterId;
    private final Long facilityId;
    private final Long outfitId;
    private final Long zoneId;
    private final Instant timestamp;

    @JsonCreator
    public PlayerFacilityCapture(@JsonProperty("world_id") WorldId worldId,
                                 @JsonProperty("event_name") CensusEventName eventName,
                                 @JsonProperty("character_id") Long characterId,
                                 @JsonProperty("facility_id") Long facilityId,
                                 @JsonProperty("outfit_id") Long outfitId,
                                 @JsonProperty("zone_id") Long zoneId,
                                 @JsonProperty("timestamp") Instant timestamp) {
        super(worldId, eventName);
        this.characterId = characterId;
        this.facilityId = facilityId;
        this.outfitId = outfitId;
        this.zoneId = zoneId;
        this.timestamp = timestamp;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public Long getOutfitId() {
        return outfitId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "PlayerFacilityCapture{" +
                super.toString() +
                "characterId=" + characterId +
                ", facilityId=" + facilityId +
                ", outfitId=" + outfitId +
                ", zoneId=" + zoneId +
                ", timestamp=" + timestamp +
                '}';
    }
}
