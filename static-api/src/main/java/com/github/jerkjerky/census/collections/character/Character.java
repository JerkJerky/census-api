package com.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.jerkjerky.census.collections.common.CacheInvalidationBase;
import lombok.SneakyThrows;

import java.time.Instant;

public class Character extends CacheInvalidationBase {
    private final Long characterId;
    private final CharacterName characterName;
    private final Long factionId;
    private final Long headId;
    private final Long titleId;
    private final CharacterTimes characterTimes;
    private final CharacterCerts characterCerts;
    private final CharacterBattleRank characterBattleRank;
    private final Long profileId;
    private final CharacterDailyRibbon characterDailyRibbon;
    private final Long prestigeLevel;
    private final CharacterOutfitData characterOutfitData;

    @JsonCreator
    protected Character(@JsonProperty("character_id") String characterId,
                        @JsonProperty("name") CharacterName characterName,
                        @JsonProperty("faction_id") String factionId,
                        @JsonProperty("head_id") String headId,
                        @JsonProperty("title_id") String titleId,
                        @JsonProperty("times") CharacterTimes characterTimes,
                        @JsonProperty("certs") CharacterCerts characterCerts,
                        @JsonProperty("battle_rank") CharacterBattleRank characterBattleRank,
                        @JsonProperty("profile_id") String profileId,
                        @JsonProperty("daily_ribbon") CharacterDailyRibbon characterDailyRibbon,
                        @JsonProperty("prestige_level") String prestigeLevel,
                        @JsonProperty("character_id_join_outfit_member_extended") CharacterOutfitData characterOutfitData,
                        @JsonProperty("fetchInstant") Instant fetchInstant) {
        super(fetchInstant == null ? Instant.now() : fetchInstant);
        this.characterId = Long.parseLong(characterId);
        this.characterName = characterName;
        this.factionId = Long.parseLong(factionId);
        this.headId = Long.parseLong(headId);
        this.titleId = Long.parseLong(titleId);
        this.characterTimes = characterTimes;
        this.characterCerts = characterCerts;
        this.characterBattleRank = characterBattleRank;
        this.profileId = Long.parseLong(profileId);
        this.characterDailyRibbon = characterDailyRibbon;
        this.prestigeLevel = Long.parseLong(prestigeLevel);
        this.characterOutfitData = characterOutfitData;
    }

    @JsonProperty("character_id")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getCharacterId() {
        return characterId;
    }

    @JsonProperty("name")
    public CharacterName getCharacterName() {
        return characterName;
    }

    @JsonProperty("faction_id")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getFactionId() {
        return factionId;
    }

    @JsonProperty("head_id")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getHeadId() {
        return headId;
    }

    @JsonProperty("title_id")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getTitleId() {
        return titleId;
    }

    @JsonProperty("times")
    public CharacterTimes getCharacterTimes() {
        return characterTimes;
    }

    @JsonProperty("certs")
    public CharacterCerts getCharacterCerts() {
        return characterCerts;
    }

    @JsonProperty("battle_rank")
    public CharacterBattleRank getCharacterBattleRank() {
        return characterBattleRank;
    }

    @JsonProperty("profile_id")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getProfileId() {
        return profileId;
    }

    @JsonProperty("daily_ribbon")
    public CharacterDailyRibbon getCharacterDailyRibbon() {
        return characterDailyRibbon;
    }

    @JsonProperty("prestige_level")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getPrestigeLevel() {
        return prestigeLevel;
    }

    @JsonIgnore
    public CharacterOutfitData getCharacterOutfitData() {
        return characterOutfitData;
    }
}
