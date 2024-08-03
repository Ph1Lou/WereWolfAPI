package fr.ph1lou.werewolfapi.events;

import org.bukkit.ChatColor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class UpdatePlayerNameTagEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final UUID playerUUID;
    private final UUID targetUUID;
    private boolean tabVisibility = true;
    private ChatColor chatColor = ChatColor.WHITE;
    private String prefix;
    private String suffix = "";
    private boolean visibility = true;

    public UpdatePlayerNameTagEvent(UUID playerUUID, UUID targetUUID, String prefix) {
        this.playerUUID = playerUUID;
        this.targetUUID = targetUUID;
        this.prefix = prefix;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public boolean isTabVisibility() {
        return tabVisibility;
    }

    public void setTabVisibility(boolean tabVisibility) {
        this.tabVisibility = tabVisibility;
    }

    public UUID getTargetUUID() {
        return targetUUID;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public void setChatColor(ChatColor chatColor) {
        this.chatColor = chatColor;
    }
}

