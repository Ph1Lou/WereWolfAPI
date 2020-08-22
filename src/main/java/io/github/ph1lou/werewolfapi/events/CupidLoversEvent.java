package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class CupidLoversEvent extends Event {

    private final UUID playerUUID;
    private final List<UUID> playersUUID;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public CupidLoversEvent(UUID playerUUID, List<UUID> playersUUID){
        this.playerUUID =playerUUID;
        this.playersUUID =playersUUID;
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

    public List<UUID> getPlayersUUID() {
        return playersUUID;
    }
}

