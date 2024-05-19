package com.github.jerkjerky.census.eventstreaming.models.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class HelpServiceEvent extends BasicCensusEvent {
    private HelpEventContent helpEventContent;

    @JsonProperty("send this for help")
    public void setHelpEventContent(HelpEventContent helpEventContent) {
        this.helpEventContent = helpEventContent;
    }

    public HelpEventContent getHelpEventContent() {
        return helpEventContent;
    }

    @Override
    public String toString() {
        return "HelpServiceEvent{" +
                "helpEventContent=" + helpEventContent +
                '}';
    }
}
