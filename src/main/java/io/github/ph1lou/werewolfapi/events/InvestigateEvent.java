package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class InvestigateEvent extends SelectionEvent {

    private final List<UUID> playersUUID;
    private final boolean sameCamp;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public InvestigateEvent(UUID playerUUID, List<UUID> playersUUID, boolean sameCamp){
        super(playerUUID,playersUUID.get(0));
        this.playersUUID =playersUUID;
        this.sameCamp = sameCamp;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public boolean isSameCamp() {
        return sameCamp;
    }

    public List<UUID> getPlayersUUID() {
        return playersUUID;
    }
}

