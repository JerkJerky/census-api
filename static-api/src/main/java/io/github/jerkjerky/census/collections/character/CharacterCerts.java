package io.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CharacterCerts {
    private final Long earnedPoints;
    private final Long giftedPoints;
    private final Long spentPoints;
    private final Long availablePoints;
    private final Double percentToNext;

    @JsonCreator
    protected CharacterCerts(@JsonProperty("earned_points") String earnedPoints,
                   @JsonProperty("gifted_points") String giftedPoints,
                   @JsonProperty("spent_points") String spentPoints,
                   @JsonProperty("available_points") String availablePoints,
                   @JsonProperty("percent_to_next") String percentToNext) {
        this.earnedPoints = Long.parseLong(earnedPoints);
        this.giftedPoints = Long.parseLong(giftedPoints);
        this.spentPoints = Long.parseLong(spentPoints);
        this.availablePoints = Long.parseLong(availablePoints);
        this.percentToNext = Double.parseDouble(percentToNext);
    }
}
