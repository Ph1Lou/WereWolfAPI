package fr.ph1lou.werewolfapi.buildings;

import org.bukkit.Location;
import org.bukkit.World;

public interface IBuilding {

    BuildingType getType();

    World getWorld();

    int getBaseX();

    int getBaseY();

    int getBaseZ();

    Location getBannerLocation();
}
