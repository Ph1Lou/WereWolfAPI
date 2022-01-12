package fr.ph1lou.werewolfapi.enums;

public enum Prefix {
    YELLOW("werewolf.prefix.yellow"),
    RED("werewolf.prefix.red"),
    GREEN("werewolf.prefix.green"),
    ORANGE("werewolf.prefix.orange"),
    BLUE("werewolf.prefix.blue"),
    LIGHT_BLUE("werewolf.prefix.light_blue");

    private final String key;
    Prefix(String key){
        this.key=key;
    }

    public String getKey() {
        return key;
    }
}
