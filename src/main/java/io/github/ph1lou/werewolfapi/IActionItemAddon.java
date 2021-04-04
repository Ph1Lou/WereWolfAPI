package io.github.ph1lou.werewolfapi;

import fr.minuskube.inv.SmartInventory;
import org.bukkit.entity.Player;


@FunctionalInterface
public interface IActionItemAddon {

    void make(Player player, SmartInventory previous);
}
