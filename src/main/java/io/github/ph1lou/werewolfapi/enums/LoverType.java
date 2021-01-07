package io.github.ph1lou.werewolfapi.enums;

public enum LoverType {

    LOVER("werewolf.role.lover.display"),
    AMNESIAC_LOVER("werewolf.role.amnesiac_lover.display"),
    CURSED_LOVER("werewolf.role.cursed_lover.display");

    private final String key;

    LoverType(String key) {
        this.key = key;
    }


    public String getKey() {
        return key;
    }
}