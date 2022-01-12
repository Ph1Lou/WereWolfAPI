package fr.ph1lou.werewolfapi.events.roles.fruitmerchant;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

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
}