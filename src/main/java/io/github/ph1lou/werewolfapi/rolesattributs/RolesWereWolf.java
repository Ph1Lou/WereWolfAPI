package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.PlayerWW;
import io.github.ph1lou.werewolfapi.enums.Day;
import io.github.ph1lou.werewolfapi.enums.StatePlayer;
import io.github.ph1lou.werewolfapi.events.DayEvent;
import io.github.ph1lou.werewolfapi.events.NightEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffectType;

public abstract class RolesWereWolf extends RolesImpl {


    public RolesWereWolf(GetWereWolfAPI main, PlayerWW playerWW, String key){
        super(main,playerWW,key);
    }

    @EventHandler
    public void onNightForWereWolf(NightEvent event) {


        if(!getPlayerWW().isState(StatePlayer.ALIVE)){
            return;
        }


        getPlayerWW().addPotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, -1);
    }

    @EventHandler
    public void onDayForWereWolf(DayEvent event) {


        if(!getPlayerWW().isState(StatePlayer.ALIVE)){
            return;
        }

        getPlayerWW().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    }

    @Override
    public void recoverPotionEffect() {

        getPlayerWW().addPotionEffect(PotionEffectType.NIGHT_VISION,Integer.MAX_VALUE,0);
        if(game.isDay(Day.DAY)) return;
        getPlayerWW().addPotionEffect(PotionEffectType.INCREASE_DAMAGE,Integer.MAX_VALUE,-1);
    }


    @Override
    public boolean isNeutral() {
        return false;
    }

    @Override
    public boolean isWereWolf() {
        return true;
    }

}
