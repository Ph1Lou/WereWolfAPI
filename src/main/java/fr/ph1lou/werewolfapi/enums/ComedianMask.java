package fr.ph1lou.werewolfapi.enums;

@SuppressWarnings({"unused"})
public enum ComedianMask {
    RESISTANCE("werewolf.roles.comedian.1", UniversalPotionEffectType.RESISTANCE),
    SPEED("werewolf.roles.comedian.2", UniversalPotionEffectType.SPEED),
    STRENGTH("werewolf.roles.comedian.3", UniversalPotionEffectType.STRENGTH);

    private final String key;
    private final UniversalPotionEffectType potionEffectType;

    ComedianMask(String key, UniversalPotionEffectType potionEffectType) {
        this.key = key;
        this.potionEffectType = potionEffectType;
    }

    public String getKey() {
        return this.key;
    }

    public UniversalPotionEffectType getPotionEffectType() {
        return potionEffectType;
    }
}
