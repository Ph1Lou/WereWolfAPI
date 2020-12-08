
package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CursedLoverDeathEvent extends Event {

    private final PlayerWW playerWW1;
    private final PlayerWW playerWW2;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public CursedLoverDeathEvent(PlayerWW lover1Uuid, PlayerWW playerWW2){
        this.playerWW1 =lover1Uuid;
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

    public PlayerWW getPlayerWW1() {
        return playerWW1;
    }

    public PlayerWW getPlayerWW2() {
        return playerWW2;
    }

}
