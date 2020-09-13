package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SniffEvent extends SelectionEvent {


    private boolean isWereWolf;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SniffEvent(UUID playerUUID, UUID sniffPlayerUUID, boolean isWereWolf) {
        super(playerUUID,sniffPlayerUUID);
        this.isWereWolf = isWereWolf;
    }


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }


    public boolean isWereWolf() {
        return isWereWolf;
    }

    public void setWereWolf(boolean wereWolf) {
        isWereWolf = wereWolf;
    }
}