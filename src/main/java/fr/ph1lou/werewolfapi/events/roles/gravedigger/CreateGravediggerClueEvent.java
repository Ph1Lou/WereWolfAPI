package fr.ph1lou.werewolfapi.events.roles.gravedigger;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * @author havwila
 */

public class CreateGravediggerClueEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private final IPlayerWW gravedigger;
    private final Location location;
    private Set<IPlayerWW> nearbyPlayers;
    private String roleKey;
    private boolean cancelled = false;

    public CreateGravediggerClueEvent(IPlayerWW gravedigger, IPlayerWW playerWW, Location location, Set<IPlayerWW> nearbyPlayers, String roleKey) {
        this.gravedigger = gravedigger;
        this.playerWW = playerWW;
        this.location = location;
        this.nearbyPlayers = nearbyPlayers;
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

    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    public Location getDeathLocation() {
        return location;
    }

    public Set<IPlayerWW> getNearbyPlayers() {
        return nearbyPlayers;
    }

    public void setNearbyPlayers(Set<IPlayerWW> playersWW) {
        this.nearbyPlayers = playersWW;
    }

    public void addNearbyPlayer(IPlayerWW p) {
        nearbyPlayers.add(p);
    }

    public void removeNearbyPlayer(IPlayerWW p) {
        nearbyPlayers.remove(p);
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String key) {
        this.roleKey = key;
    }

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
