package io.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Optional;

public final class Death extends GameCensusEvent {

    private final Long attackerCharacterId;
    private final Long attackerFireModeId;
    private final Long attackerLoadoutId;
    private final Long attackerTeamId;
    private final Long attackerVehicleId;
    private final Long attackerWeaponId;
    private final Long characterId;
    private final Long characterLoadoutId;
    private final Boolean isCritical;
    private final Boolean isHeadshot;
    private final Long teamId;
    private final Long vehicleId;
    private final Long zoneId;
    private final Instant timestamp;

    @JsonCreator
    public Death(@JsonProperty("world_id") WorldId worldId,
                 @JsonProperty("event_name") CensusEventName eventName,
                 @JsonProperty("attacker_character_id") Long attackerCharacterId,
                 @JsonProperty("attacker_fire_mode_id") Long attackerFireModeId,
                 @JsonProperty("attacker_loadout_id") Long attackerLoadoutId,
                 @JsonProperty("attacker_team_id") Long attackerTeamId,
                 @JsonProperty("attacker_vehicle_id") Long attackerVehicleId,
                 @JsonProperty("attacker_weapon_id") Long attackerWeaponId,
                 @JsonProperty("character_id") Long characterId,
                 @JsonProperty("character_loadout_id") Long characterLoadoutId,
                 @JsonProperty("is_critical") CensusBoolean isCritical,
                 @JsonProperty("is_headshot") CensusBoolean isHeadshot,
                 @JsonProperty("team_id") Long teamId,
                 @JsonProperty("vehicle_id") Long vehicleId,
                 @JsonProperty("zone_id") Long zoneId,
                 @JsonProperty("timestamp") Instant timestamp) {
        super(worldId, eventName);
        this.attackerCharacterId = attackerCharacterId;
        this.attackerFireModeId = attackerFireModeId;
        this.attackerLoadoutId = attackerLoadoutId;
        this.attackerTeamId = attackerTeamId;
        this.attackerVehicleId = attackerVehicleId;
        this.attackerWeaponId = attackerWeaponId;
        this.characterId = characterId;
        this.characterLoadoutId = characterLoadoutId;
        this.isCritical = isCritical.isValue();
        this.isHeadshot = isHeadshot.isValue();
        this.teamId = teamId;
        this.vehicleId = vehicleId;
        this.zoneId = zoneId;
        this.timestamp = timestamp;
    }

    public Long getAttackerCharacterId() {
        return attackerCharacterId;
    }

    public Long getAttackerFireModeId() {
        return attackerFireModeId;
    }

    public Long getAttackerLoadoutId() {
        return attackerLoadoutId;
    }

    public Long getAttackerTeamId() {
        return attackerTeamId;
    }

    public Long getAttackerVehicleId() {
        return attackerVehicleId;
    }

    public Long getAttackerWeaponId() {
        return attackerWeaponId;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public Long getCharacterLoadoutId() {
        return characterLoadoutId;
    }

    public Boolean getCritical() {
        return isCritical;
    }

    public Boolean getHeadshot() {
        return isHeadshot;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Optional<Long> getVehicleId() {
        return Optional.ofNullable(vehicleId);
    }

    public Long getZoneId() {
        return zoneId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Death{" +
                super.toString() +
                "attackerCharacterId=" + attackerCharacterId +
                ", attackerFireModeId=" + attackerFireModeId +
                ", attackerLoadoutId=" + attackerLoadoutId +
                ", attackerTeamId=" + attackerTeamId +
                ", attackerVehicleId=" + attackerVehicleId +
                ", attackerWeaponId=" + attackerWeaponId +
                ", characterId=" + characterId +
                ", characterLoadoutId=" + characterLoadoutId +
                ", isCritical=" + isCritical +
                ", isHeadshot=" + isHeadshot +
                ", teamId=" + teamId +
                ", vehicleId=" + vehicleId +
                ", zoneId=" + zoneId +
                ", timestamp=" + timestamp +
                '}';
    }
}
