package fr.ph1lou.werewolfapi.events.roles.hunter;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.hunter_shoot_event")
public class HunterShotEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public HunterShotEvent(IPlayerWW sourceWW, IPlayerWW targetWW) {
        super(sourceWW, targetWW);
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
