package fr.ph1lou.werewolfapi.buildings;

import org.bukkit.DyeColor;
import org.bukkit.Location;

import java.util.UUID;

public interface ISanctuary extends IBuilding {

    DyeColor getDyeColor();

    Location getCenter();

    boolean hasVisited(UUID player);

    void markVisited(UUID player);
}
