package io.github.ph1lou.pluginlgapi.rolesattributs;

import org.bukkit.potion.PotionEffectType;

import java.util.List;

public interface PotionEffects {

    List<PotionEffectType> getPotionEffects();

    PotionEffectType getLastPotionEffect();

    void addPotionEffect(PotionEffectType Effect);

    void removePotionEffect(PotionEffectType Effect);
}
