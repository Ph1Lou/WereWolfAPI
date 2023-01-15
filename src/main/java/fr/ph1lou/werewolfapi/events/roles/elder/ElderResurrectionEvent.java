package fr.ph1lou.werewolfapi.events.roles.elder;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.events.game.life_cycle.ResurrectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.elder_revive")
public class ElderResurrectionEvent extends ResurrectionEvent {


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private boolean killerIsVillager;

    public ElderResurrectionEvent(IPlayerWW playerWW, boolean killerIsVillager) {
        super(playerWW);
        this.killerIsVillager = killerIsVillager;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public boolean isKillerAVillager() {
        return killerIsVillager;
    }

    public void setKillerAVillager(boolean killerIsVillager) {
        this.killerIsVillager = killerIsVillager;
    }

    @StatisticsExtraInfo
    public String getExtraInfo() {
        return this.isKillerAVillager() ? "werewolf.elder_kill_by_villager" :
                "werewolf.elder_not_kill_by_villager";
    }

}