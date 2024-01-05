package fr.ph1lou.werewolfapi.enums;


@SuppressWarnings({"unused"})
public enum Aura {
    LIGHT("werewolf.roles.oracle.light"),
    NEUTRAL("werewolf.roles.oracle.neutral"),
    DARK("werewolf.roles.oracle.dark");

    private final String key;

    Aura(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
