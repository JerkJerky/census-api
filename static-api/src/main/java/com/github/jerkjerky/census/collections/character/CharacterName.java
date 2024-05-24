package com.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterName {
    private final String first;

    @JsonCreator
    protected CharacterName(@JsonProperty("first") String first) {
        this.first = first;
    }

    public String getFirst() {
        return first;
    }
}
