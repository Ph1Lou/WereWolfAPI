package fr.ph1lou.werewolfapi.events.roles.comedian;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


@StatisticsEvent(key = "werewolf.mask")
@TellableStoryEvent
public class UseMaskEvent extends Event implements Cancellable {

    private static final String[] masks = {"werewolf.mask_strength", "werewolf.mask_speed", "werewolf.mask_resistance"};
    private final IPlayerWW playerWW;
    private final int mask;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancel=false;

    public UseMaskEvent(IPlayerWW playerWW, int mask){
        this.playerWW = playerWW;
        this.mask = mask;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @StatisticsPlayer
    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    public int getMask() {
        return mask;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }

    @StatisticsExtraInfo
    public String getExtraInfo(){
        return masks[getMask()];
    }
}

