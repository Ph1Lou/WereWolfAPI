package fr.ph1lou.werewolfapi.player.interfaces;


import fr.ph1lou.werewolfapi.enums.Sound;
import fr.ph1lou.werewolfapi.enums.StatePlayer;
import fr.ph1lou.werewolfapi.lovers.ILover;
import fr.ph1lou.werewolfapi.player.impl.PotionModifier;
import fr.ph1lou.werewolfapi.player.utils.Formatter;
import fr.ph1lou.werewolfapi.role.interfaces.IRole;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * @author Ph1Lou
 */

public interface IPlayerWW {

    /**
     * Increase player max health
     *
     * @param health the amount of health
     */
    void addPlayerMaxHealth(double health);

    /**
     * Decrease player max health (note : player min health is 1)
     *
     * @param health the amount of health
     */
    void removePlayerMaxHealth(double health);

    /**
     * Increase player health
     *
     * @param health the amount of health
     */
    void addPlayerHealth(double health);

    /**
     * Decrease player health
     *
     * @param health the amount of health
     */
    void removePlayerHealth(double health);

    /**
     * Send String message to the player (if he was disconnected, he received the message later)
     *
     * @param key  the key associated to message in language json file
     * @param args for parsing
     */
    void sendMessageWithKey(@NotNull String key, Formatter... args);

    /**
     * Send String message to the player (if he was disconnected, he received the message later)
     *
     * @param prefixKey key of prefix
     * @param key       the key associated to message in language json file
     * @param args      for parsing
     */
    void sendMessageWithKey(@NotNull String prefixKey, @NotNull String key, Formatter... args);

    /**
     * Send String message to the player (if he was disconnected, he received the message later)
     *
     * @param textComponent the message
     */
    void sendMessage(@NotNull TextComponent textComponent);

    /**
     * @param sound the sound
     */
    void sendSound(@NotNull Sound sound);

    /**
     * Add Potion Modifier to add or remove Potion Effect
     *
     * @param potionModifier the potion modifier
     */
    void addPotionModifier(PotionModifier potionModifier);

    /**
     * Clear all Potion Effect of the player
     */
    void clearPotionEffects();

    void clearPotionEffects(String key);

    void clearPlayer();

    /**
     * Get all Potion Modifiers of the player
     */
    Set<? extends PotionModifier> getPotionModifiers();

    /**
     * Teleport player to a location even if it is disconnected
     *
     * @param location the target location
     */
    void teleport(Location location);

    /**
     * Get Death Items
     */
    List<? extends ItemStack> getItemDeath();

    /**
     * Set Death Items
     *
     * @param items the death items
     */
    void setItemDeath(List<ItemStack> items);

    /**
     * Clear Death Items
     */
    void clearItemDeath();

    /**
     * Check if player is in a certain state
     *
     * @param statePlayer the state check
     * @return a boolean
     */
    boolean isState(StatePlayer statePlayer);

    /**
     * add a player in the list of killed players
     *
     * @param playerWW the killed player
     */
    void addOneKill(IPlayerWW playerWW);

    /**
     * get the list of killed players
     */
    List<? extends IPlayerWW> getPlayersKills();

    /**
     * Get MojangUUID of the Player
     *
     * @return the uuid
     */

    Optional<UUID> getMojangUUID();

    UUID getReviewUUID();

    /**
     * Get the player's role
     *
     * @return his role
     */
    IRole getRole();

    /**
     * Change the rôle of a player
     *
     * @param role the role
     */
    void setRole(IRole role);

    /**
     * Get Player Spawn
     *
     * @return the spawn's location
     */
    Location getSpawn();

    /**
     * Change player spawn
     *
     * @param spawn the spawn's location
     */
    void setSpawn(Location spawn);

    /**
     * Add a killer to this player
     *
     * @param playerWW his killer
     */
    void addKiller(IPlayerWW playerWW);

    /**
     * Get the killers
     *
     * @return the killers
     */
    List<? extends IPlayerWW> getKillers();

    /**
     * Get Death Time
     *
     * @return the death time
     */
    int getDeathTime();

    /**
     * Get Lovers
     *
     * @return lovers
     */
    List<? extends ILover> getLovers();

    /**
     * Add Lover
     *
     * @param ILover the lover object
     */
    void addLover(ILover ILover);

    /**
     * Remove Lover
     *
     * @param ILover the lover object
     */
    void removeLover(ILover ILover);

    /**
     * Clear Player Lovers
     */
    void clearLover();

    /**
     * Get Last killer
     *
     * @return the last killer if he exists
     */
    Optional<IPlayerWW> getLastKiller();

    /**
     * Get Player who damaged the player during last minutes
     *
     * @return list of players
     */
    List<? extends IPlayerWW> getLastMinutesDamagedPlayer();

    /**
     * Get Player Name
     *
     * @return his name
     */
    String getName();

    /**
     * Get Player State
     *
     * @return the player's state
     */
    StatePlayer getState();

    /**
     * Change Player State
     *
     * @param statePlayer the state set
     */
    void setState(StatePlayer statePlayer);

    /**
     * Get Disconnected Time (Timer time)
     *
     * @return the disconnected time
     */
    int getDisconnectedTime();

    /**
     * Get Player UUID (note is not the Mojang UUID if he was on bungee)
     *
     * @return the uuid
     */
    UUID getUUID();

    /**
     * Give Item to player
     *
     * @param item the item give
     */
    void addItem(ItemStack item);

    /**
     * Get Player Max Health
     *
     * @return max health
     */
    double getMaxHealth();


    /**
     * Get Player Health
     *
     * @return health
     */
    double getHealth();

    /**
     * Get Player Position or if he's disconnected his last position
     *
     * @return the location
     */
    @NotNull
    Location getLocation();

    @NotNull
    Location getEyeLocation();

    /**
     * Get Player Wish
     */
    Optional<String> getWish();

    /**
     * Set Player Wish
     */
    void setWish(String wish);

    Location getDeathLocation();

    void setDeathLocation(Location location);

    List<? extends String> getDeathRoles();

    void addDeathRole(String role);

    void removeDeathRole(String role);

    String getDeathRole();

    ChatColor getColor(IPlayerWW playerWW);

    void setColor(IPlayerWW playerWW, ChatColor chatColor);

    Set<IPlayerWW> getPlayersMet();

    void addMetPlayer(IPlayerWW playerWW);

    void removeMetPlayer(IPlayerWW playerWW);

    void second();
}

