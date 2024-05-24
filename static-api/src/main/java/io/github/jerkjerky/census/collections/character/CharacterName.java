package io.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CharacterName {
    private final String first;

    @JsonCreator
    protected CharacterName(@JsonProperty("first") String first) {
        this.first = first;
    }
}
