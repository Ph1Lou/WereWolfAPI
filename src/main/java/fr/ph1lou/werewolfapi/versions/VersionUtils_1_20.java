package fr.ph1lou.werewolfapi.versions;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class VersionUtils_1_20 extends VersionUtils_1_16 {

    @Override
    public void addPlayerAbsorptionHealth(Player player, double health) {
        player.getAttribute(Attribute.valueOf("GENERIC_MAX_ABSORPTION")).setBaseValue(Math.max(20, health));
        player.setAbsorptionAmount(health);
    }
}
