package fr.ph1lou.werewolfapi.enums;

import org.bukkit.potion.PotionEffectType;

@SuppressWarnings({"unused"})
public enum PotionDurationUtil {
    SPEED(3600, 9600, 1800),
    INCREASE_DAMAGE(3600, 9600, 1800),
    HEAL(1, 0, 1),
    JUMP(3600, 9600, 1800),
    REGENERATION(900, 1800, 440),
    FIRE_RESISTANCE(3600, 9600),
    WATER_BREATHING(3600, 9600),
    INVISIBILITY(3600, 9600),
    NIGHT_VISION(3600, 9600),
    WEAKNESS(1800, 4800),
    HARM(5, 0, 5),
    POISON(900, 1800, 432),
    SLOW(1800, 4800, 400),
    LUCK(6000),
    SLOW_FALLING(1800, 4800);

    private final int base;
    private final int extended;
    private final int upgraded;

    PotionDurationUtil(int base, int extended, int upgraded) {
        this.base = base;
        this.extended = extended;
        this.upgraded = upgraded;
    }

    PotionDurationUtil(int base, int extended) {
        this(base, extended, 0);
    }

    PotionDurationUtil(int base) {
        this(base, 0);
    }

    /**
     * Get Potion duration
     *
     * @param potionEffectType type
     * @param isExtended       level II potion
     * @param isUpgraded       level + potion
     * @return duration in tick
     */
    public static int getDuration(PotionEffectType potionEffectType, boolean isExtended, boolean isUpgraded) {
        try {
            PotionDurationUtil potionDurationUtil = PotionDurationUtil.valueOf(potionEffectType.getName());
            if (isExtended) {
                return potionDurationUtil.extended;
            }
            if (isUpgraded) {
                return potionDurationUtil.upgraded;
            }
            return potionDurationUtil.base;
        } catch (IllegalArgumentException exception) {
            return 0;
        }
    }

    public static int getAmplifier(PotionEffectType type, boolean upgraded) {

        if (upgraded) {
            if (type == PotionEffectType.SLOW) {
                return 3;
            }
            return 1;
        }
        return 0;
    }
}
