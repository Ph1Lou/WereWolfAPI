package fr.ph1lou.werewolfapi.events.roles.mire;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.mire_eat_gapple")
public class MireEatGappleEvent extends SelectionEvent {


    private static final HandlerList HANDLERS_LIST = new HandlerList();


    public MireEatGappleEvent(IPlayerWW playerWW, IPlayerWW selectionWW){
        super(playerWW, selectionWW);
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

