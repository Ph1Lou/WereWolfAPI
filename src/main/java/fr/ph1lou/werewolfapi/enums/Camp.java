package fr.ph1lou.werewolfapi.enums;

@SuppressWarnings({"unused"})
public enum Camp {
    WEREWOLF("werewolf.categories.werewolf"),
    NEUTRAL("werewolf.categories.neutral"),
    VILLAGER("werewolf.categories.villager");

    private final String key;

    Camp(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
