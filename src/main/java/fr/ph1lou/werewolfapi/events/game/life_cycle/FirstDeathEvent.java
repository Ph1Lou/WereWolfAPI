
package fr.ph1lou.werewolfapi.events.game.life_cycle;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class FirstDeathEvent extends Event implements Cancellable {

    private final IPlayerWW playerWW;
    private final Set<IPlayerWW> lastStrikers;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public FirstDeathEvent(IPlayerWW playerWW, Set<IPlayerWW> lastStrikers){
        this.playerWW = playerWW;
        this.lastStrikers = lastStrikers;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    @Override
    public boolean isCancelled() {
        return this.cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }

    public Set<IPlayerWW> getLastStrikers() {
        return this.lastStrikers;
    }
}
