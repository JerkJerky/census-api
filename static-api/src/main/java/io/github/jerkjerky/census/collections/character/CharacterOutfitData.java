package io.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.Instant;

@Getter
public class CharacterOutfitData {
    private final Instant memberSince;
    private final String memberRank;
    private final Long memberRankOrdinal;
    private final Long outfitId;
    private final String outfitName;
    private final String outfitAlias;
    private final Instant outfitCreationTime;
    private final Long leaderCharacterId;
    private final Long memberCount;

    @JsonCreator
    protected CharacterOutfitData(@JsonProperty("member_since") String memberSince,
                                  @JsonProperty("member_rank") String memberRank,
                                  @JsonProperty("member_rank_ordinal") String memberRankOrdinal,
                                  @JsonProperty("outfit_id") String outfitId,
                                  @JsonProperty("name") String outfitName,
                                  @JsonProperty("alias") String outfitAlias,
                                  @JsonProperty("time_created") String outfitCreationTime,
                                  @JsonProperty("leader_character_id") String leaderCharacterId,
                                  @JsonProperty("member_count") String memberCount) {
        this.memberSince = Instant.ofEpochMilli(Long.parseLong(memberSince));
        this.memberRank = memberRank;
        this.memberRankOrdinal = Long.parseLong(memberRankOrdinal);
        this.outfitId = Long.parseLong(outfitId);
        this.outfitName = outfitName;
        this.outfitAlias = outfitAlias;
        this.outfitCreationTime = Instant.ofEpochMilli(Long.parseLong(outfitCreationTime));
        this.leaderCharacterId = Long.parseLong(leaderCharacterId);
        this.memberCount = Long.parseLong(memberCount);
    }
}
