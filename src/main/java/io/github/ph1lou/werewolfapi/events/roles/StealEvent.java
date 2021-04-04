
package io.github.ph1lou.werewolfapi.events.roles;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class StealEvent extends Event {

    private final IPlayerWW thiefWW;
    private final IPlayerWW playerWW;
    private final String role;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public StealEvent(IPlayerWW thiefWW, IPlayerWW playerWW, String role){
        this.thiefWW = thiefWW;
        this.playerWW = playerWW;
        this.role=role;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getThiefWW() {
        return thiefWW;
    }

    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    public String getRole() {
        return role;
    }
}
