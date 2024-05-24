package io.github.jerkjerky.census.collections.character;

import io.github.jerkjerky.census.collections.client.CharacterClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.github.jerkjerky.census.collections.TestSuite.CLIENT;

class CharacterClientTests {

    @Test
    void fetchJerkJerkyProfileById() {
        CharacterClient characterClient = CLIENT.getCharacterClient();

        Character character = Assertions.assertDoesNotThrow(() -> characterClient.fetchCharacterById(8252468702026658913L));

        Assertions.assertEquals(character.getCharacterName().getFirst(), "JerkJerky");
    }

    @Test
    void fetchJerkJerkyProfileByName() {
        CharacterClient characterClient = CLIENT.getCharacterClient();

        Character character = Assertions.assertDoesNotThrow(() -> characterClient.fetchCharacterByName("JerkJerky"));

        Assertions.assertEquals(character.getCharacterName().getFirst(), "JerkJerky");
    }

    @Test
    void fetchGelarddProfileByName() {
        CharacterClient characterClient = CLIENT.getCharacterClient();

        Character character = Assertions.assertDoesNotThrow(() -> characterClient.fetchCharacterByName("Gelardd"));

        Assertions.assertEquals(character.getCharacterName().getFirst(), "Gelardd");
    }
}
