package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class VoteResultEvent extends Event implements Cancellable {

    private PlayerWW playerWW =null;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel=false;



    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }


    public void setPlayerWW(PlayerWW playerWW){
        this.playerWW =playerWW;
    }

    public PlayerWW getPlayerWW(){
        return playerWW;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }
}
