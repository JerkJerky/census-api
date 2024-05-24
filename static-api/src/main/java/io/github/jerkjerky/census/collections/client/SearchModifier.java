package io.github.jerkjerky.census.collections.client;

public enum SearchModifier {
    NONE(""),
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL("["),
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUAL("]"),
    STARTS_WITH("^"),
    CONTAINS("*"),
    NOT("!"),
    DOES_NOT_CONTAIN("~");

    private final String modifier;

    SearchModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifier() {
        return modifier;
    }
}
