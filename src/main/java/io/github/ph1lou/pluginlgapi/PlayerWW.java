package io.github.ph1lou.pluginlgapi;


import io.github.ph1lou.pluginlgapi.enumlg.State;
import io.github.ph1lou.pluginlgapi.rolesattributs.Roles;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;

import java.util.List;
import java.util.UUID;

/**
 * @author Ph1Lou
 */

public interface PlayerWW {

    void setItemDeath(ItemStack[] itemsDeath) ;


    List<ItemStack> getItemDeath();


    void clearItemDeath();


    void setState(State state) ;


    boolean isState(State state);


    void addOneKill() ;


    int getNbKill();


    void addKLostHeart(int k);


    int getLostHeart() ;


    void setKit(Boolean kit) ;


    Boolean hasKit() ;


    void setRole(Roles role);


    Roles getRole();


    Boolean isRole(Roles role);


    void setSpawn(Location spawn);


    Location getSpawn();


    void setDamn(Boolean damn);


    Boolean hasDamn();


    void setSalvation(Boolean salvation);


    Boolean hasSalvation();


    void addLover(UUID uuid) ;


    void clearLovers();


    List<UUID> getLovers();


    void addKiller(UUID killerUUID);


    List<UUID> getKillers();


    void setDeathTime(Integer deathTime);


    int getDeathTime();


    void setCanBeInfect(Boolean b);


    Boolean canBeInfect();


    void clearLostHeart() ;


    void removeLover(UUID uuid);


    UUID getCursedLovers();


    void setCursedLover(UUID uuid);


    Boolean getAnnounceCursedLoversAFK();


    void setAnnounceCursedLoversAFK(Boolean announceCursedLoversAFK);


    Boolean getAnnounceLoversAFK() ;


    void setAnnounceLoversAFK(Boolean announceLoversAFK);


    UUID getLastKiller();


    void setThief(Boolean thief) ;


    Boolean isThief();


    UUID getAmnesiacLoverUUID();


    void setAmnesiacLoverUUID(UUID uuid) ;


    String getName() ;


    void setName(String name) ;


    Boolean getRevealAmnesiacLover() ;


    void setRevealAmnesiacLover(Boolean revealAmnesiacLover);

    Scoreboard getScoreBoard();

    void setScoreBoard(Scoreboard board);
}

