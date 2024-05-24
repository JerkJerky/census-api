package com.github.jerkjerky.census.collections.experience;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Experience {
    private final Long id;
    private final String description;
    private final Long xp;
    private final Long experienceAwardTypeId;
    private final ExperienceAwardType experienceAwardType;


    @JsonCreator
    public Experience(@JsonProperty("experience_id") String id,
                      @JsonProperty("description") String description,
                      @JsonProperty("xp") String xp,
                      @JsonProperty("experience_award_type_id") String experienceAwardTypeId,
                      @JsonProperty("experience_award_type_id_join_experience_award_type") ExperienceAwardType experienceAwardType) {
        this.id = Long.parseLong(id);
        this.description = description;
        this.xp = Long.parseLong(xp);
        this.experienceAwardTypeId = Long.parseLong(experienceAwardTypeId);
        this.experienceAwardType = experienceAwardType;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Long getXp() {
        return xp;
    }

    public Long getExperienceAwardTypeId() {
        return experienceAwardTypeId;
    }

    public ExperienceAwardType getExperienceAwardType() {
        return experienceAwardType;
    }
}
