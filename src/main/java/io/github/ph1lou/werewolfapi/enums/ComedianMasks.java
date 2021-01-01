package io.github.ph1lou.werewolfapi.enums;

import org.bukkit.potion.PotionEffectType;

public enum ComedianMasks {
    RESISTANCE("werewolf.role.comedian.1",PotionEffectType.DAMAGE_RESISTANCE),
    SPEED("werewolf.role.comedian.2",PotionEffectType.SPEED),
    STRENGTH("werewolf.role.comedian.3",PotionEffectType.INCREASE_DAMAGE);

    private final String key;
    private final PotionEffectType potionEffectType;

    ComedianMasks(String key, PotionEffectType potionEffectType) {
        this.key = key;
        this.potionEffectType=potionEffectType;
    }

    public String getKey(){
        return this.key;
    }

    public PotionEffectType getPotionEffectType() {
        return potionEffectType;
    }
}
