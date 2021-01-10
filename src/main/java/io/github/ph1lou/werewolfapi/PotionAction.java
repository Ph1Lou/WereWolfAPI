package io.github.ph1lou.werewolfapi;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionAction {

    private final PotionEffectType potionEffectType;

    private final int amplifier;

    private final int duration;

    private final boolean add;

    public PotionAction(PotionEffectType potionEffectType,int duration,int amplifier){

        if(potionEffectType.equals(PotionEffectType.INCREASE_DAMAGE)){
            this.amplifier=-1;
        }
        else this.amplifier=amplifier;

        this.duration=duration;

        this.potionEffectType=potionEffectType;

        this.add=true;

    }

    public PotionAction(PotionEffectType potionEffectType, boolean add){

        this.potionEffectType=potionEffectType;

        this.duration=Integer.MAX_VALUE;

        this.amplifier=0;

        this.add=add;

    }

    public void executePotionAction(Player player){

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
}
