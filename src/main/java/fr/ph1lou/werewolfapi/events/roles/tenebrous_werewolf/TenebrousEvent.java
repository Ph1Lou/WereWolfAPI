package fr.ph1lou.werewolfapi.events.roles.tenebrous_werewolf;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TenebrousEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private boolean cancelled = false;
    private final List<IPlayerWW> affectedPlayers;
    private final IPlayerWW playerWW;

    public TenebrousEvent(IPlayerWW playerWW, List<IPlayerWW> affectedPlayers) {
        this.playerWW = playerWW;
        this.affectedPlayers = affectedPlayers;
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
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    public List<IPlayerWW> getAffectedPlayers() {
        return affectedPlayers;
    }

    public void removeAffectedPlayer(IPlayerWW playerWW) {
        affectedPlayers.remove(playerWW);
    }

    public IPlayerWW getPlayerWW() {
        return playerWW;
    }
}