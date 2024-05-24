package com.github.jerkjerky.census.collections.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class I18nProperty {
    private final String german;
    private final String english;
    private final String spanish;
    private final String french;
    private final String italian;
    private final String turkish;

    @JsonCreator
    protected I18nProperty(@JsonProperty("de") String german,
                           @JsonProperty("en") String english,
                           @JsonProperty("es") String spanish,
                           @JsonProperty("fr") String french,
                           @JsonProperty("it") String italian,
                           @JsonProperty("tr") String turkish) {
        this.german = german;
        this.english = english;
        this.spanish = spanish;
        this.french = french;
        this.italian = italian;
        this.turkish = turkish;
    }

}
