package fr.ph1lou.werewolfapi.events.game.utils;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WinConditionsCheckEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean win = false;
    private String victoryTeam = "";

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin() {
        this.win = true;
    }

    public String getVictoryTeam() {
        return victoryTeam;
    }

    public void setVictoryTeam(String victoryTeam) {
        this.victoryTeam = victoryTeam;
    }
}
