package com.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.jerkjerky.census.collections.serializers.InstantToMillisLongSerializer;

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

    @JsonProperty("count")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getCount() {
        return count;
    }

    @JsonProperty("time")
    @JsonSerialize(using = InstantToMillisLongSerializer.class)
    public Instant getTime() {
        return time;
    }
}
