package io.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Character {
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
                        @JsonProperty("character_id_join_outfit_member_extended") CharacterOutfitData characterOutfitData) {
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

}
