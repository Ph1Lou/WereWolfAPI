package fr.ph1lou.werewolfapi.events.random_events;

import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class VaccinationEvent extends SelectionEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public VaccinationEvent(IPlayerWW infectFatherWW, IPlayerWW vaccinatedPlayerWW){
        super(infectFatherWW, vaccinatedPlayerWW);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList(){
        return HANDLERS_LIST;
    }
}
