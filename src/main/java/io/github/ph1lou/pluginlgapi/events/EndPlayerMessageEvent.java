package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class EndPlayerMessageEvent extends Event {

    private final UUID playerUUID;
    private StringBuilder endMessage;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public EndPlayerMessageEvent(UUID playerUUID, StringBuilder endMessage){
        this.playerUUID =playerUUID;
        this.endMessage =endMessage;
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

    public StringBuilder getEndMessage() {
        return endMessage;
    }

    public void setEndMessage(StringBuilder endMessage) {
        this.endMessage = endMessage;
    }
}

