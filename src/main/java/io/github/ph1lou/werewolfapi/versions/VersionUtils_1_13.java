package io.github.ph1lou.werewolfapi.versions;


import org.bukkit.GameRule;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.inventory.meta.SkullMeta;

public class VersionUtils_1_13 extends VersionUtils_1_12 {


    @Override
    public void setSkullOwner(SkullMeta skull, OfflinePlayer player, String name) {
        if (skull != null) {
            skull.setOwningPlayer(player);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setGameRuleValue(World world, String name, Object value) {
        GameRule gameRule = GameRule.getByName(name);

        if (gameRule == null) return;
        world.setGameRule(gameRule, value);
    }



}

