package com.github.jerkjerky.census.collections.outfit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.jerkjerky.census.collections.character.CharacterOutfitData;
import com.github.jerkjerky.census.collections.common.CacheInvalidationBase;
import com.github.jerkjerky.census.collections.serializers.InstantToMillisLongSerializer;

import java.time.Instant;

public class Outfit extends CacheInvalidationBase {
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
                String.valueOf(characterOutfitData.getMemberCount()),
                Instant.now()
        );
    }

    @JsonCreator
    public Outfit(@JsonProperty("outfit_id") String outfitId,
                  @JsonProperty("name") String name,
                  @JsonProperty("alias") String alias,
                  @JsonProperty("time_created") String timeCreated,
                  @JsonProperty("leader_character_id") String leaderCharacterId,
                  @JsonProperty("member_count") String memberCount,
                  @JsonProperty("fetchInstant") Instant fetchInstant) {
        super(fetchInstant == null ? Instant.now() : fetchInstant);
        this.outfitId = Long.parseLong(outfitId);
        this.name = name;
        this.alias = alias;
        this.timeCreated = Instant.ofEpochMilli(Long.parseLong(timeCreated));
        this.leaderCharacterId = Long.parseLong(leaderCharacterId);
        this.memberCount = Long.parseLong(memberCount);
    }

    @JsonProperty("outfit_id")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getOutfitId() {
        return outfitId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("alias")
    public String getAlias() {
        return alias;
    }

    @JsonProperty("time_created")
    @JsonSerialize(using = InstantToMillisLongSerializer.class)
    public Instant getTimeCreated() {
        return timeCreated;
    }

    @JsonProperty("leader_character_id")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getLeaderCharacterId() {
        return leaderCharacterId;
    }

    @JsonProperty("member_count")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getMemberCount() {
        return memberCount;
    }
}
