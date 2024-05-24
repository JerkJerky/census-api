package io.github.jerkjerky.census.collections.currency;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TickReward {
    private final String description;
    private final Long amount;

    @JsonCreator
    protected TickReward(@JsonProperty("description") String description,
                         @JsonProperty("amount") String amount) {
        this.description = description;
        this.amount = Long.parseLong(amount);
    }
}
