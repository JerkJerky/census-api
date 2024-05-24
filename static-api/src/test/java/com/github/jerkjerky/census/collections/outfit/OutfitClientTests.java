package com.github.jerkjerky.census.collections.outfit;

import com.github.jerkjerky.census.collections.client.OutfitClient;
import com.github.jerkjerky.census.collections.client.SearchModifier;
import com.github.jerkjerky.census.collections.client.StaticContentClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

class OutfitClientTests {
    private final Logger logger = LoggerFactory.getLogger(OutfitClientTests.class);

    private static final String SERVICE_ID = System.getenv("CENSUS_API_KEY");

    private final StaticContentClient staticContentClient = new StaticContentClient(SERVICE_ID);


    private Duration withTiming(Runnable runnable) {
        Instant start = Instant.now();
        runnable.run();
        return Duration.between(start, Instant.now());
    }

    @Test
    void askFor91arOutfitInfo() {
        OutfitClient outfitClient = staticContentClient.getOutfitClient();

        Instant startFirst = Instant.now();
        Outfit outfit = Assertions.assertDoesNotThrow(() -> outfitClient.fetchOutfitByAlias("91AR"));
        Duration firstFetch = Duration.between(startFirst, Instant.now());
        Assertions.assertEquals("91AR", outfit.getAlias());

        Duration secondFetch = withTiming(() -> outfitClient.fetchOutfitByAlias("91AR"));
        Duration thirdFetch = withTiming(() -> outfitClient.fetchOutfitByAlias("91AR"));
        Assertions.assertTrue(firstFetch.toMillis() > secondFetch.toMillis());
        Assertions.assertTrue(firstFetch.toMillis() > thirdFetch.toMillis());
    }

    @Test
    void askForOutfitWithAliasesLike91s() {
        OutfitClient outfitClient = staticContentClient.getOutfitClient();

        List<Outfit> outfit = Assertions.assertDoesNotThrow(() -> outfitClient.fetchOutfitByAlias("91S", SearchModifier.CONTAINS));

        Assertions.assertFalse(outfit.isEmpty());
    }

    @Test
    void askForOutfitsBiggerThan5000Members() {
        OutfitClient outfitClient = staticContentClient.getOutfitClient();

        List<Outfit> outfit = Assertions.assertDoesNotThrow(() -> outfitClient.fetchOutfitsByMemberCount(5000L, SearchModifier.GREATER_THAN_OR_EQUAL));

        Assertions.assertFalse(outfit.isEmpty());
    }

    @Test
    void askForOutfitsWithNameContainingNC() {
        OutfitClient outfitClient = staticContentClient.getOutfitClient();

        List<Outfit> outfit = Assertions.assertDoesNotThrow(() -> outfitClient.fetchOutfitsWithName("New", SearchModifier.CONTAINS));

        Assertions.assertFalse(outfit.isEmpty());
    }


}
