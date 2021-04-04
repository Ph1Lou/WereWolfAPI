package io.github.ph1lou.werewolfapi.events.game.permissions;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ModeratorEvent extends Event {

    private final UUID playerUUID;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isModerator;

    public ModeratorEvent(UUID playerUUID, boolean isModerator) {
        this.playerUUID = playerUUID;
        this.isModerator = isModerator;
    }


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

   
    public boolean isModerator() {
        return isModerator;
    }

    
    public void setModerator(boolean b) {
        this.isModerator =b;
    }
}