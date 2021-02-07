package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class NewDisplayRole extends Event implements Cancellable {

    private final PlayerWW playerWW;
    private final String newDisplayRole;
    private final String newDisplayCamp;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel=false;

    public NewDisplayRole(PlayerWW playerWW, String newDisplayRole1, String newDisplayCamp){
        this.playerWW =playerWW;
        this.newDisplayRole = newDisplayRole1;

        this.newDisplayCamp = newDisplayCamp;
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


    public String getNewDisplayCamp() {
        return newDisplayCamp;
    }

    public String getNewDisplayRole() {
        return newDisplayRole;
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

