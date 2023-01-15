package fr.ph1lou.werewolfapi.game;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;

public interface IMapManager {

    /**
     * teleport the player around the world
     *
     * @param playerWW uuid of the player
     * @param d        angle in radian
     */

    void transportation(IPlayerWW playerWW, double d);

    /**
     * delete the game map
     */

    void deleteMap();

    /**
     * Generate the map of the concerned game
     *
     * @param mapRadius radius of the map to be generated
     */

    void generateMap(int mapRadius);

    void createMap();

    World getWorld();

    void loadMap(@Nullable File map);

    void loadMap() throws IOException;

    void changeBorder(int mapRadius);

    double getPercentageGenerated();
}
