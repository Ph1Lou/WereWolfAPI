package io.github.ph1lou.werewolfapi.events.random_events;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LootBoxEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel=false;
    private final IPlayerWW playerWW;

    private final int chestNumbers;

    public LootBoxEvent(IPlayerWW playerWW, int chestNumbers) {
        this.playerWW = playerWW;
        this.chestNumbers=chestNumbers;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }

    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    public int getChestNumbers() {
        return chestNumbers;
    }
}