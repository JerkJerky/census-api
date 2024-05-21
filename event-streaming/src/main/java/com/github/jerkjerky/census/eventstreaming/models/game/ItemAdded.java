package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class ItemAdded extends GameCensusEvent {
    private final Long characterId;
    private final String context;
    private final Long itemCount;
    private final Long itemId;
    private final Long zoneId;
    private final Instant timestamp;

    @JsonCreator
    public ItemAdded(@JsonProperty("world_id") WorldId worldId,
                     @JsonProperty("event_name") CensusEventName eventName,
                     @JsonProperty("character_id") Long characterId,
                     @JsonProperty("context") String context,
                     @JsonProperty("item_count") Long itemCount,
                     @JsonProperty("item_id") Long itemId,
                     @JsonProperty("zone_id") Long zoneId,
                     @JsonProperty("timestamp") Instant timestamp) {
        super(worldId, eventName);
        this.characterId = characterId;
        this.context = context;
        this.itemCount = itemCount;
        this.itemId = itemId;
        this.zoneId = zoneId;
        this.timestamp = timestamp;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public String getContext() {
        return context;
    }

    public Long getItemCount() {
        return itemCount;
    }

    public Long getItemId() {
        return itemId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ItemAdded{" +
                super.toString() +
                "characterId=" + characterId +
                ", context='" + context + '\'' +
                ", itemCount=" + itemCount +
                ", itemId=" + itemId +
                ", zoneId=" + zoneId +
                ", timestamp=" + timestamp +
                '}';
    }
}
