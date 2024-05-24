package com.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class CharacterDailyRibbon {
    private final Long count;
    private final Instant time;

    @JsonCreator
    protected CharacterDailyRibbon(@JsonProperty("count") Long count,
                                   @JsonProperty("time") Instant time) {
        this.count = count;
        this.time = time;
    }

    public Long getCount() {
        return count;
    }

    public Instant getTime() {
        return time;
    }
}
