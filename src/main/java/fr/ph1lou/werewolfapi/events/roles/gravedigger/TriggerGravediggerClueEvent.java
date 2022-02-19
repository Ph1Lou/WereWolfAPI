package fr.ph1lou.werewolfapi.events.roles.gravedigger;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author havwila
 */

public class TriggerGravediggerClueEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final int clueCount;
    private Location location;
    private int numNearbyPlayers;
    private List<String> playerNames;
    private final IPlayerWW gravedigger;
    private final String roleKey;
    private final IPlayerWW playerWW;
    private boolean cancelled = false;

    public TriggerGravediggerClueEvent(IPlayerWW gravedigger, IPlayerWW playerWW, int clueCount, Location location, int numNearbyPlayers, List<String> playerNames, String roleKey) {
        this.gravedigger = gravedigger;
        this.clueCount = clueCount;
        this.location = location;
        this.numNearbyPlayers = numNearbyPlayers;
        this.playerNames = playerNames;
        this.roleKey = roleKey;
        this.playerWW = playerWW;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public int getClueCount() {return clueCount;}

    public Location getLocation() {return location;}

    public void setLocation(Location location) {this.location = location;}

    public int getNumNearbyPlayers() {return numNearbyPlayers;}

    public void setNumNearbyPlayers(int n) {this.numNearbyPlayers = n;}

    public String getRoleKey() {return roleKey;}

    public List<String> getPlayerNames() {return playerNames;}

    public void setPlayerNames(List<String> names) {this.playerNames = names;}

    public IPlayerWW getPlayerWW() {return playerWW;}

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    public IPlayerWW getGravedigger() {
        return gravedigger;
    }
}
