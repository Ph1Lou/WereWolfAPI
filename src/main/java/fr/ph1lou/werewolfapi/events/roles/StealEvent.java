
package fr.ph1lou.werewolfapi.events.roles;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.steal")
public class StealEvent extends SelectionEvent {

    private final String role;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public StealEvent(IPlayerWW thiefWW, IPlayerWW playerWW, String role){
        super(thiefWW, playerWW);
        this.role=role;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @StatisticsExtraInfo

    public String getRole() {
        return role;
    }
}
