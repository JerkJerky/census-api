package io.github.jerkjerky.census.collections.locations;

import io.github.jerkjerky.census.collections.client.LocationClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.github.jerkjerky.census.collections.TestSuite.CLIENT;

class LocationsClientTests {
    @Test
    void fetchHvarTechPlantFacility() {
        LocationClient locationsClient = CLIENT.getLocationsClient();

        Facility facility = Assertions.assertDoesNotThrow(() -> locationsClient.fetchFacilityById(2101L));

        Assertions.assertNotNull(facility);
    }

    @Test
    void fetchIndarZone() {
        LocationClient locationsClient = CLIENT.getLocationsClient();

        Zone zone = Assertions.assertDoesNotThrow(() -> locationsClient.fetchZoneById(2L));

        Assertions.assertNotNull(zone);
    }

}
