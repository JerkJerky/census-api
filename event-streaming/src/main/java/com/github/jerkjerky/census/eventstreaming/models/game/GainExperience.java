package io.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public final class GainExperience extends GameCensusEvent {
    private final Long amount;
    private final Long characterId;
    private final Long experienceId;
    private final Long loadoutId;
    private final Long otherId;
    private final Long teamId;
    private final Long zoneId;
    private final Instant timestamp;

    @JsonCreator
    public GainExperience(@JsonProperty("world_id") WorldId worldId,
                          @JsonProperty("event_name") CensusEventName eventName,
                          @JsonProperty("amount") Long amount,
                          @JsonProperty("character_id") Long characterId,
                          @JsonProperty("experience_id") Long experienceId,
                          @JsonProperty("loadout_id") Long loadoutId,
                          @JsonProperty("other_id") Long otherId,
                          @JsonProperty("team_id") Long teamId,
                          @JsonProperty("zone_id") Long zoneId,
                          @JsonProperty("timestamp") Instant timestamp) {
        super(worldId, eventName);
        this.amount = amount;
        this.characterId = characterId;
        this.experienceId = experienceId;
        this.loadoutId = loadoutId;
        this.otherId = otherId;
        this.teamId = teamId;
        this.zoneId = zoneId;
        this.timestamp = timestamp;
    }

    public Long getAmount() {
        return amount;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public Long getExperienceId() {
        return experienceId;
    }

    public Long getLoadoutId() {
        return loadoutId;
    }

    public Long getOtherId() {
        return otherId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "GainExperience{" +
                super.toString() +
                "amount=" + amount +
                ", characterId=" + characterId +
                ", experienceId=" + experienceId +
                ", loadoutId=" + loadoutId +
                ", otherId=" + otherId +
                ", teamId=" + teamId +
                ", zoneId=" + zoneId +
                ", timestamp=" + timestamp +
                '}';
    }
}
