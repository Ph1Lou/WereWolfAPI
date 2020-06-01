package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class ActionBarEvent extends Event {

    private final UUID playerUUID;
    private String actionBar;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public ActionBarEvent(UUID playerUUID, String actionBar){
        this.playerUUID =playerUUID;
        this.actionBar=actionBar;
    }

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

    public String getActionBar() {
        return actionBar;
    }

    public void setActionBar(String actionBar) {
        this.actionBar = actionBar;
    }
}

