package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class ItemAdded extends GameCensusEvent {
    private Long characterId;
    private String context;
    private Long itemCount;
    private Long itemId;
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

    public String getContext() {
        return context;
    }

    @JsonProperty("context")
    void setContext(String context) {
        this.context = context;
    }

    public Long getItemCount() {
        return itemCount;
    }

    @JsonProperty("item_count")
    void setItemCount(Long itemCount) {
        this.itemCount = itemCount;
    }

    public Long getItemId() {
        return itemId;
    }

    @JsonProperty("item_id")
    void setItemId(Long itemId) {
        this.itemId = itemId;
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
}
