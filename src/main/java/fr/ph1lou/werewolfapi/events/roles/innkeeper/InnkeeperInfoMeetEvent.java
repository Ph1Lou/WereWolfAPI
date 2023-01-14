package fr.ph1lou.werewolfapi.events.roles.innkeeper;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInt;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.innkeeper.meet")
public class InnkeeperInfoMeetEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final int number;

    public InnkeeperInfoMeetEvent(IPlayerWW playerWW, IPlayerWW target, int number) {
        super(playerWW, target);
        this.number = number;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }


    @StatisticsExtraInt
    public int getNumber() {
        return number;
    }
}
