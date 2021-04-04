
package io.github.ph1lou.werewolfapi.events.lovers;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LoverDeathEvent extends Event {


    private final IPlayerWW playerWW1;
    private final IPlayerWW playerWW2;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public LoverDeathEvent(IPlayerWW playerWW1, IPlayerWW playerWW2){
        this.playerWW1 = playerWW1;
        this.playerWW2 = playerWW2;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getPlayerWW2() {
        return playerWW2;
    }

    public IPlayerWW getPlayerWW1() {
        return playerWW1;
    }

}
