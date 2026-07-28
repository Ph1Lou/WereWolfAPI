package fr.ph1lou.werewolfapi.events.roles.bohemian;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInt;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.bohemian_sacrifice")
public class BohemianSacrificeEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final int amount;

    public BohemianSacrificeEvent(IPlayerWW playerWW, IPlayerWW targetWW, int amount) {
        super(playerWW, targetWW);
        this.amount = amount;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @StatisticsExtraInt
    public int getAmount() {
        return amount;
    }
}
