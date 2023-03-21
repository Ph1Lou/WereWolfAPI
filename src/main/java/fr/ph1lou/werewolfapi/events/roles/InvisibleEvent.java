package fr.ph1lou.werewolfapi.events.roles;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


@StatisticsEvent(key = "werewolf.invisible")
public class InvisibleEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private final boolean invisible;

    public InvisibleEvent(IPlayerWW playerWW, boolean invisible) {
        this.playerWW = playerWW;
        this.invisible = invisible;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @StatisticsPlayer
    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    public boolean isInvisible() {
        return invisible;
    }

    @StatisticsExtraInfo
    public String getExtraInfo() {
        return isInvisible() ? "invisible" : "visible";
    }
}