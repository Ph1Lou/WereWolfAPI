package fr.ph1lou.werewolfapi.events.roles.detective;

import fr.ph1lou.werewolfapi.annotations.SpyEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTargets;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;


@StatisticsEvent(key = "werewolf.enquire")
@SpyEvent
public class InvestigateEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final Set<IPlayerWW> playersUUID;
    private final IPlayerWW playerWW;
    private boolean sameCamp;
    private boolean cancel = false;

    public InvestigateEvent(IPlayerWW playerWW, Set<IPlayerWW> playerWWS, boolean sameCamp) {
        this.playerWW = playerWW;
        this.playersUUID = playerWWS;
        this.sameCamp = sameCamp;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public boolean isSameCamp() {
        return sameCamp;
    }

    public void setSameCamp(boolean sameCamp) {
        this.sameCamp = sameCamp;
    }

    @StatisticsTargets
    public Set<IPlayerWW> getPlayerWWs() {
        return playersUUID;
    }

    @StatisticsPlayer
    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @StatisticsExtraInfo
    public String getExtraInfo() {
        return isSameCamp() ? "werewolf.roles.detective.same_camp" :
                "werewolf.roles.detective.opposing_camp";
    }
}

