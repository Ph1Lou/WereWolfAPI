package fr.ph1lou.werewolfapi.events.roles.gravedigger;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class TriggerGravediggerClueEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final int clueCount;
    private final Location location;
    private int numNearbyPlayers;
    private List<String> playerNames;
    private final String roleKey;
    private final IPlayerWW playerWW;

    public TriggerGravediggerClueEvent(IPlayerWW playerWW, int clueCount, Location location, int numNearbyPlayers, List<String> playerNames, String roleKey) {
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

    public int getNumNearbyPlayers() {return numNearbyPlayers;}

    public void setNumNearbyPlayers(int n) {this.numNearbyPlayers = n;}

    public String getRoleKey() {return roleKey;}

    public List<String> getPlayerNames() {return playerNames;}

    public void setPlayerNames(List<String> names) {this.playerNames = names;}

    public IPlayerWW getPlayerWW() {return playerWW;}
}
