package com.github.jerkjerky.census.collections.locations;

import com.github.jerkjerky.census.collections.client.LocationClient;
import com.github.jerkjerky.census.collections.client.StaticContentClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LocationsClientTests {
    private static final String SERVICE_ID = System.getenv("CENSUS_API_KEY");

    private final StaticContentClient staticContentClient = new StaticContentClient(SERVICE_ID);

    @Test
    void fetchFacility() {
        LocationClient locationsClient = staticContentClient.getLocationsClient();

        Facility facility = Assertions.assertDoesNotThrow(() -> locationsClient.fetchFacilityById(1L));

        Assertions.assertNotNull(facility);
    }

    @Test
    void fetchZone() {
        LocationClient locationsClient = staticContentClient.getLocationsClient();

        Zone zone = Assertions.assertDoesNotThrow(() -> locationsClient.fetchZoneById(1L));

        Assertions.assertNotNull(zone);
    }

}
