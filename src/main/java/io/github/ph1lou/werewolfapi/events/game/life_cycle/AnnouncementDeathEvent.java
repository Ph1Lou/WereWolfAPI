package io.github.ph1lou.werewolfapi.events.game.life_cycle;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AnnouncementDeathEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final IPlayerWW playerWW;
    private String playerName;
    private String role;
    private String format;
    private  boolean cancel;

    public AnnouncementDeathEvent(IPlayerWW playerWW, String format){
        this.playerWW = playerWW;
        this.playerName= playerWW.getName();
        this.role= playerWW.getRole().getDeathRole();
        this.format=format;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getRole() {
        return role;
    }

    public String getFormat() {
        return format;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public IPlayerWW getPlayerWW() {
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