package fr.ph1lou.werewolfapi.events.game.utils;

import fr.ph1lou.werewolfapi.enums.UniversalEnchantment;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class EnchantmentEvent extends Event {


    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private final ItemStack item;
    private final Map<UniversalEnchantment, Integer> enchants;
    private final Map<UniversalEnchantment, Integer> finalEnchants;

    public EnchantmentEvent(IPlayerWW playerWW, ItemStack item, Map<UniversalEnchantment, Integer> enchants, Map<UniversalEnchantment, Integer> finalEnchants) {
        this.playerWW = playerWW;
        this.item = item;
        this.enchants = enchants;
        this.finalEnchants = finalEnchants;
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

    public ItemStack getItem() {
        return item;
    }

    public Map<UniversalEnchantment, Integer> getEnchants() {
        return enchants;
    }

    public Map<UniversalEnchantment, Integer> getFinalEnchants() {
        return finalEnchants;
    }
}
