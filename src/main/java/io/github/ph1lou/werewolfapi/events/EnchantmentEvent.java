package io.github.ph1lou.werewolfapi.events;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EnchantmentEvent extends Event {


    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final UUID playerUUID;
    private final ItemStack item;
    private final Map<Enchantment,Integer> enchants;
    private final Map<Enchantment,Integer> finalEnchants;

    public EnchantmentEvent(UUID playerUUID, ItemStack item, Map<Enchantment, Integer> enchants, Map<Enchantment, Integer> finalEnchants) {
        this.playerUUID = playerUUID;
        this.item = item;
        this.enchants = enchants;
        this.finalEnchants = finalEnchants;
    }


    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
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
