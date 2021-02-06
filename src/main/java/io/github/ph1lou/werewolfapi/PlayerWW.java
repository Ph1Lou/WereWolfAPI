package io.github.ph1lou.werewolfapi;


import io.github.ph1lou.werewolfapi.enums.Sound;
import io.github.ph1lou.werewolfapi.enums.StatePlayer;
import io.github.ph1lou.werewolfapi.rolesattributs.Roles;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Ph1Lou
 */

public interface PlayerWW {

    void addPlayerMaxHealth(int heart);

    void removePlayerMaxHealth(int heart);

    void addPlayerHealth(int heart);

    void removePlayerHealth(int heart);

    @Deprecated
    void sendMessage(String message);

    void sendMessageWithKey(String key,Object ... args);

    void sendMessageWithKey(String key, Sound sound, Object ... args);

    void sendMessage(TextComponent textComponent);

    void sendMessage(TextComponent textComponent, Sound sound);

    void addPotionEffect(PotionEffectType potion, int duration, int amplifier);

    void addPotionEffect(PotionEffectType potion);

    void removePotionEffect(PotionEffectType potion);

    List<? extends PotionEffectType> getPotionEffects();

    void teleport(Location location);

    void setItemDeath(ItemStack[] items);

    List<? extends ItemStack> getItemDeath();

    void clearItemDeath();

    void setState(StatePlayer statePlayer) ;

    boolean isState(StatePlayer statePlayer);

    void addOneKill() ;

    int getNbKill();

    void setRole(Roles role);

    Roles getRole();

    boolean isKey(String key);

    void setSpawn(Location spawn);

    Location getSpawn();

    void addKiller(PlayerWW playerWW);

    List<? extends PlayerWW> getKillers();

    void setDeathTime(Integer deathTime);

    int getDeathTime();

    List<? extends LoverAPI> getLovers();

    void addLover(LoverAPI loverAPI);

    void removeLover(LoverAPI loverAPI);

    Optional<PlayerWW> getLastKiller();

    String getName() ;

    void setName(String name) ;

    StatePlayer getState();

    int getDisconnectedTime();

    void setDisconnectedTime(int disconnectedTime);

    UUID getUUID();

    void updateAfterReconnect(Player player);

    void setDisconnectedLocation(Location location);

    void addItem(ItemStack item);

    int getMaxHealth();

    @NotNull
    Location getLocation();
}

