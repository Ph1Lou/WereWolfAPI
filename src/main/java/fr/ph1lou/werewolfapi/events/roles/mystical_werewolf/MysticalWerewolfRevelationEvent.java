package fr.ph1lou.werewolfapi.events.roles.mystical_werewolf;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


@StatisticsEvent(key = "werewolf.mystical_reveal")
public class MysticalWerewolfRevelationEvent extends SelectionEvent {


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public MysticalWerewolfRevelationEvent(IPlayerWW playerWW, IPlayerWW targetWW) {
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

    @StatisticsExtraInfo
    public String getExtraInfo() {
        return getTargetWW().getRole().getKey();
    }
}

