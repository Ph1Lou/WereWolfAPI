package io.github.ph1lou.werewolfapi;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionModifier {

    private final PotionEffectType potionEffectType;

    private final int amplifier;

    private final int duration;

    private final boolean add;

    private final String identifier;

    private boolean use = false;

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

    public static PotionModifier remove(PotionEffectType potionEffectType, String identifier){
        return new PotionModifier(potionEffectType,0,0, identifier,false);
    }

    public void setTimer(int timer){
        this.timer=timer;
    }

    public void setUse(){
        this.use=true;
    }

    public boolean isUse(){
        return this.use;
    }

    public void executePotionAction(Player player){

        if(use){
            return;
        }

        if(add){
            PotionEffect potionEffect = new PotionEffect(potionEffectType,
                    duration,
                    amplifier,
                    false,
                    false);

            player.addPotionEffect(potionEffect);
            return;
        }

        player.removePotionEffect(potionEffectType);

    }

    public boolean isAdd() {
        return add;
    }

    public PotionEffectType getPotionEffectType() {
        return potionEffectType;
    }

    public int getAmplifier() {
        return amplifier;
    }

    public int getDuration() {
        return duration;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getTimer() {
        return timer;
    }
}