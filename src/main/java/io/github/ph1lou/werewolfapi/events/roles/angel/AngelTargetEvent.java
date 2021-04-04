package io.github.ph1lou.werewolfapi.events.roles.angel;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AngelTargetEvent extends Event {

    private final IPlayerWW playerWW;
    private final IPlayerWW targetWW;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public AngelTargetEvent(IPlayerWW playerWW, IPlayerWW targetWW){
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

    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    public IPlayerWW getTargetWW() {
        return targetWW;
    }
}

