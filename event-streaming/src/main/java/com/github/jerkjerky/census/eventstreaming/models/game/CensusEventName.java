package io.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CensusEventName {
    @JsonProperty("AchievementEarned")      ACHIEVEMENT_EARNED,
    @JsonProperty("BattleRankUp")           BATTLE_RANK_UP,
    @JsonProperty("Death")                  DEATH,
    @JsonProperty("GainExperience")         GAIN_EXPERIENCE,
    @JsonProperty("ItemAdded")              ITEM_ADDED,
    @JsonProperty("PlayerFacilityCapture")  PLAYER_FACILITY_CAPTURE,
    @JsonProperty("PlayerFacilityDefend")   PLAYER_FACILITY_DEFEND,
    @JsonProperty("SkillAdded")             SKILL_ADDED,
    @JsonProperty("VehicleDestroy")         VEHICLE_DESTROY,
    @JsonProperty("PlayerLogin")            PLAYER_LOGIN,
    @JsonProperty("PlayerLogout")           PLAYER_LOGOUT,
    @JsonProperty("ContinentLock")          CONTINENT_LOCK,
    @JsonProperty("ContinentUnlock")        CONTINENT_UNLOCK,
    @JsonProperty("FacilityControl")        FACILITY_CONTROL,
    @JsonProperty("MetagameEvent")          METAGAME_EVENT
}
