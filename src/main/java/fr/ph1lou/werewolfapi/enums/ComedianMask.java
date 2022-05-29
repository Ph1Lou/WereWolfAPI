package fr.ph1lou.werewolfapi.enums;

import org.bukkit.potion.PotionEffectType;
@SuppressWarnings({"unused"})
public enum ComedianMask {
    RESISTANCE("werewolf.roles.comedian.1",PotionEffectType.DAMAGE_RESISTANCE),
    SPEED("werewolf.roles.comedian.2",PotionEffectType.SPEED),
    STRENGTH("werewolf.roles.comedian.3",PotionEffectType.INCREASE_DAMAGE);

    private final String key;
    private final PotionEffectType potionEffectType;

    ComedianMask(String key, PotionEffectType potionEffectType) {
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
