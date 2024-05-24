package com.github.jerkjerky.census.collections.outfit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class OutfitResponse {
    private final List<Outfit> outfitList;
    private final long returned;

    @JsonCreator
    protected OutfitResponse(@JsonProperty("outfit_list") List<Outfit> outfitList,
                   @JsonProperty("returned") long returned) {
        this.outfitList = outfitList;
        this.returned = returned;
    }
}
