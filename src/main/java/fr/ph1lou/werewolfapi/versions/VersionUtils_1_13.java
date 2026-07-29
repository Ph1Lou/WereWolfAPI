package fr.ph1lou.werewolfapi.versions;


import fr.ph1lou.werewolfapi.GetWereWolfAPI;
import org.bukkit.Axis;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Orientable;
import org.bukkit.block.data.type.Slab;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.util.Map;

public class VersionUtils_1_13 extends VersionUtils_1_12 {


    @Override
    public void setSkullOwner(SkullMeta skull, OfflinePlayer player, String name) {
        if (skull != null) {
            try {
                skull.setOwningPlayer(player);
            } catch (Exception e) {
                skull.setOwner(name);
            }
        }
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public <T> void setGameRuleValue(World world, String name, T value) {
        GameRule<T> gameRule = (GameRule<T>) GameRule.getByName(name);

        if (gameRule == null) return;
        world.setGameRule(gameRule, value);
    }

    @Override
    public void hidePlayer(Player viewer, Player player) {
        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if (api == null) {
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        viewer.hidePlayer((Plugin) api, player);
    }

    @Override
    public void showPlayer(Player viewer, Player player) {
        GetWereWolfAPI api = Bukkit.getServer().getServicesManager().load(GetWereWolfAPI.class);
        if (api == null) {
            throw new RuntimeException("WereWolfPlugin not loaded");
        }
        viewer.showPlayer((Plugin) api, player);
    }

    @Override
    public void spawnColoredParticle(Player player, Location location, Color color) {
        Particle particle;
        try {
            particle = (Particle) Particle.class.getField("REDSTONE").get(null);
        } catch (ReflectiveOperationException e) {
            try {
                particle = (Particle) Particle.class.getField("DUST").get(null);
            } catch (ReflectiveOperationException ex) {
                return;
            }
        }
        player.spawnParticle(particle, location, 6, new Particle.DustOptions(color, 1.5f));
    }

    @Override
    public void setBlock(Block block, Material material, Map<String, String> states) {
        if (states == null || states.isEmpty()) {
            block.setType(material, false);
            return;
        }
        try {
            BlockData data = material.createBlockData();
            String facing = states.get("facing");
            if (facing != null && data instanceof Directional) {
                try {
                    ((Directional) data).setFacing(BlockFace.valueOf(facing.toUpperCase()));
                } catch (IllegalArgumentException ignored) {
                }
            }
            String half = states.get("half");
            if (half != null) {
                String h = half.toUpperCase();
                if (data instanceof Stairs) {
                    ((Stairs) data).setHalf(Stairs.Half.valueOf(h));
                } else if (data instanceof Slab) {
                    ((Slab) data).setType(Slab.Type.valueOf(h));
                } else if (data instanceof Bisected) {
                    ((Bisected) data).setHalf(Bisected.Half.valueOf(h));
                }
            }
            String axis = states.get("axis");
            if (axis != null && data instanceof Orientable) {
                try {
                    ((Orientable) data).setAxis(Axis.valueOf(axis.toUpperCase()));
                } catch (IllegalArgumentException ignored) {
                }
            }
            block.setBlockData(data, false);
        } catch (Throwable t) {
            block.setType(material, false);
        }
    }
}

