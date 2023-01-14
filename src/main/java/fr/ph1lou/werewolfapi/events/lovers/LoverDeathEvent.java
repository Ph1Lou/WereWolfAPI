
package fr.ph1lou.werewolfapi.events.lovers;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTargets;
import fr.ph1lou.werewolfapi.lovers.ILover;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;


@StatisticsEvent(key = "werewolf.lover_death")
public class LoverDeathEvent extends Event {

    private final ILover lover;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public LoverDeathEvent(ILover lover){
        this.lover=lover;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public ILover getLover() {
        return this.lover;
    }

    @StatisticsTargets
    public Set<IPlayerWW> getTargets(){
        return new HashSet<>(this.lover.getLovers());
    }
}
