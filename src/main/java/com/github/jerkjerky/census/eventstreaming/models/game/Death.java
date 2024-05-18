package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Optional;

public class Death extends GameCensusEvent {

    private Long attackerCharacterId;
    private Long attackerFireModeId;
    private Long attackerLoadoutId;
    private Long attackerTeamId;
    private Long attackerVehicleId;
    private Long attackerWeaponId;
    private Long characterId;
    private Long characterLoadoutId;
    private Boolean isCritical;
    private Boolean isHeadshot;
    private Long teamId;
    private Long vehicleId;
    private WorldId worldId;
    private Long zoneId;
    private Instant timestamp;

    public Long getAttackerCharacterId() {
        return attackerCharacterId;
    }

    @JsonProperty("attacker_character_id")
    void setAttackerCharacterId(Long attackerCharacterId) {
        this.attackerCharacterId = attackerCharacterId;
    }

    public Long getAttackerFireModeId() {
        return attackerFireModeId;
    }

    @JsonProperty("attacker_fire_mode_id")
    void setAttackerFireModeId(Long attackerFireModeId) {
        this.attackerFireModeId = attackerFireModeId;
    }

    public Long getAttackerLoadoutId() {
        return attackerLoadoutId;
    }

    @JsonProperty("attacker_loadout_id")
    void setAttackerLoadoutId(Long attackerLoadoutId) {
        this.attackerLoadoutId = attackerLoadoutId;
    }

    public Long getAttackerTeamId() {
        return attackerTeamId;
    }

    @JsonProperty("attacker_team_id")
    void setAttackerTeamId(Long attackerTeamId) {
        this.attackerTeamId = attackerTeamId;
    }

    public Long getAttackerVehicleId() {
        return attackerVehicleId;
    }

    @JsonProperty("attacker_vehicle_id")
    void setAttackerVehicleId(Long attackerVehicleId) {
        this.attackerVehicleId = attackerVehicleId;
    }

    public Long getAttackerWeaponId() {
        return attackerWeaponId;
    }

    @JsonProperty("attacker_weapon_id")
    void setAttackerWeaponId(Long attackerWeaponId) {
        this.attackerWeaponId = attackerWeaponId;
    }

    public Long getCharacterId() {
        return characterId;
    }

    @JsonProperty("character_id")
    void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public Long getCharacterLoadoutId() {
        return characterLoadoutId;
    }

    @JsonProperty("character_loadout_id")
    void setCharacterLoadoutId(Long characterLoadoutId) {
        this.characterLoadoutId = characterLoadoutId;
    }

    public Boolean getCritical() {
        return isCritical;
    }

    @JsonProperty("is_critical")
    void setCritical(CensusBoolean critical) {
        isCritical = critical.isValue();
    }

    public Boolean getHeadshot() {
        return isHeadshot;
    }

    @JsonProperty("is_headshot")
    void setHeadshot(CensusBoolean headshot) {
        isHeadshot = headshot.isValue();
    }

    public Long getTeamId() {
        return teamId;
    }

    @JsonProperty("team_id")
    void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Optional<Long> getVehicleId() {
        return Optional.ofNullable(vehicleId);
    }

    @JsonProperty("vehicle_id")
    void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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
