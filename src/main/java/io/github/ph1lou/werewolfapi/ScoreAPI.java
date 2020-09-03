package io.github.ph1lou.werewolfapi;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface ScoreAPI {

    /**
     * return the time rearranged HH:MM:SS
     * @param timer time in second
     * @return String
     */

    String conversion(int timer);

    /**
     * return the arrow to reach the target location
     * @param player current player
     * @param target target location
     * @return String
     */

    String updateArrow(Player player, Location target);

    int getRole();

    void setRole(int role);

    void addTimer();

    int getPlayerSize();

    void removePlayerSize();

    void addPlayerSize();

    int getGroup();

    void setGroup(int group);

    void getKillCounter();

    void actionBar(Player player);



}
