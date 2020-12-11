package io.github.ph1lou.werewolfapi.versions;


import io.github.ph1lou.werewolfapi.enums.UniversalMaterial;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

public abstract class VersionUtils {

    private static VersionUtils versionUtils = null;

    public static VersionUtils getVersionUtils() {
        if (versionUtils == null) {
            int version = UniversalMaterial.loadServerVersion();
            if (version < 12) {
                versionUtils = new VersionUtils_1_8();
            } else {
                versionUtils = new VersionUtils_1_13();
            }
        }
        return versionUtils;
    }

    public abstract void setSkullOwner(SkullMeta skull, OfflinePlayer player, String name);

    @Deprecated
    public abstract void setPlayerMaxHealth(@NotNull Player player, double maxHealth);

    public abstract void addPlayerMaxHealth(@NotNull Player player, double health);

    public abstract void removePlayerMaxHealth(@NotNull Player player, double health);

    @Deprecated
    public abstract double getPlayerMaxHealth(@NotNull Player player);

    public abstract void patchBiomes();

    public abstract void setGameRuleValue(World world, String gameRule, Object value);

    public abstract void setTeamNameTagVisibility(Team team, boolean value);

    public abstract void setItemUnbreakable(ItemMeta meta, boolean b);

    public abstract void sendTitle(@NotNull Player player, String title, String subtitle, int fadeInTime, int showTime, int fadeOutTime);

    public abstract void sendActionBar(@NotNull Player player, String message);

    public abstract void sendTabTitle(@NotNull Player player, @NotNull String header, @NotNull String footer);

    public abstract Location findBiome(World world) throws Exception;

    public abstract int biomeSize(Location location, World world);

    public abstract ItemStack getItemInHand(@NotNull Player player);
}

