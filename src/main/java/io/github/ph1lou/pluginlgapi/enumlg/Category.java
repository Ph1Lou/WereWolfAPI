package io.github.ph1lou.pluginlgapi.enumlg;

public enum Category {
    WEREWOLF("werewolf.categories.werewolf"),
    VILLAGER("werewolf.categories.villager"),
    NEUTRAL("werewolf.categories.neutral"),
    ADDONS("werewolf.categories.addons");

    private final String key;

    Category(String key) {
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
