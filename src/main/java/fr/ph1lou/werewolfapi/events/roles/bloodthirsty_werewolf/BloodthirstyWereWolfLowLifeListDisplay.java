package fr.ph1lou.werewolfapi.events.roles.bloodthirsty_werewolf;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BloodthirstyWereWolfLowLifeListDisplay extends Event {
    public static HandlerList HANDLERS_LIST = new HandlerList();

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList(){
        return HANDLERS_LIST;
    }

    private final IPlayerWW playerWW;
    private final Set<IPlayerWW> playersWW;

    public BloodthirstyWereWolfLowLifeListDisplay(IPlayerWW playerWW, Set<IPlayerWW> playersWW){
        this.playerWW = playerWW;
        this.playersWW = playersWW;
    }

    public IPlayerWW getPlayerWW(){
        return this.playerWW;
    }

    public Set<IPlayerWW> getPlayersWWSet(){
        return this.playersWW;
    }
}
