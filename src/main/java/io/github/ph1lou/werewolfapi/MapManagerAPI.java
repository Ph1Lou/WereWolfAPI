package io.github.ph1lou.werewolfapi;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;

public interface MapManagerAPI {

    /**
     * teleport the player around the world
     * @param playerWW uuid of the player
     * @param d angle in radian
     * @param message teleport message
     */

    void transportation(PlayerWW playerWW, double d, String message);

    /**
     * delete the game map
     */

    void deleteMap();
    /**
     * Generate the map of the concerned game
     * @param mapRadius radius of the map to be generated
     */

    void generateMap(int mapRadius);

    void generateMap(CommandSender sender, int mapRadius);

    void createMap();

    World getWorld();

    void loadMap(@Nullable File map) throws IOException;

    void loadMap() throws IOException;

    void changeBorder(int mapRadius);

    double getPercentageGenerated();
}
