package com.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class CharacterBattleRank {
    private final Long percentToNext;
    private final Long value;

    @JsonCreator
    protected CharacterBattleRank(@JsonProperty("percent_to_next") String percentToNext,
                                  @JsonProperty("value") String value) {
        this.percentToNext = Long.parseLong(percentToNext);
        this.value = Long.parseLong(value);
    }

    @JsonProperty("percent_to_next")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getPercentToNext() {
        return percentToNext;
    }

    @JsonProperty("value")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getValue() {
        return value;
    }
}
