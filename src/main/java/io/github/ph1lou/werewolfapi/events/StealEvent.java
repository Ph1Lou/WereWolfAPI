
package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class StealEvent extends Event {

    private final PlayerWW thiefWW;
    private final PlayerWW playerWW;
    private final String role;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public StealEvent(PlayerWW thiefWW, PlayerWW playerWW, String role){
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

    public PlayerWW getThiefWW() {
        return thiefWW;
    }

    public PlayerWW getPlayerWW() {
        return playerWW;
    }

    public String getRole() {
        return role;
    }
}
