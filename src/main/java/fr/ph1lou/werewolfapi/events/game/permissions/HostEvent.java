package fr.ph1lou.werewolfapi.events.game.permissions;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class HostEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final UUID playerUUID;
    private boolean isHost;

    public HostEvent(UUID playerUUID, boolean isHost) {
        this.playerUUID = playerUUID;
        this.isHost = isHost;
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


    public boolean isHost() {
        return isHost;
    }


    public void setHost(boolean b) {
        this.isHost = b;
    }
}