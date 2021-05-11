package io.github.ph1lou.werewolfapi.events.game.life_cycle;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AnnouncementDeathEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final IPlayerWW playerWW;
    private final IPlayerWW targetPlayer;
    private String playerName;
    private String role;
    private String format;

    /**
     *
     * @param playerWW the player dead
     * @param targetPlayer the player who will show the message
     * @param format the message
     */
    public AnnouncementDeathEvent(IPlayerWW playerWW, IPlayerWW targetPlayer, String format){
        this.playerWW = playerWW;
        this.playerName= playerWW.getName();
        this.role= playerWW.getRole().getDeathRole();
        this.targetPlayer = targetPlayer;
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
        return this.playerWW;
    }

    public IPlayerWW getTargetPlayer() {
        return this.targetPlayer;
    }
}