package io.github.ph1lou.werewolfapi.enums;

public enum RandomEvent {
    EXPOSED("werewolf.random_events.exposed.name"),
    LOOT_BOX("werewolf.random_events.loot_box.name");

    private final String key;

    RandomEvent(String key) {
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
