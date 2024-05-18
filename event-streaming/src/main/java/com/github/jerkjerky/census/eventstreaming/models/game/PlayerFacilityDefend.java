package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class PlayerFacilityDefend extends GameCensusEvent {
    private Long characterId;
    private Long facilityId;
    private Long outfitId;
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

    public Long getFacilityId() {
        return facilityId;
    }

    @JsonProperty("facility_id")
    void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public Long getOutfitId() {
        return outfitId;
    }

    @JsonProperty("outfit_id")
    void setOutfitId(Long outfitId) {
        this.outfitId = outfitId;
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
        return "PlayerFacilityDefend{" +
                "characterId=" + characterId +
                ", facilityId=" + facilityId +
                ", outfitId=" + outfitId +
                ", worldId=" + worldId +
                ", zoneId=" + zoneId +
                ", timestamp=" + timestamp +
                '}';
    }
}
