package fr.ph1lou.werewolfapi.events.roles.remulusremus;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


@StatisticsEvent(key = "werewolf.romulusremus_mother_death")
public class MotherDeathEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public MotherDeathEvent(IPlayerWW mother, IPlayerWW target) {
        super(mother, target);

    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

}

