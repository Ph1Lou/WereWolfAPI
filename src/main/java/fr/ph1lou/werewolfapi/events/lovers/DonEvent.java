package fr.ph1lou.werewolfapi.events.lovers;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DonEvent extends Event implements Cancellable {

    private final IPlayerWW playerWW;
    private final IPlayerWW receiverWW;
    private final int don;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public DonEvent(IPlayerWW playerWW, IPlayerWW receiverWW, int don){
        this.playerWW = playerWW;
        this.receiverWW = receiverWW;
        this.don = don;
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
        return playerWW;
    }

    public IPlayerWW getReceiverWW() {
        return receiverWW;
    }

    public int getDon() {
        return don;
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

