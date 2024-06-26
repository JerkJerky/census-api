package io.github.jerkjerky.census.eventstreaming.models.game;

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
public sealed abstract class GameCensusEvent
        permits AchievementEarned, BattleRankUp, ContinentLock, ContinentUnlock,
        Death, FacilityControl, GainExperience, ItemAdded,
        MetagameEvent, PlayerFacilityCapture, PlayerFacilityDefend, PlayerLogin,
        PlayerLogout, SkillAdded, VehicleDestroy {

    private final WorldId worldId;
    private final CensusEventName eventName;

    protected GameCensusEvent(WorldId worldId, CensusEventName eventName) {
        this.worldId = worldId;
        this.eventName = eventName;
    }

    public CensusEventName getEventName() {
        return eventName;
    }

    public WorldId getWorldId() {
        return worldId;
    }

    @Override
    public String toString() {
        return "GameCensusEvent{" +
                "worldId=" + worldId +
                ", eventName=" + eventName +
                '}';
    }
}
