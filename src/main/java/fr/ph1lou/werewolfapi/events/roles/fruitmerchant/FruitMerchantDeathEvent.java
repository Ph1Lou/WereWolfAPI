package fr.ph1lou.werewolfapi.events.roles.fruitmerchant;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInt;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


@StatisticsEvent(key = "werewolf.fruit_merchant_death")
public class FruitMerchantDeathEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final GoldenCount goldenAppleCount;

    public FruitMerchantDeathEvent(IPlayerWW playerWW, IPlayerWW playerWW1, GoldenCount goldenAppleCount) {
        super(playerWW, playerWW1);
        this.goldenAppleCount = goldenAppleCount;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public GoldenCount getGoldenAppleCount() {
        return goldenAppleCount;
    }

    @StatisticsExtraInfo
    public String getExtraInfo(){
        return String.valueOf(getGoldenAppleCount().getOldCount());
    }

    @StatisticsExtraInt
    public int getExtraInt(){
        return getGoldenAppleCount().getNewCount();
    }
}