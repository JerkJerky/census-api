package com.github.jerkjerky.census.collections.character;

import com.github.jerkjerky.census.collections.client.CharacterClient;
import com.github.jerkjerky.census.collections.client.StaticContentClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterClientTests {

    private static final String SERVICE_ID = System.getenv("CENSUS_API_KEY");

    private final StaticContentClient staticContentClient = new StaticContentClient(SERVICE_ID);

    @Test
    void fetchJerkJerkyProfileById() {
        CharacterClient characterClient = staticContentClient.getCharacterClient();

        Character character = Assertions.assertDoesNotThrow(() -> characterClient.fetchCharacterById(8252468702026658913L));

        Assertions.assertEquals(character.getCharacterName().getFirst(), "JerkJerky");
    }

    @Test
    void fetchJerkJerkyProfileByName() {
        CharacterClient characterClient = staticContentClient.getCharacterClient();

        Character character = Assertions.assertDoesNotThrow(() -> characterClient.fetchCharacterByName("JerkJerky"));

        Assertions.assertEquals(character.getCharacterName().getFirst(), "JerkJerky");
    }

    @Test
    void fetchGelarddProfileByName() {
        CharacterClient characterClient = staticContentClient.getCharacterClient();

        Character character = Assertions.assertDoesNotThrow(() -> characterClient.fetchCharacterByName("Gelardd"));

        Assertions.assertEquals(character.getCharacterName().getFirst(), "Gelardd");
    }
}
