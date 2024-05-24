package com.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class CharacterTimes {
    private final Instant creation;
    private final Instant lastSave;
    private final Instant lastLogin;
    private final Long loginCount;
    private final Long minutesPlayed;

    @JsonCreator
    protected CharacterTimes(@JsonProperty("creation") String creation,
                   @JsonProperty("last_save") String lastSave,
                   @JsonProperty("last_login") String lastLogin,
                   @JsonProperty("login_count") String loginCount,
                   @JsonProperty("minutes_played") String minutesPlayed) {
        this.creation = Instant.ofEpochMilli(Long.parseLong(creation));
        this.lastSave = Instant.ofEpochMilli(Long.parseLong(lastSave));
        this.lastLogin = Instant.ofEpochMilli(Long.parseLong(lastLogin));
        this.loginCount = Long.parseLong(loginCount);
        this.minutesPlayed = Long.parseLong(minutesPlayed);
    }

    public Instant getCreation() {
        return creation;
    }

    public Instant getLastSave() {
        return lastSave;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public Long getLoginCount() {
        return loginCount;
    }

    public Long getMinutesPlayed() {
        return minutesPlayed;
    }
}
