package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SuccubusResurrectionEvent extends ResurrectionEvent {

    private final PlayerWW targetWW;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SuccubusResurrectionEvent(PlayerWW playerWW, PlayerWW targetWW) {
        super(playerWW);
        this.targetWW = targetWW;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public PlayerWW getTargetWW() {
        return targetWW;
    }
}