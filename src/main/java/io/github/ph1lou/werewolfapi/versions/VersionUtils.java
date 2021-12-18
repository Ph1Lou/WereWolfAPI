package io.github.ph1lou.werewolfapi.versions;

import io.github.ph1lou.werewolfapi.enums.UniversalMaterial;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public abstract class VersionUtils {

    private static VersionUtils versionUtils = null;

    public static VersionUtils getVersionUtils() {
        if (versionUtils == null) {
            int version = UniversalMaterial.loadServerVersion();
            if (version == 8) {
                versionUtils = new VersionUtils_1_8();
            } else if (version == 9) {
                versionUtils = new VersionUtils_1_9();
            } else if (version == 10) {
                versionUtils = new VersionUtils_1_10();
            } else if (version == 11) {
                versionUtils = new VersionUtils_1_11();
            } else if (version == 12) {
                versionUtils = new VersionUtils_1_12();
            } else if (version == 13) {
                versionUtils = new VersionUtils_1_13();
            } else if (version == 14) {
                versionUtils = new VersionUtils_1_14();
            } else if (version >= 15) {
                versionUtils = new VersionUtils_1_15();
            }
        }
        return versionUtils;
    }

    public abstract void setSkullOwner(SkullMeta skull, OfflinePlayer player, String name);

    public abstract void setPlayerMaxHealth(@NotNull Player player, double maxHealth);

    public abstract void addPlayerMaxHealth(@NotNull Player player, double health);

    public abstract void removePlayerMaxHealth(@NotNull Player player, double health);

    public abstract double getPlayerMaxHealth(@NotNull Player player);

    public abstract <T> void setGameRuleValue(World world, String gameRule, T value);

    public abstract void setTeamNameTagVisibility(Team team, boolean value);

    public abstract void setItemUnbreakable(ItemMeta meta, boolean b);

    public abstract void sendTitle(@NotNull Player player, String title, String subtitle, int fadeInTime, int showTime, int fadeOutTime);

    public abstract void sendActionBar(@NotNull Player player, String message);

    public abstract void sendTabTitle(@NotNull Player player, @NotNull String header, @NotNull String footer);

    public abstract Location findBiome(World world) throws Exception;

    public abstract int biomeSize(Location location, World world);

    public abstract ShapedRecipe registerCraft(ItemStack result, String key);

    public abstract ItemStack getItemInHand(@NotNull Player player);

    public abstract void setItemInHand(@NotNull Player player, ItemStack itemStack);

    public abstract ItemStack getPotionItem(short id);

    public abstract short generatePotionId(ItemStack itemStack);

    public abstract Collection<PotionEffect> getPotionEffect(@NotNull ItemStack itemStack);

    /**
     * Hide a player in tab and in game for a player
     * @param viewer the player
     * @param player the player hides
     */
    public abstract void hidePlayer(Player viewer, Player player);

    /**
     * Show a player in tab and in game for a player
     * @param viewer the player
     * @param player the player shows
     */
    public abstract void showPlayer(Player viewer, Player player);


}

