package io.github.ph1lou.werewolfapi.events;

import io.github.ph1lou.werewolfapi.PlayerWW;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class EnchantmentEvent extends Event {


    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final PlayerWW playerWW;
    private final ItemStack item;
    private final Map<Enchantment,Integer> enchants;
    private final Map<Enchantment,Integer> finalEnchants;

    public EnchantmentEvent(PlayerWW playerWW, ItemStack item, Map<Enchantment, Integer> enchants, Map<Enchantment, Integer> finalEnchants) {
        this.playerWW = playerWW;
        this.item = item;
        this.enchants = enchants;
        this.finalEnchants = finalEnchants;
    }


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public PlayerWW getPlayerWW() {
        return playerWW;
    }

    public ItemStack getItem() {
        return item;
    }

    public Map<Enchantment, Integer> getEnchants() {
        return enchants;
    }

    public Map<Enchantment, Integer> getFinalEnchants() {
        return finalEnchants;
    }
}
