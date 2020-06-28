
package io.github.ph1lou.werewolfapi.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class WinConditionsCheckEvent extends Event implements Cancellable {

    private boolean cancel=false;
    private String victoryTeam="";
    private static final HandlerList HANDLERS_LIST = new HandlerList();

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
    public void setCancelled(boolean b) {
        this.cancel=b;
    }

    public void setVictoryTeam(String victoryTeam) {
        this.victoryTeam = victoryTeam;
    }

    public String getVictoryTeam() {
        return victoryTeam;
    }
}
