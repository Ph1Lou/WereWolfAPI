package fr.ph1lou.werewolfapi.events.roles.citizen;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.see_werewolf.vote")
public class CitizenSeeWerewolfVoteEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public CitizenSeeWerewolfVoteEvent(IPlayerWW playerWW, IPlayerWW voteWerewolf){
        super(playerWW, voteWerewolf);
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

