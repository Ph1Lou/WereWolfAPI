package io.github.ph1lou.werewolfapi.events.random_events;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DrunkenWereWolfEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final IPlayerWW playerWW;
    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public DrunkenWereWolfEvent(IPlayerWW playerWW){
        this.playerWW=playerWW;
    }

    public IPlayerWW getPlayerWW() {
        return playerWW;
    }
}
