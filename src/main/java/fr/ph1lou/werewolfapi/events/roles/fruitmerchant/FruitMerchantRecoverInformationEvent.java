package fr.ph1lou.werewolfapi.events.roles.fruitmerchant;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTargets;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

@StatisticsEvent(key = "werewolf.fruit_merchant_recover")
public class FruitMerchantRecoverInformationEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private final Map<IPlayerWW, GoldenCount> goldenAppleCount;
    private boolean cancel = false;

    public FruitMerchantRecoverInformationEvent(IPlayerWW playerWW,
                                                Map<IPlayerWW, GoldenCount> goldenAppleCount) {
        this.playerWW = playerWW;
        this.goldenAppleCount = goldenAppleCount;
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

    @StatisticsTargets
    public Set<IPlayerWW> getPlayerWWS() {
        return this.goldenAppleCount.keySet();
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    public GoldenCount getGoldenAppleCount(IPlayerWW playerWW) {
        return goldenAppleCount.get(playerWW);
    }
}

