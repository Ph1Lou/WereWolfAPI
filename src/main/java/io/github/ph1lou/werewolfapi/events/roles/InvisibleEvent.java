package io.github.ph1lou.werewolfapi.events.roles;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class InvisibleEvent extends Event {

    private final IPlayerWW playerWW;
    private final boolean invisible;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public InvisibleEvent(IPlayerWW playerWW, boolean invisible) {
        this.playerWW = playerWW;
        this.invisible=invisible;
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

    public boolean isInvisible() {
        return invisible;
    }
}