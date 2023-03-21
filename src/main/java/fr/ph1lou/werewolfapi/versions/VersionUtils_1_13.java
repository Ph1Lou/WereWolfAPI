package fr.ph1lou.werewolfapi.versions;


import fr.ph1lou.werewolfapi.GetWereWolfAPI;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

public class VersionUtils_1_13 extends VersionUtils_1_12 {


    @Override
    public void setSkullOwner(SkullMeta skull, OfflinePlayer player, String name) {
        if (skull != null) {
            skull.setOwningPlayer(player);
        }
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public <T> void setGameRuleValue(World world, String name, T value) {
        GameRule<T> gameRule = (GameRule<T>) GameRule.getByName(name);

        if (gameRule == null) return;
        world.setGameRule(gameRule, value);
    }

    @Override
    public void hidePlayer(Player viewer, Player player) {
        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if (api == null) {
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        viewer.hidePlayer((Plugin) api, player);
    }

    @Override
    public void showPlayer(Player viewer, Player player) {
        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if (api == null) {
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        viewer.showPlayer((Plugin) api, player);
    }
}

