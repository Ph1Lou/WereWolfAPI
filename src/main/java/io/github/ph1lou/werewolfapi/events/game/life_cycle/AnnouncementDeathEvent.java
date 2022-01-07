package io.github.ph1lou.werewolfapi.events.game.life_cycle;

import io.github.ph1lou.werewolfapi.Formatter;
import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementDeathEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final IPlayerWW playerWW;
    private final IPlayerWW targetPlayer;
    private String playerName;
    private String role;
    private String format;

    private final List<Formatter> formatters = new ArrayList<>();
    private boolean cancel = false;

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

    /**
     * Récuperez le joueur décédé
     * @return le joueur
     */
    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    /**
     * Recupérez le joueur a qui est adressé l'annonce de mort
     * @return le joueur
     */
    public IPlayerWW getTargetPlayer() {
        return this.targetPlayer;
    }

    public List<? extends Formatter> getFormatters() {
        return formatters;
    }

    public void addFormatter(Formatter formatter){
        this.formatters.add(formatter);
    }

    @Override
    public boolean isCancelled() {
        return this.cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}