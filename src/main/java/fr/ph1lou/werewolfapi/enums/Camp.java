package fr.ph1lou.werewolfapi.enums;

import org.bukkit.ChatColor;

@SuppressWarnings({"unused"})
public enum Camp {
    WEREWOLF("werewolf.categories.werewolf", ChatColor.DARK_RED),
    NEUTRAL("werewolf.categories.neutral", ChatColor.GRAY),
    VILLAGER("werewolf.categories.villager", ChatColor.GREEN);

    private final String key;
    private final ChatColor chatColor;

    Camp(String key, ChatColor chatColor) {
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
