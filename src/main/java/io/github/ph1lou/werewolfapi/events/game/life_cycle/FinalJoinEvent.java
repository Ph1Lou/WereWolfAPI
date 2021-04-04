package io.github.ph1lou.werewolfapi.events.game.life_cycle;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class FinalJoinEvent extends Event {

    private final IPlayerWW playerWW;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public FinalJoinEvent(IPlayerWW playerWW) {
        this.playerWW = playerWW;
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

}