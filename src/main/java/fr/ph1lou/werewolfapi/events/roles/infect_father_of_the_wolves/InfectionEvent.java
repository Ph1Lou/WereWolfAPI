package fr.ph1lou.werewolfapi.events.roles.infect_father_of_the_wolves;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


@StatisticsEvent(key = "werewolf.infection")
@TellableStoryEvent
public class InfectionEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private boolean informInfectionCancelledMessage = true;


    public InfectionEvent(IPlayerWW playerWW, IPlayerWW targetWW) {
        super(playerWW, targetWW);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public boolean isInformInfectionCancelledMessage(){
        return this.informInfectionCancelledMessage;
    }

    public void setInformInfectionCancelledMessage(boolean b){
        this.informInfectionCancelledMessage = b;
    }
}