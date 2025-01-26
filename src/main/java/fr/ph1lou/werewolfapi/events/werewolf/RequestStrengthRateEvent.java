package fr.ph1lou.werewolfapi.events.werewolf;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class RequestStrengthRateEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private int strengthRate;

    public RequestStrengthRateEvent(IPlayerWW playerWW, int strengthRate) {
        this.playerWW = playerWW;
        this.strengthRate = strengthRate;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    public int getStrengthRate() {
        return this.strengthRate;
    }

    public void setStrengthRate(int strengthRate) {
        this.strengthRate = strengthRate;
    }
}

