package fr.ph1lou.werewolfapi.events.roles.villager;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.villager_kit")
public class VillagerKitEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private final String kit;

    public VillagerKitEvent(IPlayerWW playerWW, String kit) {
        this.playerWW = playerWW;
        this.kit = kit;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @StatisticsPlayer
    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    @StatisticsExtraInfo
    public String getKit() {
        return kit;
    }
}

