package fr.ph1lou.werewolfapi.enums;

import fr.ph1lou.werewolfapi.basekeys.LoverBase;
import org.bukkit.ChatColor;

@SuppressWarnings({"unused"})
public enum LoverType {

    LOVER(LoverBase.LOVER, ChatColor.LIGHT_PURPLE),
    AMNESIAC_LOVER(LoverBase.AMNESIAC_LOVER, ChatColor.DARK_PURPLE),
    CURSED_LOVER(LoverBase.CURSED_LOVER, ChatColor.BLACK),
    FAKE_LOVER(LoverBase.FAKE_LOVER, ChatColor.GOLD);

    private final String key;
    private final ChatColor chatColor;

    LoverType(String key, ChatColor chatColor) {
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