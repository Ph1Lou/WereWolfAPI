package fr.ph1lou.werewolfapi.utils;

import fr.ph1lou.werewolfapi.enums.Category;
import fr.ph1lou.werewolfapi.enums.StatePlayer;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.enums.UniversalMaterial;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Utils {

    public static int midDistance(Player player) {

        World world = player.getWorld();
        Location location = player.getLocation();
        location.setY(world.getSpawnLocation().getY());
        int distance = 0;

        try {
            distance = (int) location.distance(world.getSpawnLocation());
        } catch (Exception ignored) {
        }


        return distance / 300 * 300;
    }

    /**
     * return the arrow to reach the target location
     * @param player current player
     * @param target target location
     * @return String
     */

    public static String updateArrow(Player player, Location target) {

        Location location = player.getLocation();
        String arrow;
        location.setY(target.getY());
        Vector dirToMiddle = target.toVector().subtract(player.getEyeLocation().toVector()).normalize();

        int distance = 0;
        try {
            distance = (int) Math.round(target.distance(location));
        } catch (Exception ignored) {
        }

        Vector playerDirection = player.getEyeLocation().getDirection();
        double angle = dirToMiddle.angle(playerDirection);
        double det = dirToMiddle.getX() * playerDirection.getZ() - dirToMiddle.getZ() * playerDirection.getX();

        angle = angle * Math.signum(det);

        if (angle > -Math.PI / 8 && angle < Math.PI / 8) {
            arrow = "↑";
        } else if (angle > -3 * Math.PI / 8 && angle < -Math.PI / 8) {
            arrow = "↗";
        } else if (angle<3*Math.PI/8 && angle>Math.PI/8) {
            arrow = "↖";
        } else if (angle>3*Math.PI/8 && angle<5*Math.PI/8) {
            arrow="←";
        } else if (angle<-3*Math.PI/8 && angle>-5*Math.PI/8) {
            arrow = "→";
        } else if (angle<-5*Math.PI/8 && angle>-7*Math.PI/8) {
            arrow = "↘";
        } else if (angle > 5 * Math.PI / 8 && angle < 7 * Math.PI / 8) {
            arrow = "↙";
        } else arrow = "↓";

        return distance + " §l" + arrow;
    }

    /**
     * return the time rearranged HH:MM:SS
     * @param timer time in second
     * @return String
     */
    public static String conversion(int timer) {

        String value;
        float sign = Math.signum(timer);
        timer = Math.abs(timer);

        if (timer % 60 > 9) {
            value = timer % 60 + "s";
        } else value = "0" + timer % 60 + "s";

        if(timer/3600>0) {

            if(timer%3600/60>9) {
                value = timer / 3600 + "h" + timer % 3600 / 60 + "m" + value;
            } else value = timer / 3600 + "h0" + timer % 3600 / 60 + "m" + value;
        } else if (timer / 60 > 0) {
            value = timer / 60 + "m" + value;
        }
        if (sign < 0) value = "-" + value;

        return value;
    }

    /**
     * Retourne le nombre de pomme d'or du joueur
     */
    public static int countGoldenApple(IPlayerWW playerWW){
        Player player = Bukkit.getPlayer(playerWW.getUUID());

        if(player == null){
            return 0;
        }

        return Arrays.stream(player.getInventory()
                .getContents())
                .filter(Objects::nonNull)
                .filter(itemStack -> itemStack.getType() == UniversalMaterial.GOLDEN_APPLE.getType())
                .mapToInt(ItemStack::getAmount)
                .sum();
    }


    /**
     * Select a random Player who should be alive
     * @param wereWolfAPI the current game
     * @param playerWW the requester
     * @return a random player or the requester if no-player was found
     */
    public static IPlayerWW autoSelect(WereWolfAPI wereWolfAPI, IPlayerWW playerWW){

        List<IPlayerWW> players = wereWolfAPI.getPlayersWW()
                .stream()
                .filter(playerWW1 -> playerWW1.isState(StatePlayer.ALIVE))
                .filter(playerWW1 -> !playerWW1.equals(playerWW))
                .collect(Collectors.toList());

        if (players.isEmpty()) {
            return playerWW;
        }

        return players.get((int) Math.floor(wereWolfAPI.getRandom().nextFloat() * players.size()));
    }

    public static boolean compareDistance(WereWolfAPI wereWolfAPI, Location location1, Location location2, String distance){
        return location1.getWorld() == location2.getWorld() &&
                location1.distance(location2) < wereWolfAPI.getConfig().getValue(distance);
    }
}
