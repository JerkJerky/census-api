package com.github.jerkjerky.census.collections.outfit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.jerkjerky.census.collections.serializers.InstantToMillisLongSerializer;
import lombok.SneakyThrows;
import net.openhft.chronicle.bytes.Bytes;

import java.time.Instant;

public class Outfit {
    private final Long outfitId;
    private final String name;
    private final String alias;
    private final Instant timeCreated;
    private final Long leaderCharacterId;
    private final Long memberCount;

    @SneakyThrows
    public static Outfit cacheDeserialize(Bytes inBytes, ObjectMapper objectMapper) {
        return objectMapper.readValue(inBytes.toByteArray(), Outfit.class);
    }

    @SneakyThrows
    public static void cacheSerialize(Bytes outBytes, ObjectMapper objectMapper, Outfit outfit) {
        outBytes.write(objectMapper.writeValueAsString(outfit));
    }

    @JsonCreator
    public Outfit(@JsonProperty("outfit_id") String outfitId,
                  @JsonProperty("name") String name,
                  @JsonProperty("alias") String alias,
                  @JsonProperty("time_created") Long timeCreated,
                  @JsonProperty("leader_character_id") String leaderCharacterId,
                  @JsonProperty("member_count") String memberCount) {
        this.outfitId = Long.parseLong(outfitId);
        this.name = name;
        this.alias = alias;
        this.timeCreated = Instant.ofEpochMilli(timeCreated);
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
