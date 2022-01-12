package fr.ph1lou.werewolfapi.events.roles.druid;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DruidUsePowerEvent extends Event implements Cancellable {

    private final IPlayerWW playerWW;
    private final int darkAura;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel=false;

    public DruidUsePowerEvent(IPlayerWW playerWW, int darkAura){
        this.playerWW = playerWW;
        this.darkAura = darkAura;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    public int getDarkAura() {
        return darkAura;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }
}

