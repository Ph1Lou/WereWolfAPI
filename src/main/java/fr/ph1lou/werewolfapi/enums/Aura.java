package fr.ph1lou.werewolfapi.enums;

import org.bukkit.ChatColor;

public enum Aura {
    LIGHT("werewolf.role.oracle.light", ChatColor.GREEN),
    NEUTRAL("werewolf.role.oracle.neutral", ChatColor.GRAY),
    DARK("werewolf.role.oracle.dark", ChatColor.DARK_RED);

    private final String key;
    private final ChatColor chatColor;

    Aura(String key, ChatColor chatColor){
        this.key = key;
        this.chatColor = chatColor;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public String getKey() {
        return key;
    }
}
