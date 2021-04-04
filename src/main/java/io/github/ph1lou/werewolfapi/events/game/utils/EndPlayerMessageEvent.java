package io.github.ph1lou.werewolfapi.events.game.utils;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class EndPlayerMessageEvent extends Event {

    private final IPlayerWW playerWW;
    private StringBuilder endMessage;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public EndPlayerMessageEvent(IPlayerWW playerWW, StringBuilder endMessage){
        this.playerWW = playerWW;
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

    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    public StringBuilder getEndMessage() {
        return endMessage;
    }

    public void setEndMessage(StringBuilder endMessage) {
        this.endMessage = endMessage;
    }
}

