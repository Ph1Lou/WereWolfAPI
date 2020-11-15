package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ActionBarEvent extends Event {

    private final UUID playerUUID;
    private String actionBar="";
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public ActionBarEvent(UUID playerUUID){
        this.playerUUID =playerUUID;
        this.actionBar=actionBar;
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

    public String getActionBar() {
        return actionBar;
    }

    public void setActionBar(String actionBar) {
        this.actionBar = actionBar;
    }
}

