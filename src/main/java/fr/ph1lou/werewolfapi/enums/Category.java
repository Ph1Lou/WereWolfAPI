package fr.ph1lou.werewolfapi.enums;

import java.util.Arrays;
import java.util.Optional;

@SuppressWarnings({"unused"})
public enum Category {
    WEREWOLF("werewolf.categories.werewolf", "werewolf.categories.colors.werewolf"),
    VILLAGER("werewolf.categories.villager", "werewolf.categories.colors.villager"),
    NEUTRAL("werewolf.categories.neutral", "werewolf.categories.colors.neutral");

    private final String key;
    private final String chatColor;

    Category(String key, String chatColor) {
        this.key = key;
        this.chatColor = chatColor;
    }

    public static Optional<Category> fromKey(String key) {
        return Arrays.stream(values())
                .filter(category -> category.getKey().equals(key)).findFirst();
    }

    public String getChatColor() {
        return chatColor;
    }

    public String getKey() {
        return key;
    }
}
