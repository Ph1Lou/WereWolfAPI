package io.github.ph1lou.werewolfapi.enums;

public enum RandomEvent {
    EXPOSED("werewolf.random_events.exposed.name"),
    INFECTION("werewolf.random_events.infection.name"),
    TRIPLE("werewolf.random_events.triple.name"),
    BEARING_RITUAL("werewolf.random_events.bearing_ritual.name"),
    PUTREFACTION("werewolf.random_events.putrefaction.name"),
    GOD_MIRACLE("werewolf.random_events.god_miracle.name"),
    SWAP("werewolf.random_events.swap.name"),
    LOOT_BOX("werewolf.random_events.loot_box.name");

    private final String key;

    RandomEvent(String key) {
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
