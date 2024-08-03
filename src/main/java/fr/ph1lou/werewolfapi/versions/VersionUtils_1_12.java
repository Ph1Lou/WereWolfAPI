package fr.ph1lou.werewolfapi.versions;

import fr.ph1lou.werewolfapi.GetWereWolfAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

public class VersionUtils_1_12 extends VersionUtils_1_11 {

    @Override
    public void setItemUnbreakable(ItemMeta meta, boolean b) {
        meta.setUnbreakable(b);
    }


    @Override
    public void sendTitle(@NotNull Player player, String title, String subtitle, int fadeInTime, int showTime, int fadeOutTime) {
        player.sendTitle(title, subtitle, fadeInTime, showTime, fadeOutTime);
    }

    @Override
    public ShapedRecipe registerCraft(ItemStack result, String key) {
        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if (api == null) {
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        return new ShapedRecipe(new NamespacedKey((Plugin) api, key), result);
    }


    @Override
    public void setPrefixAndColor(Team team, String prefix, ChatColor chatColor) {
        team.setColor(chatColor);
        team.setPrefix(prefix.substring(Math.max(prefix.length() - 16, 0)));
    }
}
