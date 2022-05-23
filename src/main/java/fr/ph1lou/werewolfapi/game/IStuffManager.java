package fr.ph1lou.werewolfapi.game;

import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public interface IStuffManager {

    List<? extends ItemStack> getDeathLoot();
    List<? extends ItemStack> getStartLoot();
    void clearDeathLoot();
    void clearStartLoot();
    void clearStuffRoles();
    void clearTempStuff();
    void addDeathLoot(ItemStack i);
    void addStartLoot(ItemStack i);
    List<? extends ItemStack> getStuffRole(String key);
    void setStuffRole(String key, List<ItemStack> items);
    List<? extends ItemStack> recoverTempStuff(UUID player);
    void putTempStuff(UUID player, List<ItemStack> items);
    boolean isInTempStuff(UUID uuid);
}
