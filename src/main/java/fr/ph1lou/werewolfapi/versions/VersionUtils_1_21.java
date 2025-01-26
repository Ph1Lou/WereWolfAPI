package fr.ph1lou.werewolfapi.versions;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VersionUtils_1_21 extends VersionUtils_1_16 {

    @Override
    public void addPlayerAbsorptionHealth(Player player, double health) {
        player.getAttribute(Attribute.MAX_ABSORPTION).setBaseValue(Math.max(20, health));
        player.setAbsorptionAmount(health);
    }

    @Override
    public void setPlayerMaxHealth(@NotNull Player player, double maxHealth) {
        AttributeInstance attribute = player.getAttribute(Attribute.MAX_HEALTH);
        if (attribute == null) return;
        attribute.setBaseValue(maxHealth);
    }

    @Override
    public double getPlayerMaxHealth(@NotNull Player player) {
        AttributeInstance attribute = player.getAttribute(Attribute.MAX_HEALTH);
        if (attribute == null) return 20;
        return attribute.getBaseValue();
    }

}
