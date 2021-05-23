package io.github.ph1lou.werewolfapi.events.roles.oracle;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.enums.Aura;
import io.github.ph1lou.werewolfapi.events.roles.SelectionEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class OracleEvent extends SelectionEvent {

    private Aura aura;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public OracleEvent(IPlayerWW playerWW, IPlayerWW targetWW, Aura aura) {
        super(playerWW, targetWW);
        this.aura = aura;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public Aura getAura() {
        return aura;
    }

    public void setAura(Aura aura) {
        this.aura = aura;
    }
}
