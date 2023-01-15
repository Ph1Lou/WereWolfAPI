package fr.ph1lou.werewolfapi.events.roles.druid;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInt;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTargets;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@StatisticsEvent(key = "werewolf.druid_power")
public class DruidUsePowerEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private final int darkAura;
    private final List<IPlayerWW> playerWWs;
    private boolean cancel = false;

    public DruidUsePowerEvent(IPlayerWW playerWW, int darkAura, List<IPlayerWW> playerWWs) {
        this.playerWW = playerWW;
        this.darkAura = darkAura;
        this.playerWWs = playerWWs;
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

    @StatisticsExtraInt
    public int getDarkAura() {
        return darkAura;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    public List<IPlayerWW> getPlayerWWs() {
        return playerWWs;
    }

    @StatisticsTargets
    public Set<IPlayerWW> getTargets() {
        return new HashSet<>(playerWWs);
    }
}

