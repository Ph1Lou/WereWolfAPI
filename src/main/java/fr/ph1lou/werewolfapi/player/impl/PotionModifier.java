package fr.ph1lou.werewolfapi.player.impl;

import org.bukkit.potion.PotionEffectType;

public class PotionModifier {

    private final PotionEffectType potionEffectType;

    private final int amplifier;

    private final int duration;

    private final boolean add;

    private final String identifier;

    private int timer = Integer.MAX_VALUE;

    private PotionModifier(PotionEffectType potionEffectType, int duration, int amplifier, String identifier,  boolean add){

        if(potionEffectType.equals(PotionEffectType.INCREASE_DAMAGE)){
            this.amplifier=-1;
        }
        else {
            this.amplifier=amplifier;
        }

        this.duration=duration;

        this.potionEffectType=potionEffectType;

        this.add= add;

        this.identifier = identifier;
    }

    public static PotionModifier add(PotionEffectType potionEffectType, int duration, int amplifier, String identifier){
        return new PotionModifier(potionEffectType,duration,amplifier, identifier,true);
    }

    public static PotionModifier add(PotionEffectType potionEffectType, String identifier){
        return new PotionModifier(potionEffectType,Integer.MAX_VALUE,0, identifier,true);
    }

    @Deprecated
    public static PotionModifier remove(PotionEffectType potionEffectType, String identifier){
        return new PotionModifier(potionEffectType,0,0, identifier,false);
    }

    public static PotionModifier remove(PotionEffectType potionEffectType, String identifier, int amplifier){
        return new PotionModifier(potionEffectType,0,amplifier, identifier,false);
    }

    public void setTimer(int timer){
        this.timer=timer;
    }


    public boolean isAdd() {
        return this.add;
    }

    public PotionEffectType getPotionEffectType() {
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
}