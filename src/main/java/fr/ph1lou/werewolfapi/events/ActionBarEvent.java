package fr.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ActionBarEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final UUID playerUUID;
    private final StringBuilder actionBar = new StringBuilder();

    public ActionBarEvent(UUID playerUUID) {
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

    public StringBuilder getActionBar() {
        return actionBar;
    }
}

