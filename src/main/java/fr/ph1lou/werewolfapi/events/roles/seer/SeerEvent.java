package fr.ph1lou.werewolfapi.events.roles.seer;

import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SeerEvent extends SelectionEvent {

    private String camp;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SeerEvent(IPlayerWW playerWW, IPlayerWW targetWW, String camp){
        super(playerWW,targetWW);
        this.camp=camp;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }

}

