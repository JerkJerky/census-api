package io.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public final class PlayerLogout extends GameCensusEvent {
    private final Long characterId;
    private final Instant timestamp;

    @JsonCreator
    public PlayerLogout(@JsonProperty("world_id") WorldId worldId,
                        @JsonProperty("event_name") CensusEventName eventName,
                        @JsonProperty("character_id") Long characterId,
                        @JsonProperty("timestamp") Instant timestamp) {
        super(worldId, eventName);
        this.characterId = characterId;
        this.timestamp = timestamp;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "PlayerLogout{" +
                super.toString() +
                "characterId=" + characterId +
                ", timestamp=" + timestamp +
                '}';
    }
}
