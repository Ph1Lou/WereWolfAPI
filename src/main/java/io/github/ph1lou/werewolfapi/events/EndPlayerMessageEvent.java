package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class EndPlayerMessageEvent extends Event {

    private final PlayerWW playerWW;
    private StringBuilder endMessage;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public EndPlayerMessageEvent(PlayerWW playerWW, StringBuilder endMessage){
        this.playerWW =playerWW;
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

    public PlayerWW getPlayerWW() {
        return playerWW;
    }

    public StringBuilder getEndMessage() {
        return endMessage;
    }

    public void setEndMessage(StringBuilder endMessage) {
        this.endMessage = endMessage;
    }
}

