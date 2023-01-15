package fr.ph1lou.werewolfapi.events.game.day_cycle;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInt;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.night")
public class NightEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final int number;


    public NightEvent(int number) {
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
