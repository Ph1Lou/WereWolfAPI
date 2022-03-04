package fr.ph1lou.werewolfapi.events.roles.wise_elder;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WiseElderRevealAuraAmountEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private final int neutral;
    private final int dark;
    private final int light;
    private boolean cancel = false;

    public WiseElderRevealAuraAmountEvent(IPlayerWW playerWW, int neutral, int dark, int light) {
        this.playerWW = playerWW;
        this.neutral = neutral;
        this.dark = dark;
        this.light = light;
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

    public int getNeutral() {
        return neutral;
    }

    public int getDark() {
        return dark;
    }

    public int getLight() {
        return light;
    }

    @Override
    public boolean isCancelled() {
        return this.cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }
}
