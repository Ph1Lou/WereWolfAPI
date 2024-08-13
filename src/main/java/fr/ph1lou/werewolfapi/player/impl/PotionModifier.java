package fr.ph1lou.werewolfapi.player.impl;

import fr.ph1lou.werewolfapi.enums.UniversalPotionEffectType;

public class PotionModifier {

    private final UniversalPotionEffectType potionEffectType;

    private final int amplifier;

    private final int duration;

    private final boolean add;

    private final String identifier;

    private int timer = Integer.MAX_VALUE;

    private PotionModifier(UniversalPotionEffectType potionEffectType, int duration, int amplifier, String identifier, boolean add) {

        if (potionEffectType.equals(UniversalPotionEffectType.STRENGTH)) {
            this.amplifier = -1;
        } else {
            this.amplifier = amplifier;
        }

        this.duration = duration;

        this.potionEffectType = potionEffectType;

        this.add = add;

        this.identifier = identifier;
    }

    public static PotionModifier add(UniversalPotionEffectType potionEffectType, int duration, int amplifier, String identifier) {
        return new PotionModifier(potionEffectType, duration, amplifier, identifier, true);
    }

    public static PotionModifier add(UniversalPotionEffectType potionEffectType, String identifier) {
        return new PotionModifier(potionEffectType, Integer.MAX_VALUE, 0, identifier, true);
    }

    @Deprecated
    public static PotionModifier remove(UniversalPotionEffectType potionEffectType, String identifier) {
        return new PotionModifier(potionEffectType, 0, 0, identifier, false);
    }

    public static PotionModifier remove(UniversalPotionEffectType potionEffectType, String identifier, int amplifier) {
        return new PotionModifier(potionEffectType, 0, amplifier, identifier, false);
    }

    public boolean isAdd() {
        return this.add;
    }

    public UniversalPotionEffectType getPotionEffectType() {
        return this.potionEffectType;
    }

    public int getAmplifier() {
        return this.amplifier;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int getTimer() {
        return this.timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
}