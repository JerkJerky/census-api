package io.github.jerkjerky.census.eventstreaming.models.request;


import java.util.List;

public final class SubscriptionRequest extends CensusRequest {

    private static final List<String> ALL = List.of("all");


    private final List<String> characters;
    private final List<String> worlds;
    private final List<String> eventNames;

    public static SubscriptionRequest ofAllEvents() {
        return new SubscriptionRequest(ALL, ALL, ALL);
    }

    public SubscriptionRequest(List<String> characters, List<String> worlds, List<String> eventNames) {
        this.characters = characters;
        this.worlds = worlds;
        this.eventNames = eventNames;
    }

    public String getService() {
        return "event";
    }

    public String getAction() {
        return "subscribe";
    }

    public List<String> getCharacters() {
        return characters;
    }

    public List<String> getWorlds() {
        return worlds;
    }

    public List<String> getEventNames() {
        return eventNames;
    }
}
