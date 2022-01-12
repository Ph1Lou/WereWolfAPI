package fr.ph1lou.werewolfapi.enums;

import org.bukkit.potion.PotionType;

import java.util.Arrays;

public enum PotionUtil {

    REGENERATION(PotionType.REGEN, (byte) 1),
    SWIFTNESS(PotionType.SPEED, (byte) 2),
    FIRE_RESISTANCE(PotionType.FIRE_RESISTANCE, (byte) 3),
    POISON(PotionType.POISON, (byte) 4),
    INSTANT_HEAL(PotionType.INSTANT_HEAL, (byte) 5),
    NIGHT_VISION(PotionType.NIGHT_VISION, (byte) 6),
    WEAKNESS(PotionType.WEAKNESS, (byte) 8),
    STRENGTH(PotionType.STRENGTH, (byte) 9),
    SLOWNESS(PotionType.SLOWNESS, (byte) 10),
    LEAPING(PotionType.JUMP, (byte) 11),
    HARMING(PotionType.INSTANT_DAMAGE, (byte) 12),
    WATER_BREATHING(PotionType.WATER_BREATHING, (byte) 13),
    INVISIBILITY(PotionType.INVISIBILITY, (byte) 14);
    private final PotionType potionType;
    private final byte id;

    PotionUtil(PotionType potionType, byte id) {
        this.potionType = potionType;
        this.id = id;
    }


    public static byte getId(PotionType potionType) {
        return Arrays.stream(PotionUtil.values())
                .filter(potion -> potion.potionType == potionType)
                .map(potion -> potion.id).findFirst().orElse((byte) 0);
    }

    public static PotionType getPotion(byte id) {
        return Arrays.stream(PotionUtil.values())
                .filter(potion -> potion.id == id)
                .map(potion -> potion.potionType)
                .findFirst()
                .orElse(PotionType.UNCRAFTABLE);
    }
}