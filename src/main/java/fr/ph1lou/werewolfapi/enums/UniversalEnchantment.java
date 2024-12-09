package fr.ph1lou.werewolfapi.enums;

import fr.ph1lou.werewolfapi.utils.BukkitUtils;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public enum UniversalEnchantment {
    PROTECTION("PROTECTION_ENVIRONMENTAL", 20),
    FIRE_PROTECTION("PROTECTION_FIRE", 20),
    FEATHER_FALLING("PROTECTION_FALL", 20),
    BLAST_PROTECTION("PROTECTION_EXPLOSIONS", 20),
    PROJECTILE_PROTECTION("PROTECTION_PROJECTILE", 20),
    RESPIRATION("OXYGEN", 20),
    AQUA_AFFINITY("WATER_WORKER", 20),
    THORNS,
    DEPTH_STRIDER,
    FROST_WALKER,
    BINDING_CURSE,
    SHARPNESS("DAMAGE_ALL", 20),
    SMITE("DAMAGE_UNDEAD", 20),
    BANE_OF_ARTHROPODS("DAMAGE_ARTHROPODS", 20),
    KNOCKBACK,
    FIRE_ASPECT,
    LOOTING("LOOT_BONUS_MOBS", 20),
    SWEEPING_EDGE,
    EFFICIENCY("DIG_SPEED", 20),
    SILK_TOUCH,
    UNBREAKING("DURABILITY", 20),
    FORTUNE("LOOT_BONUS_BLOCKS", 20),
    POWER("ARROW_DAMAGE", 20),
    PUNCH("ARROW_KNOCKBACK", 20),
    FLAME("ARROW_FIRE", 20),
    INFINITY("ARROW_INFINITE", 20),
    LUCK_OF_THE_SEA("LUCK", 20),
    LURE,
    LOYALTY,
    IMPALING,
    RIPTIDE,
    CHANNELING,
    MULTISHOT,
    QUICK_CHARGE,
    PIERCING,
    DENSITY,
    BREACH,
    WIND_BURST,
    MENDING,
    VANISHING_CURSE,
    SOUL_SPEED,
    SWIFT_SNEAK;

    private final String oldName;
    private final int version;

    UniversalEnchantment(){
        this.oldName = "";
        this.version = -1;
    }

    UniversalEnchantment(String oldName, int version){
        this.oldName = oldName;
        this.version = version;
    }

    public static Map<UniversalEnchantment, Integer> getUniversalEnchantment(Map<Enchantment, Integer> tempEnchant) {
        Map<UniversalEnchantment, Integer> universalEnchantmentIntegerMap = new HashMap<>();
        tempEnchant.forEach((enchantment, integer) -> universalEnchantmentIntegerMap.put(getUniversalEnchantment(enchantment), integer));
        return universalEnchantmentIntegerMap;
    }

    public Enchantment getEnchantment() {
        try{
            int version = BukkitUtils.loadServerVersion();
            if(version < this.version){
                return (Enchantment) Enchantment.class.getDeclaredField(this.oldName).get(null);
            }
            return (Enchantment) Enchantment.class.getDeclaredField(this.name()).get(null);
        }
        catch (NoSuchFieldException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }

    public static UniversalEnchantment getUniversalEnchantment(Enchantment enchantment) {
        int version = BukkitUtils.loadServerVersion();
        String name = enchantment.getName();
        for (UniversalEnchantment value : values()) {
            if(version >= value.version){
                if(value.name().equals(name)) {
                    return value;
                }
            }
            else if(value.oldName.equals(name)){
                return value;
            }
        }
        return UniversalEnchantment.DENSITY;
    }
}
