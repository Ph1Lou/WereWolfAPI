package fr.ph1lou.werewolfapi.events.roles.gravedigger;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInt;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author havwila
 */

@StatisticsEvent(key = "werewolf.gravedigger_event")
public class TriggerGravediggerClueEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final int clueCount;
    private final String roleKey;
    private Location location;
    private int numNearbyPlayers;
    private List<String> playerNames;
    private boolean cancelled = false;

    public TriggerGravediggerClueEvent(IPlayerWW gravedigger, IPlayerWW playerWW, int clueCount, Location location, int numNearbyPlayers, List<String> playerNames, String roleKey) {
        super(gravedigger, playerWW);
        this.clueCount = clueCount;
        this.location = location;
        this.numNearbyPlayers = numNearbyPlayers;
        this.playerNames = playerNames;
        this.roleKey = roleKey;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @StatisticsExtraInt
    public int getClueCount() {
        return clueCount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getNumNearbyPlayers() {
        return numNearbyPlayers;
    }

    public void setNumNearbyPlayers(int n) {
        this.numNearbyPlayers = n;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public void setPlayerNames(List<String> names) {
        this.playerNames = names;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }
}
