package fr.ph1lou.werewolfapi.buildings;

import fr.ph1lou.werewolfapi.enums.UniversalMaterial;
import fr.ph1lou.werewolfapi.versions.VersionUtils;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.HashMap;
import java.util.Map;

public class StructurePaster {

    private final Map<String, Material> materialCache = new HashMap<>();

    public void paste(BuildingDefinition definition, World world, int baseX, int baseY, int baseZ, DyeColor bannerColor) {
        loadChunks(world, baseX, baseZ, definition.getWidth(), definition.getLength());

        BlockStateDef[][][] blocks = definition.getBlocks();
        for (int y = 0; y < definition.getHeight(); y++) {
            for (int x = 0; x < definition.getWidth(); x++) {
                for (int z = 0; z < definition.getLength(); z++) {
                    BlockStateDef def = blocks[y][x][z];
                    if (def == null) {
                        continue;
                    }
                    Material material = resolveMaterial(def.getMaterial());
                    if (material == null) {
                        continue;
                    }
                    Block block = world.getBlockAt(baseX + x, baseY + y, baseZ + z);
                    VersionUtils.getVersionUtils().setBlock(block, material, def.getStates());
                }
            }
        }

        if (definition.hasFunctional("banner")) {
            int[] c = definition.getFunctional("banner");
            VersionUtils.getVersionUtils().placeColoredBanner(
                    world.getBlockAt(baseX + c[0], baseY + c[1], baseZ + c[2]), bannerColor);
        }

        placeFunctionalBlock(definition, "urn", "JUKEBOX", world, baseX, baseY, baseZ);
        placeFunctionalBlock(definition, "plate1", "STONE_PRESSURE_PLATE", world, baseX, baseY, baseZ);
        placeFunctionalBlock(definition, "plate2", "STONE_PRESSURE_PLATE", world, baseX, baseY, baseZ);
        placeFunctionalBlock(definition, "glass", "GLASS", world, baseX, baseY, baseZ);
    }

    private void loadChunks(World world, int baseX, int baseZ, int width, int length) {
        int minChunkX = (baseX) >> 4;
        int maxChunkX = (baseX + width) >> 4;
        int minChunkZ = (baseZ) >> 4;
        int maxChunkZ = (baseZ + length) >> 4;
        for (int cx = minChunkX; cx <= maxChunkX; cx++) {
            for (int cz = minChunkZ; cz <= maxChunkZ; cz++) {
                world.getChunkAt(cx, cz).load(true);
            }
        }
    }

    public Material resolveMaterial(String name) {
        if (name == null || name.isEmpty() || name.equalsIgnoreCase("AIR")) {
            return Material.AIR;
        }
        return materialCache.computeIfAbsent(name, n -> {
            try {
                return UniversalMaterial.valueOf(n).getType();
            } catch (IllegalArgumentException ignored) {
                Material m = Material.matchMaterial(n);
                if (m == null) {
                    m = matchLegacy(n);
                }
                return m;
            }
        });
    }

    private Material matchLegacy(String name) {
        switch (name) {
            case "OAK_PLANKS":
                return Material.matchMaterial("WOOD");
            case "STONE_BRICKS":
                return Material.matchMaterial("SMOOTH_BRICK");
            case "OAK_SLAB":
                return Material.matchMaterial("STEP");
            case "STONE_PRESSURE_PLATE":
                return Material.matchMaterial("STONE_PLATE");
            case "OAK_PRESSURE_PLATE":
                return Material.matchMaterial("WOOD_PLATE");
            case "WHITE_STAINED_GLASS":
                return Material.matchMaterial("STAINED_GLASS");
            case "LANTERN":
                return Material.matchMaterial("TORCH");
            case "STONE_BRICK_STAIRS":
                return Material.matchMaterial("SMOOTH_STAIRS");
            case "OAK_STAIRS":
                return Material.matchMaterial("WOOD_STAIRS");
            case "OAK_DOOR":
                return Material.matchMaterial("WOODEN_DOOR");
            case "OAK_TRAPDOOR":
                return Material.matchMaterial("TRAPDOOR");
            case "OAK_FENCE":
                return Material.matchMaterial("FENCE");
            case "WALL_TORCH":
                return Material.matchMaterial("TORCH");
            case "COBWEB":
                return Material.matchMaterial("WEB");
            case "WHITE_CARPET":
                return Material.matchMaterial("CARPET");
            case "BRICKS":
                return Material.matchMaterial("BRICK");
            case "SPRUCE_STAIRS":
                return Material.matchMaterial("SPRUCE_WOOD_STAIRS");
            case "BIRCH_STAIRS":
                return Material.matchMaterial("BIRCH_WOOD_STAIRS");
            case "JUNGLE_STAIRS":
                return Material.matchMaterial("JUNGLE_WOOD_STAIRS");
            default:
                return null;
        }
    }

    private void placeFunctionalBlock(BuildingDefinition definition, String key, String materialName,
                                      World world, int baseX, int baseY, int baseZ) {
        if (!definition.hasFunctional(key)) {
            return;
        }
        int[] c = definition.getFunctional(key);
        Material material = resolveMaterial(materialName);
        if (material == null) {
            return;
        }
        world.getBlockAt(baseX + c[0], baseY + c[1], baseZ + c[2]).setType(material, false);
    }

    public Location functionalLocation(BuildingDefinition definition, String name, World world, int baseX, int baseY, int baseZ) {
        if (!definition.hasFunctional(name)) {
            return null;
        }
        int[] c = definition.getFunctional(name);
        return new Location(world, baseX + c[0], baseY + c[1], baseZ + c[2]);
    }
}
