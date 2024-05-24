package com.github.jerkjerky.census.collections.experience;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExperienceResponse {

    private final List<Experience> experienceList;
    private final long returned;

    @JsonCreator
    protected ExperienceResponse(@JsonProperty("experience_list") List<Experience> experienceList,
                                 @JsonProperty("returned") long returned){
        this.experienceList = experienceList;
        this.returned = returned;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public long getReturned() {
        return returned;
    }
}
