package com.github.jerkjerky.census.collections.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.jerkjerky.census.collections.common.CachingRedirect;
import com.github.jerkjerky.census.collections.locations.Facility;
import com.github.jerkjerky.census.collections.locations.FacilityResponse;
import com.github.jerkjerky.census.collections.locations.Zone;
import okhttp3.HttpUrl;
import okhttp3.Request;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LocationClient {
    private static final HttpUrl CENSUS_MAP_REGION_URL = HttpUrl.parse("https://census.daybreakgames.com/get/ps2:v2/map_region");

    private final StaticContentClient staticContentClient;
    private final Map<Class<?>, CachingRedirect> cachingRedirectMap;
    private final Cache<Long, Facility> facilitiesByIdCache;
    private final Cache<Long, Zone> zonesByIdCache;

    public LocationClient(StaticContentClient staticContentClient,
                          Map<Class<?>, CachingRedirect> cachingRedirectMap) {
        this.staticContentClient = staticContentClient;
        this.cachingRedirectMap = cachingRedirectMap;
        this.facilitiesByIdCache = Caffeine.newBuilder()
                .maximumSize(20_000)
                .build();
        this.zonesByIdCache = Caffeine.newBuilder()
                .maximumSize(20_000)
                .build();
        cachingRedirectMap.put(Facility.class, new CachingRedirect<>(Facility.class, this::cacheFacility));
        cachingRedirectMap.put(Zone.class, new CachingRedirect<>(Zone.class, this::cacheZone));
    }

    private void cacheFacility(Facility facility) {
        facilitiesByIdCache.put(facility.getFacilityId(), facility);
    }

    private void cacheZone(Zone zone) {
        zonesByIdCache.put(zone.getZoneId(), zone);
    }

    public Facility fetchFacilityById(Long facilityId) {
        long estimatedSize = facilitiesByIdCache.estimatedSize();
        if (estimatedSize > 0) {
            return facilitiesByIdCache.getIfPresent(facilityId);
        }
        fetchAllMapRegionInfo();
        return facilitiesByIdCache.getIfPresent(facilityId);
    }

    public Zone fetchZoneById(Long facilityId) {
        long estimatedSize = zonesByIdCache.estimatedSize();
        if (estimatedSize > 0) {
            return zonesByIdCache.getIfPresent(facilityId);
        }
        fetchAllMapRegionInfo();
        return zonesByIdCache.getIfPresent(facilityId);
    }

    private void fetchAllMapRegionInfo() {
        Request request = new Request.Builder()
                .get()
                .url(CENSUS_MAP_REGION_URL.newBuilder()
                        .addEncodedQueryParameter("c:join", "zone")
                        .build())
                .build();
        TypeReference<FacilityResponse> outfitTypeReference = new TypeReference<>(){};
        FacilityResponse experienceResponse = this.staticContentClient.makeRequest(request, outfitTypeReference);
        List<Facility> facilityList = experienceResponse.getFacilityList();
        facilityList.forEach(facility -> {
            cacheFacility(facility);
            Optional.ofNullable(facility.getZone())
                    .ifPresent(this::cacheZone);
        });
    }


}
