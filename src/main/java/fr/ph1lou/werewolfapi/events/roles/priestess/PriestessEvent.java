package fr.ph1lou.werewolfapi.events.roles.priestess;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.priestess_spec")
@TellableStoryEvent
public class PriestessEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private String camp;

    public PriestessEvent(IPlayerWW playerWW, IPlayerWW targetWW, String camp) {
        super(playerWW, targetWW);
        this.camp = camp;
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
    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }

}

