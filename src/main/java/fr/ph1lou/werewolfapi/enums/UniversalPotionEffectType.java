package fr.ph1lou.werewolfapi.enums;

import fr.ph1lou.werewolfapi.utils.BukkitUtils;
import org.bukkit.potion.PotionEffectType;

public enum UniversalPotionEffectType {

    SPEED,
    SLOWNESS("SLOW", 20),
    HAST("FAST_DIGGING", 20),
    MINING_FATIGUE("SLOW_DIGGING", 20),
    STRENGTH("INCREASE_DAMAGE", 20),
    INSTANT_HEALTH("HEAL", 20),
    INSTANT_DAMAGE("HARM", 20),
    JUMP_BOOST("JUMP", 20),
    NAUSEA("CONFUSION", 20),
    REGENERATION,
    RESISTANCE("DAMAGE_RESISTANCE", 20),
    FIRE_RESISTANCE(),
    WATER_BREATHING,
    INVISIBILITY,
    BLINDNESS,
    NIGHT_VISION,
    HUNGER,
    WEAKNESS,
    POISON,
    WITHER,
    HEALTH_BOOST,
    ABSORPTION,
    SATURATION,
    GLOWING,
    LEVITATION,
    LUCK,
    UNLUCK,
    SLOW_FALLING,
    CONDUIT_POWER,
    DOLPHINS_GRACE,
    BAD_OMEN,
    HERO_OF_THE_VILLAGE,
    DARKNESS,
    TRIAL_OMEN,
    RAID_OMEN,
    WIND_CHARGED,
    WEAVING,
    OOZING,
    INFESTED;

    private final String oldName;
    private final int version;

    UniversalPotionEffectType(){
        this.oldName = "";
        this.version = -1;
    }
    
    UniversalPotionEffectType(String oldName, int version){
        this.oldName = oldName;
        this.version = version;
    }

    public PotionEffectType getPotionEffectType() {
        try{
            int version = BukkitUtils.loadServerVersion();
            if(version < this.version){
                return (PotionEffectType) PotionEffectType.class.getDeclaredField(this.oldName).get(null);
            }
            return (PotionEffectType) PotionEffectType.class.getDeclaredField(name()).get(null);
        }
        catch (NoSuchFieldException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }

    public static UniversalPotionEffectType getUniversalPotionEffectType(PotionEffectType potionEffectType) {
        int version = BukkitUtils.loadServerVersion();
        String name = potionEffectType.getName();
        for (UniversalPotionEffectType value : values()) {
            if(value.oldName.equals(name)){
                return value;
            }
            else if(value.name().equals(name)){
                return value;
            }
        }
        return UniversalPotionEffectType.UNLUCK;
    }
}
