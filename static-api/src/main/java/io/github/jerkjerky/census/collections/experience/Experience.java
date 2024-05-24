package io.github.jerkjerky.census.collections.experience;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Optional;

@Getter
public class Experience {
    private final Long id;
    private final String description;
    private final Double xp;
    private final Long experienceAwardTypeId;
    private final ExperienceAwardType experienceAwardType;


    @JsonCreator
    protected Experience(@JsonProperty("experience_id") String id,
                         @JsonProperty("description") String description,
                         @JsonProperty("xp") String xp,
                         @JsonProperty("experience_award_type_id") String experienceAwardTypeId,
                         @JsonProperty("experience_award_type_id_join_experience_award_type") ExperienceAwardType experienceAwardType) {
        this.id = Long.parseLong(id);
        this.description = description;
        this.xp = Optional.ofNullable(xp).map(Double::parseDouble).orElse(null);
        this.experienceAwardTypeId = Optional.ofNullable(experienceAwardTypeId).map(Long::parseLong).orElse(null);
        this.experienceAwardType = experienceAwardType;
    }
}
