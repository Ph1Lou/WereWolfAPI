package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class RevealLoversEvent extends Event {


    private final List<List<UUID>> playersUUID;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public RevealLoversEvent(List<List<UUID>> playersUUID) {
        this.playersUUID = playersUUID;
    }


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public List<List<UUID>> getPlayersUUID() {
        return playersUUID;
    }
}

