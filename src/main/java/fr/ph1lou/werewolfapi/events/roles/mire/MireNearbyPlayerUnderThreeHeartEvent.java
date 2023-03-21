package fr.ph1lou.werewolfapi.events.roles.mire;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.mire_nearby_player")
public class MireNearbyPlayerUnderThreeHeartEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();


    public MireNearbyPlayerUnderThreeHeartEvent(IPlayerWW playerWW, IPlayerWW selectionWW) {
        super(playerWW, selectionWW);
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

