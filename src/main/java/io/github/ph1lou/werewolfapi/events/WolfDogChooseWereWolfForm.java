package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WolfDogChooseWereWolfForm extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final PlayerWW playerWW;
    private boolean cancel = false;

    public WolfDogChooseWereWolfForm(PlayerWW playerWW){
        this.playerWW=playerWW;
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
    public void setCancelled(boolean cancelled) {
        this.cancel=cancelled;
    }

    public PlayerWW getPlayerWW() {
        return playerWW;
    }

}

