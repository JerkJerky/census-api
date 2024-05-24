package com.github.jerkjerky.census.collections.locations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jerkjerky.census.collections.currency.CaptureReward;
import com.github.jerkjerky.census.collections.currency.TickReward;
import lombok.Getter;

@Getter
public class Facility {
    private final Long mapRegionId;
    private final Long zoneId;
    private final Long facilityId;
    private final String facilityName;
    private final Long facilityTypeId;
    private final String facilityType;
    private final Double locationX;
    private final Double locationY;
    private final Double locationZ;
    private final Long rewardAmount;
    private final Long rewardCurrencyId;
    private final CaptureReward captureReward;
    private final TickReward tickReward;
    private final Zone zone;

    @JsonCreator
    protected Facility(@JsonProperty("map_region_id") Long mapRegionId,
             @JsonProperty("zone_id") Long zoneId,
             @JsonProperty("facility_id") Long facilityId,
             @JsonProperty("facility_name") String facilityName,
             @JsonProperty("facility_type_id") Long facilityTypeId,
             @JsonProperty("facility_type") String facilityType,
             @JsonProperty("location_x") Double locationX,
             @JsonProperty("location_y") Double locationY,
             @JsonProperty("location_z") Double locationZ,
             @JsonProperty("reward_amount") Long rewardAmount,
             @JsonProperty("reward_currency_id") Long rewardCurrencyId,
             @JsonProperty("capture_reward") CaptureReward captureReward,
             @JsonProperty("tick_reward") TickReward tickReward,
             @JsonProperty("zone_id_join_zone") Zone zone) {
        this.mapRegionId = mapRegionId;
        this.zoneId = zoneId;
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityTypeId = facilityTypeId;
        this.facilityType = facilityType;
        this.locationX = locationX;
        this.locationY = locationY;
        this.locationZ = locationZ;
        this.rewardAmount = rewardAmount;
        this.rewardCurrencyId = rewardCurrencyId;
        this.captureReward = captureReward;
        this.tickReward = tickReward;
        this.zone = zone;
    }
}
