package io.github.jerkjerky.census.collections.experience;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ExperienceResponse {

    private final List<Experience> experienceList;
    private final long returned;

    @JsonCreator
    protected ExperienceResponse(@JsonProperty("experience_list") List<Experience> experienceList,
                                 @JsonProperty("returned") long returned){
        this.experienceList = experienceList;
        this.returned = returned;
    }
}
