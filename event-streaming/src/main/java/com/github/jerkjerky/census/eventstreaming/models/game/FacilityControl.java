package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public final class FacilityControl extends GameCensusEvent {
    private final Long oldFactionId;
    private final Long outfitId;
    private final Long newFactionId;
    private final Long facilityId;
    private final String durationHeld;
    private final Long zoneId;
    private final Instant timestamp;

    @JsonCreator
    public FacilityControl(@JsonProperty("world_id") WorldId worldId,
                           @JsonProperty("event_name") CensusEventName eventName,
                           @JsonProperty("old_faction_id") Long oldFactionId,
                           @JsonProperty("outfit_id") Long outfitId,
                           @JsonProperty("new_faction_id") Long newFactionId,
                           @JsonProperty("facility_id") Long facilityId,
                           @JsonProperty("duration_held") String durationHeld,
                           @JsonProperty("zone_id") Long zoneId,
                           @JsonProperty("timestamp") Instant timestamp) {
        super(worldId, eventName);
        this.oldFactionId = oldFactionId;
        this.outfitId = outfitId;
        this.newFactionId = newFactionId;
        this.facilityId = facilityId;
        this.durationHeld = durationHeld;
        this.zoneId = zoneId;
        this.timestamp = timestamp;
    }

    public Long getOldFactionId() {
        return oldFactionId;
    }

    public Long getOutfitId() {
        return outfitId;
    }

    public Long getNewFactionId() {
        return newFactionId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public String getDurationHeld() {
        return durationHeld;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "FacilityControl{" +
                super.toString() +
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
