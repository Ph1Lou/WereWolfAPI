package io.github.ph1lou.werewolfapi.enums;

public enum Camp {
    WEREWOLF("werewolf.categories.werewolf"),
    NEUTRAL("werewolf.categories.neutral"),
    VILLAGER("werewolf.categories.villager");


    public String getKey() {
        return key;
    }

    final String key;

    Camp(String key){
        this.key=key;
    }
}
