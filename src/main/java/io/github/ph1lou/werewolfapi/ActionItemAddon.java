package io.github.ph1lou.werewolfapi;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

@FunctionalInterface
public interface ActionItemAddon {

    void make(Player player, Inventory previous);
}
