package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "event_name"
)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "AchievementEarned", value = AchievementEarned.class),
        @JsonSubTypes.Type(name = "BattleRankUp", value = BattleRankUp.class),
        @JsonSubTypes.Type(name = "Death", value = Death.class),
        @JsonSubTypes.Type(name = "GainExperience", value = GainExperience.class),
        @JsonSubTypes.Type(name = "ItemAdded", value = ItemAdded.class),
        @JsonSubTypes.Type(name = "PlayerFacilityCapture", value = PlayerFacilityCapture.class),
        @JsonSubTypes.Type(name = "PlayerFacilityDefend", value = PlayerFacilityDefend.class),
        @JsonSubTypes.Type(name = "SkillAdded", value = SkillAdded.class),
        @JsonSubTypes.Type(name = "VehicleDestroy", value = VehicleDestroy.class),

        @JsonSubTypes.Type(name = "PlayerLogin", value = PlayerLogin.class),
        @JsonSubTypes.Type(name = "PlayerLogout", value = PlayerLogout.class),

        @JsonSubTypes.Type(name = "ContinentLock", value = ContinentLock.class),
        @JsonSubTypes.Type(name = "ContinentUnlock", value = ContinentUnlock.class),
        @JsonSubTypes.Type(name = "FacilityControl", value = FacilityControl.class),
        @JsonSubTypes.Type(name = "MetagameEvent", value = MetagameEvent.class),
})
public abstract class GameCensusEvent {

    private CensusEventName eventName;

    public CensusEventName getEventName() {
        return eventName;
    }

    @JsonProperty("event_name")
    void setEventName(CensusEventName eventName) {
        this.eventName = eventName;
    }


}
