package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class ContinentLock extends GameCensusEvent {
    private WorldId worldId;
    private Long zoneId;
    private String triggeringFaction;
    private String previousFaction;
    private Long vsPopulation;
    private Long ncPopulation;
    private Long trPopulation;
    private Long metagameEventId;
    private String eventType;
    private Instant timestamp;


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

    public String getTriggeringFaction() {
        return triggeringFaction;
    }

    @JsonProperty("triggering_faction")
    void setTriggeringFaction(String triggeringFaction) {
        this.triggeringFaction = triggeringFaction;
    }

    public String getPreviousFaction() {
        return previousFaction;
    }

    @JsonProperty("previous_faction")
    void setPreviousFaction(String previousFaction) {
        this.previousFaction = previousFaction;
    }

    public Long getVsPopulation() {
        return vsPopulation;
    }

    @JsonProperty("vs_population")
    void setVsPopulation(Long vsPopulation) {
        this.vsPopulation = vsPopulation;
    }

    public Long getNcPopulation() {
        return ncPopulation;
    }

    @JsonProperty("nc_population")
    void setNcPopulation(Long ncPopulation) {
        this.ncPopulation = ncPopulation;
    }

    public Long getTrPopulation() {
        return trPopulation;
    }

    @JsonProperty("tr_population")
    void setTrPopulation(Long trPopulation) {
        this.trPopulation = trPopulation;
    }

    public Long getMetagameEventId() {
        return metagameEventId;
    }

    @JsonProperty("metagame_event_id")
    void setMetagameEventId(Long metagameEventId) {
        this.metagameEventId = metagameEventId;
    }

    public String getEventType() {
        return eventType;
    }

    @JsonProperty("event_type")
    void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    void setTimestamp(String timestamp) {
        this.timestamp = Instant.ofEpochMilli(Long.parseLong(timestamp));
    }
}
