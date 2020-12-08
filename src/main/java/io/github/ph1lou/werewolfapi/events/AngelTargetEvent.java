package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AngelTargetEvent extends Event {

    private final PlayerWW playerWW;
    private final PlayerWW targetWW;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public AngelTargetEvent(PlayerWW playerWW, PlayerWW targetWW){
        this.playerWW = playerWW;
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

    public PlayerWW getPlayerWW() {
        return playerWW;
    }

    public PlayerWW getTargetWW() {
        return targetWW;
    }
}

