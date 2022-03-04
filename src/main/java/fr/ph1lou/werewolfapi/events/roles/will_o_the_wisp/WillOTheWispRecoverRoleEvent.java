package fr.ph1lou.werewolfapi.events.roles.will_o_the_wisp;

import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WillOTheWispRecoverRoleEvent extends SelectionEvent {



    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private String key;

    public WillOTheWispRecoverRoleEvent(IPlayerWW playerWW, IPlayerWW targetWW, String key){
        super(playerWW,targetWW);
        this.key=key;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public String getRoleKey() {
        return key;
    }

    public void setRoleKey(String key) {
        this.key = key;
    }

}

