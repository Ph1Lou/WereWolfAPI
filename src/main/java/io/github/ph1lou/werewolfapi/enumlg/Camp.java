package io.github.ph1lou.werewolfapi.enumlg;

public enum Camp {
    WEREWOLF("werewolf.categories.werewolf"),
    NEUTRAL("werewolf.categories.neutral"),
    VILLAGER("werewolf.categories.villager");


    public String getKey() {
        return key;
    }

    String key;

    Camp(String key){
        this.key=key;
    }
}
