package com.github.jerkjerky.census.collections.outfit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jerkjerky.census.collections.character.CharacterOutfitData;
import lombok.Getter;

import java.time.Instant;

@Getter
public class Outfit {
    private final Long outfitId;
    private final String name;
    private final String alias;
    private final Instant timeCreated;
    private final Long leaderCharacterId;
    private final Long memberCount;

    public static Outfit fromCharacterOutfitData(CharacterOutfitData characterOutfitData) {
        return new Outfit(
                String.valueOf(characterOutfitData.getOutfitId()),
                characterOutfitData.getOutfitName(),
                characterOutfitData.getOutfitAlias(),
                String.valueOf(characterOutfitData.getOutfitCreationTime().toEpochMilli()),
                String.valueOf(characterOutfitData.getLeaderCharacterId()),
                String.valueOf(characterOutfitData.getMemberCount())
        );
    }

    @JsonCreator
    protected Outfit(@JsonProperty("outfit_id") String outfitId,
                  @JsonProperty("name") String name,
                  @JsonProperty("alias") String alias,
                  @JsonProperty("time_created") String timeCreated,
                  @JsonProperty("leader_character_id") String leaderCharacterId,
                  @JsonProperty("member_count") String memberCount) {
        this.outfitId = Long.parseLong(outfitId);
        this.name = name;
        this.alias = alias;
        this.timeCreated = Instant.ofEpochMilli(Long.parseLong(timeCreated));
        this.leaderCharacterId = Long.parseLong(leaderCharacterId);
        this.memberCount = Long.parseLong(memberCount);
    }
}
