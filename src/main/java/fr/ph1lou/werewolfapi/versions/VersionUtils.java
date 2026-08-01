package fr.ph1lou.werewolfapi.versions;

import fr.ph1lou.werewolfapi.enums.UniversalMaterial;
import fr.ph1lou.werewolfapi.utils.BukkitUtils;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Banner;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class VersionUtils {

    protected static final CharSequence CREATOR = "Ph1Lou";
    private static VersionUtils versionUtils = null;

    public static VersionUtils getVersionUtils() {
        if (versionUtils == null) {
            int version = BukkitUtils.loadServerVersion();
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
            } else if (version == 15) {
                versionUtils = new VersionUtils_1_15();
            } else if (version == 16) {
                versionUtils = new VersionUtils_1_16();
            } else if (version == 20) {
                versionUtils = new VersionUtils_1_20();
            } else if (version >= 21) {
                versionUtils = new VersionUtils_1_21();
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

    public abstract CompletableFuture<Location> findBiome(World world);

    public abstract int biomeSize(Location location, World world);

    public abstract ShapedRecipe registerCraft(ItemStack result, String key);

    public abstract ItemStack getItemInHand(@NotNull Player player);

    public abstract void setItemInHand(@NotNull Player player, ItemStack itemStack);

    public abstract ItemStack getPotionItem(short id);

    public abstract short generatePotionId(ItemStack itemStack);

    public abstract Collection<PotionEffect> getPotionEffect(@NotNull ItemStack itemStack);

    public abstract void addPotionEffect(Player player, PotionEffectType type, int duration, int amplifier, boolean ambient, boolean particles, boolean icon);

    /**
     * Hide a player in tab and in game for a player
     *
     * @param viewer the player
     * @param player the player hides
     */
    public abstract void hidePlayer(Player viewer, Player player);

    /**
     * Show a player in tab and in game for a player
     *
     * @param viewer the player
     * @param player the player shows
     */
    public abstract void showPlayer(Player viewer, Player player);

    public abstract void setChunkForceLoaded(World world, int x, int z, boolean generation);

    public abstract TextComponent createClickableText(String text, String command, ClickEvent.Action action, @Nullable String hover);

    public abstract TextComponent createClickableText(String text, String command, ClickEvent.Action action);

    public abstract void setPrefixAndColor(Team team, String prefix, ChatColor chatColor);

    public abstract void addPlayerAbsorptionHealth(Player player, double health);

    public abstract void removePlayerAbsorptionHealth(Player player, double health);

    /**
     * Pose un bloc de laine colorée (cross-version).
     * 1.13+ : matériau coloré dédié. 1.8-1.12 : WOOL + data value.
     */
    public void setColoredWool(Block block, DyeColor color) {
        DyeColor base = color == null ? DyeColor.WHITE : color;
        Material modern = Material.matchMaterial(base.name() + "_WOOL");
        if (modern != null) {
            block.setType(modern, false);
            return;
        }
        Material wool = Material.matchMaterial("WOOL");
        if (wool == null) {
            return;
        }
        block.setType(wool, false);
        try {
            Block.class.getMethod("setData", byte.class).invoke(block, woolData(base));
        } catch (Throwable ignored) {
        }
    }

    /**
     * Pose une bannière colorée (cross-version). En cas d'échec, pose une laine colorée en secours.
     */
    public void placeColoredBanner(Block block, DyeColor color) {
        DyeColor base = color == null ? DyeColor.WHITE : color;
        Material banner = UniversalMaterial.WHITE_BANNER.getType();
        if (banner != null) {
            // applyPhysics=true pour forcer la création de la tile-entity Banner (notamment 1.8).
            block.setType(banner, true);
            try {
                BlockState state = block.getState();
                if (state instanceof Banner) {
                    ((Banner) state).setBaseColor(base);
                    state.update(true);
                    return;
                }
            } catch (Throwable ignored) {
            }
        }
        setColoredWool(block, base);
    }

    /**
     * Envoie une particule colorée à un joueur.
     * 1.8-1.12 : paquet NMS SPELL_MOB coloré. 1.13+ : spawnParticle + DustOptions.
     */
    public abstract void spawnColoredParticle(Player player, Location location, Color color);

    /**
     * Pose un bloc (avec orientation si states non vide).
     * 1.8-1.12 : setType + setData (byte legacy, escaliers). 1.13+ : setBlockData.
     */
    public abstract void setBlock(Block block, Material material, Map<String, String> states);

    public void sendEndMessage(@NotNull Player player, @NotNull String message,
                               @NotNull String playerName, @Nullable String hover) {
        int idx = message.indexOf(playerName);
        if (idx < 0) {
            player.sendMessage(message);
            return;
        }
        int afterIdx = idx + playerName.length();
        String beforeText = message.substring(0, idx);
        String afterText = afterIdx < message.length() ? message.substring(afterIdx) : "";
        String restoreCodes = extractActiveColorCodes(beforeText);

        TextComponent component = new TextComponent();
        if (!beforeText.isEmpty()) {
            component.addExtra(new TextComponent(beforeText));
        }
        TextComponent nameComponent = new TextComponent("§b§n" + playerName);
        if (hover != null && !hover.isEmpty()) {
            TextComponent hoverComponent = new TextComponent(hover);
            hoverComponent.setColor(net.md_5.bungee.api.ChatColor.WHITE);
            nameComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    new BaseComponent[]{hoverComponent}));
        }
        component.addExtra(nameComponent);
        if (!afterText.isEmpty()) {
            component.addExtra(new TextComponent("§r" + restoreCodes + afterText));
        }
        player.spigot().sendMessage(component);
    }

    protected static String extractActiveColorCodes(String text) {
        String color = "";
        StringBuilder formatting = new StringBuilder();
        int i = 0;
        while (i < text.length() - 1) {
            if (text.charAt(i) == '§') {
                char code = text.charAt(i + 1);
                if (code == 'r') {
                    color = "";
                    formatting.setLength(0);
                } else if ("0123456789abcdef".indexOf(code) >= 0) {
                    color = "§" + code;
                } else if ("klmno".indexOf(code) >= 0) {
                    String codeStr = "§" + code;
                    if (formatting.indexOf(codeStr) < 0) {
                        formatting.append(codeStr);
                    }
                }
                i += 2;
            } else {
                i++;
            }
        }
        return color + formatting.toString();
    }

    private static byte woolData(DyeColor color) {
        switch (color) {
            case ORANGE: return 1;
            case MAGENTA: return 2;
            case LIGHT_BLUE: return 3;
            case YELLOW: return 4;
            case LIME: return 5;
            case PINK: return 6;
            case GRAY: return 7;
            case LIGHT_GRAY: return 8;
            case CYAN: return 9;
            case PURPLE: return 10;
            case BLUE: return 11;
            case BROWN: return 12;
            case GREEN: return 13;
            case RED: return 14;
            case BLACK: return 15;
            default: return 0;
        }
    }
}

