package io.github.jerkjerky.census.eventstreaming.client;

import io.github.jerkjerky.census.eventstreaming.models.service.*;
import io.github.jerkjerky.census.eventstreaming.models.game.GameCensusEvent;

public interface ServiceEventVisitor {

    default void visit(BasicCensusEvent event){
        if (event instanceof ConnectedServiceEvent) visitConnectedServiceEvent((ConnectedServiceEvent) event);
        if (event instanceof EndpointOnlineServiceEvent) visitEndpointOnlineServiceEvent((EndpointOnlineServiceEvent) event);
        if (event instanceof HeartbeatServiceEvent) visitHeartbeatServiceEvent((HeartbeatServiceEvent) event);
        if (event instanceof HelpServiceEvent) visitHelpServiceEvent((HelpServiceEvent) event);
        if (event instanceof PayloadServiceEvent) visitPayloadServiceEvent((PayloadServiceEvent) event);
        if (event instanceof SubscriptionInfoServiceEvent) visitSubscriptionInfoServiceEvent((SubscriptionInfoServiceEvent) event);
    }

    default void visitConnectedServiceEvent(ConnectedServiceEvent event){}

    default void visitEndpointOnlineServiceEvent(EndpointOnlineServiceEvent event){}

    default void visitHeartbeatServiceEvent(HeartbeatServiceEvent event){}

    default void visitHelpServiceEvent(HelpServiceEvent event){}

    default void visitPayloadServiceEvent(PayloadServiceEvent event){
        visitGameEvent(event.getPayload());
    }

    /**
     * Convinence method
     * @param gameCensusEvent
     */
    default void visitGameEvent(GameCensusEvent gameCensusEvent) {}

    default void visitSubscriptionInfoServiceEvent(SubscriptionInfoServiceEvent event) {}

}
