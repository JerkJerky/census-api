package com.github.jerkjerky.census.collections.outfit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class OutfitResponse {
    private final List<Outfit> outfitList;
    private final long returned;

    @JsonCreator
    protected OutfitResponse(@JsonProperty("outfit_list") List<Outfit> outfitList,
                   @JsonProperty("returned") long returned) {
        this.outfitList = outfitList;
        this.returned = returned;
    }

    public List<Outfit> getOutfitList() {
        return outfitList;
    }

    public long getReturned() {
        return returned;
    }
}
