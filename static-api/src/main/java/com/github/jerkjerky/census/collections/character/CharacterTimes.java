package com.github.jerkjerky.census.collections.character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.jerkjerky.census.collections.serializers.InstantToMillisLongSerializer;

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

    @JsonProperty("creation")
    @JsonSerialize(using = InstantToMillisLongSerializer.class)
    public Instant getCreation() {
        return creation;
    }

    @JsonProperty("last_save")
    @JsonSerialize(using = InstantToMillisLongSerializer.class)
    public Instant getLastSave() {
        return lastSave;
    }

    @JsonProperty("last_login")
    @JsonSerialize(using = InstantToMillisLongSerializer.class)
    public Instant getLastLogin() {
        return lastLogin;
    }

    @JsonProperty("login_count")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getLoginCount() {
        return loginCount;
    }

    @JsonProperty("minutes_played")
    @JsonSerialize(using = ToStringSerializer.class)
    public Long getMinutesPlayed() {
        return minutesPlayed;
    }
}
