package fr.ph1lou.werewolfapi.events.roles.village_idiot;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.idiot_village")
public class VillageIdiotEvent extends SelectionEvent {


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public VillageIdiotEvent(IPlayerWW playerWW, IPlayerWW targetWW) {
        super(playerWW,targetWW);
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