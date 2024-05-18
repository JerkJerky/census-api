package com.github.jerkjerky.census.eventstreaming.models.game;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum WorldId {
    @JsonProperty("1")      CONNERY(1),
    @JsonProperty("10")     MILLER(10),
    @JsonProperty("13")     COBALT(13),
    @JsonProperty("17")     EMERALD(17),
    @JsonProperty("19")     JAEGER(19),
    @JsonProperty("40")     SOLTECH(40),
    ;

    private final int worldId;

    WorldId(int worldId) {
        this.worldId = worldId;
    }

    public int getWorldId() {
        return worldId;
    }
}
