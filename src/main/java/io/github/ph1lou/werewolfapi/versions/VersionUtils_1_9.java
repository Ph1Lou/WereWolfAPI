package io.github.ph1lou.werewolfapi.versions;


import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

public class VersionUtils_1_9 extends VersionUtils_1_8 {


    @Override
    public void addPlayerMaxHealth(@NotNull Player player, double health) {
        setPlayerMaxHealth(player,getPlayerMaxHealth(player)+health);
    }

    @Override
    public void removePlayerMaxHealth(@NotNull Player player, double health) {
        setPlayerMaxHealth(player,Math.max(2,getPlayerMaxHealth(player)-health));
    }

    @Override
    public void setPlayerMaxHealth(@NotNull Player player, double maxHealth) {
        AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (attribute == null) return;
        attribute.setBaseValue(maxHealth);
    }

    @Override
    public double getPlayerMaxHealth(@NotNull Player player) {
        AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (attribute == null) return 20;
        return attribute.getBaseValue();
    }


    @Override
    public void setTeamNameTagVisibility(Team team, boolean value) {
        team.setOption(Team.Option.NAME_TAG_VISIBILITY, value ? Team.OptionStatus.ALWAYS : Team.OptionStatus.NEVER);
    }

    @Override
    public ItemStack getItemInHand(@NotNull Player player) {
        return player.getInventory().getItemInMainHand();
    }


}

