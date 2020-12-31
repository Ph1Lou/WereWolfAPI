package io.github.ph1lou.werewolfapi.enums;

public enum RandomEvent {
    EXPOSED("werewolf.random_events.exposed.name");

    private final String key;

    RandomEvent(String key) {
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
