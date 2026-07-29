package fr.ph1lou.werewolfapi.versions;


import fr.ph1lou.werewolfapi.GetWereWolfAPI;
import fr.ph1lou.werewolfapi.utils.NMSUtils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings({ "deprecation" })
public class VersionUtils_1_8 extends VersionUtils {

    @Override
    public void setSkullOwner(SkullMeta skull, OfflinePlayer player, String name) {
        if (name != null) {
            skull.setOwner(name);
        }
    }

    @Override
    public void setPlayerMaxHealth(@NotNull Player player, double maxHealth) {
        player.setMaxHealth(maxHealth);
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
    public double getPlayerMaxHealth(@NotNull Player player) {
        return player.getMaxHealth();
    }

    @Override
    public <T> void setGameRuleValue(World world, String gameRule, T value) {
        world.setGameRuleValue(gameRule, value.toString());
    }

    @Override
    public void setTeamNameTagVisibility(Team team, boolean value) {
        team.setNameTagVisibility(value ? NameTagVisibility.ALWAYS : NameTagVisibility.NEVER);
    }

    @Override
    public Collection<PotionEffect> getPotionEffect(@NotNull ItemStack itemStack) {
        try {

            Object potion = Class.forName("org.bukkit.potion.Potion").getMethod("fromItemStack")
                    .invoke(null, itemStack);

            return (Collection<PotionEffect>) potion.getClass().getMethod("getEffects").invoke(potion);
        } catch (Exception ignored) {
        }
        return Collections.emptyList();
    }

    @Override
    public void hidePlayer(Player viewer, Player player) {
        viewer.hidePlayer(player);
    }

    @Override
    public void showPlayer(Player viewer, Player player) {
        viewer.showPlayer(player);
    }

    @Override
    public void setChunkForceLoaded(World world, int x, int z, boolean generation) {
        world.loadChunk(x, z, generation);
    }

    @Override
    public TextComponent createClickableText(String text, String command, ClickEvent.Action action, @Nullable String hover) {
        TextComponent textComponent = new TextComponent(text);
        textComponent.setClickEvent(new ClickEvent(action, command));
        if (hover != null) {
            textComponent.setHoverEvent(
                    new HoverEvent(
                            HoverEvent.Action.SHOW_TEXT,
                            new ComponentBuilder(hover)
                                    .create()));
        }
        return textComponent;
    }

    @Override
    public TextComponent createClickableText(String text, String command, ClickEvent.Action action) {
        return this.createClickableText(text, command, action, null);
    }

    @Override
    public void setItemInHand(@NotNull Player player, ItemStack itemStack) {
        player.setItemInHand(itemStack);
    }

    @Override
    public void setItemUnbreakable(ItemMeta meta, boolean b) {


        try {
            Method spigot = NMSUtils.getMethod(meta.getClass(), "spigot");
            Object spigotInstance = spigot.invoke(meta);
            Method setUnbreakable = NMSUtils.getMethod(spigotInstance.getClass(), "setUnbreakable", boolean.class);
            setUnbreakable.invoke(spigotInstance, b);
        } catch (ReflectiveOperationException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void sendTitle(@NotNull Player player, String title, String subtitle, int fadeInTime, int showTime, int fadeOutTime) {
        try {
            Object chatTitle = NMSUtils.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class)
                    .invoke(null, "{\"text\": \"" + title + "\"}");
            Constructor<?> titleConstructor = NMSUtils.getNMSClass("PacketPlayOutTitle").getConstructor(
                    NMSUtils.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], NMSUtils.getNMSClass("IChatBaseComponent"),
                    int.class, int.class, int.class);
            Object packet = titleConstructor.newInstance(
                    NMSUtils.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null), chatTitle,
                    fadeInTime, showTime, fadeOutTime);

            Object chatsTitle = NMSUtils.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class)
                    .invoke(null, "{\"text\": \"" + subtitle + "\"}");
            Constructor<?> timingTitleConstructor = NMSUtils.getNMSClass("PacketPlayOutTitle").getConstructor(
                    NMSUtils.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], NMSUtils.getNMSClass("IChatBaseComponent"),
                    int.class, int.class, int.class);
            Object timingPacket = timingTitleConstructor.newInstance(
                    NMSUtils.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null), chatsTitle,
                    fadeInTime, showTime, fadeOutTime);

            NMSUtils.sendPacket(player, packet);
            NMSUtils.sendPacket(player, timingPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void sendActionBar(@NotNull Player player, String message) {

        try {
            Class<?> craftPlayerClass = NMSUtils.getNMSClass("entity.CraftPlayer");
            Object craftPlayer = craftPlayerClass.cast(player);
            Object packet;
            Class<?> packetPlayOutChatClass = NMSUtils.getNMSClass("PacketPlayOutChat");
            Class<?> packetClass = NMSUtils.getNMSClass("Packet");
            if (Bukkit.getServer().getClass().getPackage().getName().equals("v1_8_R1")) {
                Class<?> chatSerializerClass = NMSUtils.getNMSClass("ChatSerializer");
                Class<?> iChatBaseComponentClass = NMSUtils.getNMSClass("IChatBaseComponent");
                Method m3 = chatSerializerClass.getDeclaredMethod("a", String.class);
                Object cbc = iChatBaseComponentClass.cast(m3.invoke(chatSerializerClass, "{\"text\": \"" + message + "\"}"));
                packet = packetPlayOutChatClass.getConstructor(new Class<?>[] { iChatBaseComponentClass, byte.class }).newInstance(cbc, (byte) 2);
            } else {
                Class<?> chatComponentTextClass = NMSUtils.getNMSClass("ChatComponentText");
                Class<?> iChatBaseComponentClass = NMSUtils.getNMSClass("IChatBaseComponent");
                try {
                    Class<?> chatMessageTypeClass = NMSUtils.getNMSClass("ChatMessageType");
                    Object[] chatMessageTypes = chatMessageTypeClass.getEnumConstants();
                    Object chatMessageType = null;
                    for (Object obj : chatMessageTypes) {
                        if (obj.toString().equals("GAME_INFO")) {
                            chatMessageType = obj;
                        }
                    }
                    Object chatCompontentText = chatComponentTextClass.getConstructor(new Class<?>[] { String.class }).newInstance(message);
                    packet = packetPlayOutChatClass.getConstructor(new Class<?>[] { iChatBaseComponentClass, chatMessageTypeClass }).newInstance(chatCompontentText, chatMessageType);
                } catch (ClassNotFoundException cnfe) {
                    Object chatCompontentText = chatComponentTextClass.getConstructor(new Class<?>[] { String.class }).newInstance(message);
                    packet = packetPlayOutChatClass.getConstructor(new Class<?>[] { iChatBaseComponentClass, byte.class }).newInstance(chatCompontentText, (byte) 2);
                }
            }
            Method craftPlayerHandleMethod = craftPlayerClass.getDeclaredMethod("getHandle");
            Object craftPlayerHandle = craftPlayerHandleMethod.invoke(craftPlayer);
            Field playerConnectionField = craftPlayerHandle.getClass().getDeclaredField("playerConnection");
            Object playerConnection = playerConnectionField.get(craftPlayerHandle);
            Method sendPacketMethod = playerConnection.getClass().getDeclaredMethod("sendPacket", packetClass);
            sendPacketMethod.invoke(playerConnection, packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendTabTitle(@NotNull Player player, @NotNull String header, @NotNull String footer) {


        header = ChatColor.translateAlternateColorCodes('&', header);
        footer = ChatColor.translateAlternateColorCodes('&', footer);
        if (!footer.contains(VersionUtils.CREATOR) && !header.contains(VersionUtils.CREATOR)) {
            footer += "\n§7Plugin made by §bPh1Lou";
        }

        header = header.replaceAll("%player%", player.getDisplayName());
        footer = footer.replaceAll("%player%", player.getDisplayName());
        try {
            Object tabHeader = NMSUtils.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + header + "\"}");
            Object tabFooter = NMSUtils.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + footer + "\"}");
            Constructor<?> titleConstructor = NMSUtils.getNMSClass("PacketPlayOutPlayerListHeaderFooter").getConstructor();
            Object packet = titleConstructor.newInstance();
            try {
                Field aField = packet.getClass().getDeclaredField("a");
                aField.setAccessible(true);
                aField.set(packet, tabHeader);
                Field bField = packet.getClass().getDeclaredField("b");
                bField.setAccessible(true);
                bField.set(packet, tabFooter);
            } catch (Exception e) {
                Field aField2 = packet.getClass().getDeclaredField("header");
                aField2.setAccessible(true);
                aField2.set(packet, tabHeader);
                Field bField2 = packet.getClass().getDeclaredField("footer");
                bField2.setAccessible(true);
                bField2.set(packet, tabFooter);
            }
            NMSUtils.sendPacket(player, packet);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


    @Override
    public CompletableFuture<Location> findBiome(World world) {

        CompletableFuture<Location> completableFuture = new CompletableFuture<>();

        GetWereWolfAPI getWereWolfAPI = Bukkit.getServicesManager().load(GetWereWolfAPI.class);

        if (getWereWolfAPI != null) {

            Bukkit.getScheduler().runTaskAsynchronously((Plugin) getWereWolfAPI, () -> {

                for (int i = -2000; i < 2000; i += 16) {
                    for (int j = -2000; j < 2000; j += 16) {
                        try {
                            if (World.class.getMethod("getBiome", int.class, int.class).invoke(world, i, j) ==
                                Biome.class.getMethod("valueOf", String.class).invoke(null, "ROOFED_FOREST")) {
                                completableFuture.complete(new Location(world, i, 151, j));
                                return;
                            }
                        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                Bukkit.getLogger().warning("Roofed not found");
                completableFuture.complete(world.getSpawnLocation());
            });
        }
        return completableFuture;
    }

    @Override
    public int biomeSize(Location location, World world) {

        int i = 0;
        Biome biome = world.getBiome(location.getBlockX(), location.getBlockZ());
        List<Location> locations = new ArrayList<>();
        List<Location> finalLocations = new ArrayList<>();
        locations.add(location);

        while (!locations.equals(finalLocations)) {

            Location location1 = locations.get(i);
            int x = location1.getBlockX();
            int z = location1.getBlockZ();

            for (int x1 = -1; x1 < 2; x1 += 2) {

                for (int z1 = -1; z1 < 2; z1 += 2) {

                    if (world.getBiome(x1 + x, z1 + z) == biome) {
                        Location location2 = new Location(world, x1 + x, 0, z1 + z);
                        if (!finalLocations.contains(location2) && !locations.contains(location2)) {
                            locations.add(location2);
                        }
                    }
                }
            }
            finalLocations.add(location1);
            i++;
            if (i > 30000) {
                return 33333;
            }
        }

        return i;
    }

    @Override
    public ShapedRecipe registerCraft(ItemStack result, String key) {
        return new ShapedRecipe(result);
    }


    @Override
    public ItemStack getItemInHand(@NotNull Player player) {
        return player.getItemInHand();
    }

    @Override
    public ItemStack getPotionItem(short id) {
        return new ItemStack(Material.POTION, 1, id);
    }

    @Override
    public short generatePotionId(ItemStack itemStack) {
        return itemStack.getDurability();
    }

    @Override
    public void setPrefixAndColor(Team team, String prefix, ChatColor chatColor) {
        prefix += chatColor;
        team.setPrefix(prefix.substring(Math.max(prefix.length() - 16, 0)));
    }

    @Override
    public void addPlayerAbsorptionHealth(Player player, double health) {
        try {
            Object entityPlayer = player.getClass().getMethod("getHandle").invoke(player);
            entityPlayer.getClass().getMethod("setAbsorptionHearts", float.class).invoke(entityPlayer, (float) health);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void spawnColoredParticle(Player player, Location location, Color color) {
        try {
            Class<?> enumParticle = NMSUtils.getNMSClass("EnumParticle");
            Object particle = enumParticle.getField("SPELL_MOB").get(null);
            Class<?> packetClass = NMSUtils.getNMSClass("PacketPlayOutWorldParticles");
            Constructor<?> ctor = packetClass.getConstructor(
                    enumParticle, boolean.class,
                    float.class, float.class, float.class,
                    float.class, float.class, float.class,
                    float.class, int.class, int[].class);
            float r = color.getRed() / 255f;
            float g = color.getGreen() / 255f;
            float b = color.getBlue() / 255f;
            Object packet = ctor.newInstance(
                    particle, true,
                    (float) location.getX(), (float) location.getY(), (float) location.getZ(),
                    r, g, b, 1f, 0, new int[0]);
            NMSUtils.sendPacket(player, packet);
        } catch (Throwable ignored) {
        }
    }

    @Override
    public void setBlock(Block block, Material material, Map<String, String> states) {
        block.setType(material, false);
        if (states == null || states.isEmpty()) {
            return;
        }
        String name = material.name();
        if (name.contains("TRAPDOOR")) {
            byte data = 0;
            String f = states.get("facing");
            if (f != null) {
                switch (f.toUpperCase()) {
                    case "NORTH":
                        data = 0;
                        break;
                    case "SOUTH":
                        data = 1;
                        break;
                    case "WEST":
                        data = 2;
                        break;
                    case "EAST":
                        data = 3;
                        break;
                    default:
                        break;
                }
            }
            if ("TRUE".equalsIgnoreCase(states.get("open"))) {
                data |= 4;
            }
            if ("TOP".equalsIgnoreCase(states.get("half"))) {
                data |= 8;
            }
            setData(block, data);
            return;
        }
        if (name.equals("TORCH")) {
            byte data;
            String f = states.get("facing");
            if (f == null) {
                data = 5;
            } else {
                switch (f.toUpperCase()) {
                    case "EAST":
                        data = 1;
                        break;
                    case "WEST":
                        data = 2;
                        break;
                    case "SOUTH":
                        data = 3;
                        break;
                    case "NORTH":
                        data = 4;
                        break;
                    default:
                        data = 5;
                        break;
                }
            }
            setData(block, data);
            return;
        }
        if (name.contains("DOOR")) {
            byte data = 0;
            if ("UPPER".equalsIgnoreCase(states.get("half"))) {
                data = 8;
                if ("RIGHT".equalsIgnoreCase(states.get("hinge"))) {
                    data |= 1;
                }
            } else {
                String f = states.get("facing");
                if (f != null) {
                    switch (f.toUpperCase()) {
                        case "EAST":
                            data = 0;
                            break;
                        case "SOUTH":
                            data = 1;
                            break;
                        case "WEST":
                            data = 2;
                            break;
                        case "NORTH":
                            data = 3;
                            break;
                        default:
                            break;
                    }
                }
            }
            setData(block, data);
            return;
        }
        if (!name.contains("STAIRS")) {
            return;
        }
        byte data = 0;
        String facing = states.get("facing");
        if (facing != null) {
            switch (facing.toUpperCase()) {
                case "EAST":
                    data = 0;
                    break;
                case "WEST":
                    data = 1;
                    break;
                case "SOUTH":
                    data = 2;
                    break;
                case "NORTH":
                    data = 3;
                    break;
                default:
                    break;
            }
        }
        if ("TOP".equalsIgnoreCase(states.get("half"))) {
            data |= 4;
        }
        setData(block, data);
    }

    private void setData(Block block, byte data) {
        try {
            Block.class.getMethod("setData", byte.class).invoke(block, data);
        } catch (Throwable ignored) {
        }
    }
}
