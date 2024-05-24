package io.github.jerkjerky.census.collections.outfit;

import io.github.jerkjerky.census.collections.client.OutfitClient;
import io.github.jerkjerky.census.collections.client.SearchModifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static io.github.jerkjerky.census.collections.TestSuite.CLIENT;

class OutfitClientTests {

    private Duration withTiming(Runnable runnable) {
        Instant start = Instant.now();
        runnable.run();
        return Duration.between(start, Instant.now());
    }

    @Test
    void askFor91arOutfitInfo() {
        OutfitClient outfitClient = CLIENT.getOutfitClient();

        Outfit outfit = Assertions.assertDoesNotThrow(() -> outfitClient.fetchOutfitByAlias("91AR"));

        Assertions.assertEquals("91AR", outfit.getAlias());
    }

    @Test
    void askForOutfitWithAliasesLike91s() {
        OutfitClient outfitClient = CLIENT.getOutfitClient();

        List<Outfit> outfit = Assertions.assertDoesNotThrow(() -> outfitClient.fetchOutfitByAlias("91S", SearchModifier.CONTAINS));

        Assertions.assertFalse(outfit.isEmpty());
    }

    @Test
    void askForOutfitsBiggerThan5000Members() {
        OutfitClient outfitClient = CLIENT.getOutfitClient();

        List<Outfit> outfit = Assertions.assertDoesNotThrow(() -> outfitClient.fetchOutfitsByMemberCount(5000L, SearchModifier.GREATER_THAN_OR_EQUAL));

        Assertions.assertFalse(outfit.isEmpty());
    }

    @Test
    void askForOutfitsWithNameContainingNC() {
        OutfitClient outfitClient = CLIENT.getOutfitClient();

        List<Outfit> outfit = Assertions.assertDoesNotThrow(() -> outfitClient.fetchOutfitsWithName("New", SearchModifier.CONTAINS));

        Assertions.assertFalse(outfit.isEmpty());
    }

}
