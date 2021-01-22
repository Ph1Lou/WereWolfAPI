package io.github.ph1lou.werewolfapi.enums;

import org.bukkit.ChatColor;

public enum LoverType {

    LOVER("werewolf.role.lover.display", ChatColor.LIGHT_PURPLE),
    AMNESIAC_LOVER("werewolf.role.amnesiac_lover.display",ChatColor.DARK_PURPLE),
    CURSED_LOVER("werewolf.role.cursed_lover.display",ChatColor.BLACK);

    private final String key;
    private final ChatColor chatColor;

    LoverType(String key, ChatColor chatColor){
        this.key=key;
        this.chatColor=chatColor;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public String getKey() {
        return key;
    }
}