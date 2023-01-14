package fr.ph1lou.werewolfapi.events.werewolf;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.new_werewolf")
public class NewWereWolfEvent extends Event {


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final IPlayerWW playerWW;

    public NewWereWolfEvent(IPlayerWW playerWW){
        this.playerWW = playerWW;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @StatisticsPlayer
    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

}