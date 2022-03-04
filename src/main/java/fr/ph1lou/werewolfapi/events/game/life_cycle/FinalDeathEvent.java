
package fr.ph1lou.werewolfapi.events.game.life_cycle;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class FinalDeathEvent extends FirstDeathEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public FinalDeathEvent(IPlayerWW playerWW, Set<IPlayerWW> lastStrikers){
        super(playerWW, lastStrikers);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }
}
