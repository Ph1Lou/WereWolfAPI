package fr.ph1lou.werewolfapi.enums;

import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.Optional;

@SuppressWarnings({"unused"})
public enum Category {
    WEREWOLF("werewolf.categories.werewolf", ChatColor.DARK_RED),
    VILLAGER("werewolf.categories.villager", ChatColor.GREEN),
    NEUTRAL("werewolf.categories.neutral", ChatColor.GRAY),
    ADDONS("werewolf.categories.addons", ChatColor.GOLD);

    private final String key;
    private final ChatColor chatColor;

    Category(String key, ChatColor chatColor) {
        this.key = key;
        this.chatColor = chatColor;
    }

    public static Optional<Category> fromKey(String key) {
        return Arrays.stream(values())
                .filter(category -> category.getKey().equals(key)).findFirst();
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public String getKey() {
        return key;
    }
}
