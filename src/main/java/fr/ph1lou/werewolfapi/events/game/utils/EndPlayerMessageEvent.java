package fr.ph1lou.werewolfapi.events.game.utils;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class EndPlayerMessageEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private StringBuilder endMessage;

    public EndPlayerMessageEvent(IPlayerWW playerWW, StringBuilder endMessage) {
        this.playerWW = playerWW;
        this.endMessage = endMessage;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
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

