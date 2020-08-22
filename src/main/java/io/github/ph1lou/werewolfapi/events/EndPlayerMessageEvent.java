package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class EndPlayerMessageEvent extends Event {

    private final UUID playerUUID;
    private StringBuilder endMessage;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public EndPlayerMessageEvent(UUID playerUUID, StringBuilder endMessage){
        this.playerUUID =playerUUID;
        this.endMessage =endMessage;
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

    public StringBuilder getEndMessage() {
        return endMessage;
    }

    public void setEndMessage(StringBuilder endMessage) {
        this.endMessage = endMessage;
    }
}

