package fr.ph1lou.werewolfapi.versions;


import fr.ph1lou.werewolfapi.GetWereWolfAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class VersionUtils_1_15 extends VersionUtils_1_14 {

    @Override
    public CompletableFuture<Location> findBiome(World world) {

        CompletableFuture<Location> completableFuture = new CompletableFuture<>();

        GetWereWolfAPI getWereWolfAPI = Bukkit.getServicesManager().load(GetWereWolfAPI.class);

        if (getWereWolfAPI != null) {
            Bukkit.getScheduler().runTaskAsynchronously((Plugin) getWereWolfAPI, () -> {
                for (int i = -2000; i < 2000; i += 16) {
                    for (int j = -2000; j < 2000; j += 16) {
                        if (world.getBiome(i, 100, j) == Biome.DARK_FOREST) {
                            completableFuture.complete(new Location(world, i, 151, j));
                            return;
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
        Biome biome = world.getBiome(location.getBlockX(), 20, location.getBlockZ());
        List<Location> locations = new ArrayList<>();
        List<Location> finalLocations = new ArrayList<>();
        locations.add(location);

        while (!locations.equals(finalLocations)) {

            Location location1 = locations.get(i);
            int x = location1.getBlockX();
            int z = location1.getBlockZ();

            for (int x1 = -1; x1 < 2; x1 += 2) {

                for (int z1 = -1; z1 < 2; z1 += 2) {

                    if (world.getBiome(x1 + x, 20, z1 + z) == biome) {
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
    public void addPlayerAbsorptionHealth(Player player, double health) {
        player.setAbsorptionAmount(health);
    }
}

