package fr.ph1lou.werewolfapi.enums;

import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings({"unused"})
public enum PotionUtil {

    REGENERATION("REGEN", (byte) 1),
    SWIFTNESS("SPEED", (byte) 2),
    FIRE_RESISTANCE("FIRE_RESISTANCE", (byte) 3),
    POISON("POISON", (byte) 4),
    INSTANT_HEAL("INSTANT_HEAL", (byte) 5),
    NIGHT_VISION("NIGHT_VISION", (byte) 6),
    WEAKNESS("WEAKNESS", (byte) 8),
    STRENGTH("STRENGTH", (byte) 9),
    SLOWNESS("SLOWNESS", (byte) 10),
    LEAPING("JUMP", (byte) 11),
    HARMING("INSTANT_DAMAGE", (byte) 12),
    WATER_BREATHING("WATER_BREATHING", (byte) 13),
    INVISIBILITY("INVISIBILITY", (byte) 14);

    private final String potionType;
    private final byte id;

    PotionUtil(String potionType, byte id) {
        this.potionType = potionType;
        this.id = id;
    }


    public static byte getId(String potionType) {
        return Arrays.stream(PotionUtil.values())
                .filter(potion -> Objects.equals(potion.potionType, potionType))
                .map(potion -> potion.id).findFirst().orElse((byte) 0);
    }

    public static String getPotion(byte id) {
        return Arrays.stream(PotionUtil.values())
                .filter(potion -> potion.id == id)
                .map(potion -> potion.potionType)
                .findFirst()
                .orElse("UNCRAFTABLE");
    }
}