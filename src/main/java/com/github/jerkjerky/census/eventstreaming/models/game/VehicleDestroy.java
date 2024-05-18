package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class VehicleDestroy extends GameCensusEvent {
    private Long attackerCharacterId;
    private Long attackerLoadoutId;
    private Long attackerTeamId;
    private Long attackerVehicleId;
    private Long attackerWeaponId;
    private Long characterId;
    private Long facilityId;
    private Long factionId;
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

    public Long getFacilityId() {
        return facilityId;
    }

    @JsonProperty("facility_id")
    void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public Long getFactionId() {
        return factionId;
    }

    @JsonProperty("faction_id")
    void setFactionId(Long factionId) {
        this.factionId = factionId;
    }

    public Long getTeamId() {
        return teamId;
    }

    @JsonProperty("team_id")
    void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getVehicleId() {
        return vehicleId;
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
