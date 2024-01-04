package fr.ph1lou.werewolfapi.events.roles.bloodthirsty_werewolf;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@TellableStoryEvent
@StatisticsEvent(key = "werewolf.bloodthirsty_werewolf_hunt_down_event")
public class BloodthirstyWerewolfHuntDownEvent extends SelectionEvent {
    public static final HandlerList HANDLERS_LIST = new HandlerList();

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList(){
        return HANDLERS_LIST;
    }

    public BloodthirstyWerewolfHuntDownEvent(IPlayerWW playerWW, IPlayerWW targetWW) {
        super(playerWW, targetWW);
    }
}
