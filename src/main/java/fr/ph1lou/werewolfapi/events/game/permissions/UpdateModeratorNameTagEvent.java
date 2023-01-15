package fr.ph1lou.werewolfapi.events.game.permissions;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class UpdateModeratorNameTagEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final UUID playerUUID;
    private String prefix = "";
    private String suffix = "";

    public UpdateModeratorNameTagEvent(UUID playerUUID) {
        this.playerUUID = playerUUID;
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


}

