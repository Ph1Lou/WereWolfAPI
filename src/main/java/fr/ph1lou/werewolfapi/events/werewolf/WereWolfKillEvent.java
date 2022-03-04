package fr.ph1lou.werewolfapi.events.werewolf;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WereWolfKillEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel = false;
    private final IPlayerWW werewolfWW;
    private final IPlayerWW victimWW;

    public WereWolfKillEvent(IPlayerWW werewolfWW, IPlayerWW victimWW) {
        this.werewolfWW = werewolfWW;
        this.victimWW = victimWW;
    }


    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        cancel = b;
    }

    public IPlayerWW getWerewolf() {
        return this.werewolfWW;
    }

    public IPlayerWW getVictimWW() {
        return this.victimWW;
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
