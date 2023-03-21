package fr.ph1lou.werewolfapi.events.roles.analyst;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.analyst_see")
@TellableStoryEvent
public class AnalystEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private boolean hasEffect;

    public AnalystEvent(IPlayerWW playerWW, IPlayerWW targetUUID, boolean hasEffect) {
        super(playerWW, targetUUID);
        this.hasEffect = hasEffect;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public boolean hasEffect() {
        return hasEffect;
    }

    public void setHasEffect(boolean hasEffect) {
        this.hasEffect = hasEffect;
    }

    @StatisticsExtraInfo
    public String getExtraInfo() {
        return hasEffect() ? "werewolf.roles.analyst.has_effects" :
                "werewolf.roles.analyst.no_effects";
    }

}

