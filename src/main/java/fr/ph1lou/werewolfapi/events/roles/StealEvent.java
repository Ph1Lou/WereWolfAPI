package fr.ph1lou.werewolfapi.events.roles;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.steal")
public class StealEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final String role;

    public StealEvent(IPlayerWW thiefWW, IPlayerWW playerWW, String role) {
        super(thiefWW, playerWW);
        this.role = role;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @StatisticsExtraInfo

    public String getRole() {
        return role;
    }
}
