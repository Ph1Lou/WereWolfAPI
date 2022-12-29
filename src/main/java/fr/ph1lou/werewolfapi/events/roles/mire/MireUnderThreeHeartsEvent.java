package fr.ph1lou.werewolfapi.events.roles.mire;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class MireUnderThreeHeartsEvent extends Event implements Cancellable {

    private boolean cancelled = false;
    private final IPlayerWW playerWW;

    public MireUnderThreeHeartsEvent(IPlayerWW playerWW) {
        this.playerWW = playerWW;
    }

    private static final HandlerList HANDLERS_LIST = new HandlerList();
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

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }
}
