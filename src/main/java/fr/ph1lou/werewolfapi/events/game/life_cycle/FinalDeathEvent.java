
package fr.ph1lou.werewolfapi.events.game.life_cycle;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTarget;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;


@StatisticsEvent(key = "werewolf.final_kill")
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

    @Nullable
    @StatisticsTarget
    public IPlayerWW getTarget(){
        return getPlayerWW().getLastKiller().isPresent() ?
                getPlayerWW().getLastKiller().get() : null;
    }
}
