package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class FacilityControl extends GameCensusEvent {
    private WorldId worldId;
    private Long oldFactionId;
    private Long outfitId;
    private Long newFactionId;
    private Long facilityId;
    private String durationHeld;
    private Long zoneId;
    private Instant timestamp;

    public WorldId getWorldId() {
        return worldId;
    }

    @JsonProperty("world_id")
    void setWorldId(WorldId worldId) {
        this.worldId = worldId;
    }

    public Long getOldFactionId() {
        return oldFactionId;
    }

    @JsonProperty("old_faction_id")
    void setOldFactionId(Long oldFactionId) {
        this.oldFactionId = oldFactionId;
    }

    public Long getOutfitId() {
        return outfitId;
    }

    @JsonProperty("outfit_id")
    void setOutfitId(Long outfitId) {
        this.outfitId = outfitId;
    }

    public Long getNewFactionId() {
        return newFactionId;
    }

    @JsonProperty("new_faction_id")
    void setNewFactionId(Long newFactionId) {
        this.newFactionId = newFactionId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    @JsonProperty("facility_id")
    void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String getDurationHeld() {
        return durationHeld;
    }

    @JsonProperty("duration_held")
    void setDurationHeld(String durationHeld) {
        this.durationHeld = durationHeld;
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
        return "FacilityControl{" +
                "worldId=" + worldId +
                ", oldFactionId=" + oldFactionId +
                ", outfitId=" + outfitId +
                ", newFactionId=" + newFactionId +
                ", facilityId=" + facilityId +
                ", durationHeld='" + durationHeld + '\'' +
                ", zoneId=" + zoneId +
                ", timestamp=" + timestamp +
                '}';
    }
}
