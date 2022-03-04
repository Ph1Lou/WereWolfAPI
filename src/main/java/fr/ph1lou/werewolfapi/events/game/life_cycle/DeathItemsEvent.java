package fr.ph1lou.werewolfapi.events.game.life_cycle;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DeathItemsEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final IPlayerWW playerWW;
    private final List<ItemStack> items;
    private Location location;
    private boolean cancel = false;

    public DeathItemsEvent(IPlayerWW playerWW, List<ItemStack> items, Location location){
        this.playerWW=playerWW;
        this.items=items;
        this.location=location;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean isCancelled() {
        return this.cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    public List<ItemStack> getItems() {
        return items;
    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
