package io.github.ph1lou.werewolfapi.events.roles.fruitmerchant;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class FruitMerchantDeathEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final int goldenAppleCount;

    public FruitMerchantDeathEvent(IPlayerWW playerWW, IPlayerWW playerWW1, int goldenAppleCount) {
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

    public int getGoldenAppleCount() {
        return goldenAppleCount;
    }
}