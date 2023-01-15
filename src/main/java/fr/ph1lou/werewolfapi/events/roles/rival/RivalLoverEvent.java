package fr.ph1lou.werewolfapi.events.roles.rival;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.rival_lover")
public class RivalLoverEvent extends SelectionEvent {


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public RivalLoverEvent(IPlayerWW playerWW, IPlayerWW targetWW) {
        super(playerWW, targetWW);
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

