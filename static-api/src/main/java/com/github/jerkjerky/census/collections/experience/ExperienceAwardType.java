package com.github.jerkjerky.census.collections.experience;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExperienceAwardType {
    private final Long typeId;
    private final String name;

    @JsonCreator
    public ExperienceAwardType(@JsonProperty("experience_award_type_id") String typeId,
                               @JsonProperty("name") String name) {
        this.typeId = Long.parseLong(typeId);
        this.name = name;
    }

    public Long getTypeId() {
        return typeId;
    }

    public String getName() {
        return name;
    }
}
