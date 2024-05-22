package com.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CharacterResponse {
    private final List<Character> characters;
    private final long returned;

    @JsonCreator
    protected CharacterResponse(@JsonProperty("character_list") List<Character> characters,
                                @JsonProperty("returned") long returned) {
        this.characters = characters;
        this.returned = returned;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public long getReturned() {
        return returned;
    }
}
