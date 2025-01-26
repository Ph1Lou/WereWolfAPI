package fr.ph1lou.werewolfapi.versions;


import fr.ph1lou.werewolfapi.enums.PotionDurationUtil;
import fr.ph1lou.werewolfapi.enums.PotionUtil;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class VersionUtils_1_9 extends VersionUtils_1_8 {

    @Override
    public ItemStack getPotionItem(short id) {
        byte data = (byte) id;
        byte data2 = (byte) (id >> 8);
        PotionType type = PotionType.valueOf(PotionUtil.getPotion((byte) (data & 0b00011111)));
        ItemStack item = new ItemStack((data2 & 0b01000000) == 0b01000000 ?
                Material.SPLASH_POTION :
                Material.POTION);
        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();


        try {
            Class<?> potionDataClass = Class.forName("org.bukkit.potion.PotionData");
            Object potionData = potionDataClass.getConstructor(PotionType.class, boolean.class, boolean.class)
                    .newInstance(type,
                            ((data & 0b01000000) == 0b01000000) && type.isExtendable(),
                            ((data & 0b00100000) == 0b00100000) && type.isUpgradeable());

            if (potionMeta != null) {
                PotionMeta.class.getMethod("setBasePotionData", potionDataClass).invoke(potionMeta, potionData);
            }

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        item.setItemMeta(potionMeta);
        return item;
    }


    @Override
    public Collection<PotionEffect> getPotionEffect(@NotNull ItemStack itemStack) {
        if (itemStack.getItemMeta() instanceof PotionMeta) {
            PotionMeta potionMeta = (PotionMeta) itemStack.getItemMeta();
            List<PotionEffect> potionEffectList = new ArrayList<>(potionMeta.getCustomEffects());

            try {
                Object potionData = PotionMeta.class.getMethod("getBasePotionData").invoke(potionMeta);
                PotionType type = (PotionType) potionData.getClass().getMethod("getType").invoke(potionData);
                PotionEffectType potionEffectType = (PotionEffectType) type.getClass().getMethod("getEffectType").invoke(type);

                if (potionEffectType != null) {
                    boolean isUpgraded = (boolean) potionData.getClass().getMethod("isUpgraded").invoke(potionData);
                    boolean isExtended = (boolean) potionData.getClass().getMethod("isExtended").invoke(potionData);

                    potionEffectList.add(new PotionEffect(potionEffectType,
                            PotionDurationUtil.getDuration(potionEffectType, isExtended, isUpgraded),
                            PotionDurationUtil.getAmplifier(potionEffectType, isUpgraded),
                            false,
                            false));
                }
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            return potionEffectList;
        }
        return Collections.emptyList();
    }

    @Override
    public short generatePotionId(ItemStack itemStack) {

        if (!(itemStack.getItemMeta() instanceof PotionMeta)) {
            return 0;
        }

        PotionMeta potionMeta = (PotionMeta) itemStack.getItemMeta();

        try {
            Object potionData = PotionMeta.class.getMethod("getBasePotionData").invoke(potionMeta);
            boolean isUpgraded = (boolean) potionData.getClass().getMethod("isUpgraded").invoke(potionData);
            boolean isExtended = (boolean) potionData.getClass().getMethod("isExtended").invoke(potionData);
            PotionType type = (PotionType) potionData.getClass().getMethod("getType").invoke(potionData);

            byte data = PotionUtil.getId(type.name());

            if (data == 0) {  //POTION > 1.8
                return 0;
            }
            byte data2 = 0;
            if (isExtended) {
                data |= 0b01000000;
            }
            if (isUpgraded) {
                data |= 0b00100000;
            }
            if (itemStack.getType() == Material.SPLASH_POTION) {
                data2 |= 0b01000000;
            } else {
                data2 |= 0b00100000;
            }

            return (short) (data2 << 8 | data);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addPlayerMaxHealth(@NotNull Player player, double health) {
        setPlayerMaxHealth(player, getPlayerMaxHealth(player) + health);
    }

    @Override
    public void removePlayerMaxHealth(@NotNull Player player, double health) {
        setPlayerMaxHealth(player, Math.max(2, getPlayerMaxHealth(player) - health));
    }

    @Override
    public void setPlayerMaxHealth(@NotNull Player player, double maxHealth) {
        AttributeInstance attribute = player.getAttribute(Attribute.valueOf("GENERIC_MAX_HEALTH"));
        if (attribute == null) return;
        attribute.setBaseValue(maxHealth);
    }

    @Override
    public double getPlayerMaxHealth(@NotNull Player player) {
        AttributeInstance attribute = player.getAttribute(Attribute.valueOf("GENERIC_MAX_HEALTH"));
        if (attribute == null) return 20;
        return attribute.getBaseValue();
    }


    @Override
    public void setTeamNameTagVisibility(Team team, boolean value) {
        team.setOption(Team.Option.NAME_TAG_VISIBILITY, value ? Team.OptionStatus.ALWAYS : Team.OptionStatus.NEVER);
    }

    @Override
    public ItemStack getItemInHand(@NotNull Player player) {
        return player.getInventory().getItemInMainHand();
    }

    @Override
    public void setItemInHand(@NotNull Player player, ItemStack itemStack) {
        player.getInventory().setItemInMainHand(itemStack);
    }
}

