package fr.ph1lou.werewolfapi.enums;
@SuppressWarnings({"unused"})
public enum RandomEvent {
    EXPOSED("werewolf.random_events.exposed.name"),
    INFECTION("werewolf.random_events.infection.name"),
    TRIPLE("werewolf.random_events.triple.name"),
    BEARING_RITUAL("werewolf.random_events.bearing_ritual.name"),
    PUTREFACTION("werewolf.random_events.putrefaction.name"),
    GOD_MIRACLE("werewolf.random_events.god_miracle.name"),
    SWAP("werewolf.random_events.swap.name"),
    DRUNKEN_WEREWOLF("werewolf.random_events.drunken_werewolf.name"),
    AMNESIC("werewolf.random_events.amnesic.name"),
    DISCORD("werewolf.random_events.discord.name"),
    LOOT_BOX("werewolf.random_events.loot_box.name"),
    SISTER_MISANTHROPE("werewolf.random_events.sister_misanthrope.name"),
    RUMORS("werewolf.random_events.rumors.name");

    private final String key;

    RandomEvent(String key) {
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
