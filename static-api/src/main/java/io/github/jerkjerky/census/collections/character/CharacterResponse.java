package io.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class CharacterResponse {
    private final List<Character> characters;
    private final long returned;

    @JsonCreator
    protected CharacterResponse(@JsonProperty("character_list") List<Character> characters,
                                @JsonProperty("returned") long returned) {
        this.characters = characters;
        this.returned = returned;
    }
}
