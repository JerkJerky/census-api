package com.github.jerkjerky.census.collections.locations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jerkjerky.census.collections.common.I18nProperty;
import lombok.Getter;

@Getter
public class Zone {
    private final Long zoneId;
    private final String code;
    private final Long hexSize;
    private final I18nProperty name;
    private final I18nProperty description;
    private final Long geometryId;
    private final boolean isDynamic;


    @JsonCreator
    protected Zone(@JsonProperty("zone_id") Long zoneId,
                   @JsonProperty("code") String code,
                   @JsonProperty("hex_size") Long hexSize,
                   @JsonProperty("name") I18nProperty name,
                   @JsonProperty("description") I18nProperty description,
                   @JsonProperty("geometry_id") Long geometryId,
                   @JsonProperty("dynamic") boolean isDynamic) {
        this.zoneId = zoneId;
        this.code = code;
        this.hexSize = hexSize;
        this.name = name;
        this.description = description;
        this.geometryId = geometryId;
        this.isDynamic = isDynamic;
    }
}
