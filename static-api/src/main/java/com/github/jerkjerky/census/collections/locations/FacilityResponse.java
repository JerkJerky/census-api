package com.github.jerkjerky.census.collections.locations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class FacilityResponse {
    private final List<Facility> facilityList;
    private final long returned;

    @JsonCreator
    protected FacilityResponse(@JsonProperty("map_region_list") List<Facility> facilityList,
                               @JsonProperty("returned") long returned) {
        this.facilityList = facilityList;
        this.returned = returned;
    }
}
