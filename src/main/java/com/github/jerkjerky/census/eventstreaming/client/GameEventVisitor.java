package com.github.jerkjerky.census.eventstreaming.client;

import com.github.jerkjerky.census.eventstreaming.models.game.*;

public interface GameEventVisitor {
    default void visit(GameCensusEvent event){
        if (event instanceof AchievementEarned) visitAchievementEarnedEvent((AchievementEarned) event);
        if (event instanceof BattleRankUp) visitBattleRankUpEvent((BattleRankUp) event);
        if (event instanceof ContinentLock) visitContinentLockEvent((ContinentLock) event);
        if (event instanceof ContinentUnlock) visitContinentUnlockEvent((ContinentUnlock) event);
        if (event instanceof Death) visitDeathEvent((Death) event);
        if (event instanceof FacilityControl) visitFacilityControlEvent((FacilityControl) event);
        if (event instanceof GainExperience) visitGainExperienceEvent((GainExperience) event);
        if (event instanceof ItemAdded) visitItemAddedEvent((ItemAdded) event);
        if (event instanceof MetagameEvent) visitMetagameEvent((MetagameEvent) event);
        if (event instanceof PlayerFacilityCapture) visitPlayerFacilityCaptureEvent((PlayerFacilityCapture) event);
        if (event instanceof PlayerFacilityDefend) visitPlayerFacilityDefendEvent((PlayerFacilityDefend) event);
        if (event instanceof PlayerLogin) visitPlayerLoginEvent((PlayerLogin) event);
        if (event instanceof PlayerLogout) visitPlayerLogoutEvent((PlayerLogout) event);
        if (event instanceof SkillAdded) visitSkillAddedEvent((SkillAdded) event);
        if (event instanceof VehicleDestroy) visitVehicleDestroyEvent((VehicleDestroy) event);
    }
    default void visitAchievementEarnedEvent(AchievementEarned event){}
    default void visitBattleRankUpEvent(BattleRankUp event){}
    default void visitContinentLockEvent(ContinentLock event){}
    default void visitContinentUnlockEvent(ContinentUnlock event){}
    default void visitDeathEvent(Death event){}
    default void visitFacilityControlEvent(FacilityControl event){}
    default void visitGainExperienceEvent(GainExperience event){}
    default void visitItemAddedEvent(ItemAdded event){}
    default void visitMetagameEvent(MetagameEvent event){}
    default void visitPlayerFacilityCaptureEvent(PlayerFacilityCapture event){}
    default void visitPlayerFacilityDefendEvent(PlayerFacilityDefend event){}
    default void visitPlayerLoginEvent(PlayerLogin event){}
    default void visitPlayerLogoutEvent(PlayerLogout event){}
    default void visitSkillAddedEvent(SkillAdded event){}
    default void visitVehicleDestroyEvent(VehicleDestroy event){}
}
