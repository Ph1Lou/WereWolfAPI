package fr.ph1lou.werewolfapi.events.roles.oracle;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.enums.Aura;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.oracle_see")
public class OracleEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private Aura aura;

    public OracleEvent(IPlayerWW playerWW, IPlayerWW targetWW, Aura aura) {
        super(playerWW, targetWW);
        this.aura = aura;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public Aura getAura() {
        return aura;
    }


    public void setAura(Aura aura) {
        this.aura = aura;
    }

    @StatisticsExtraInfo
    public String getExtraInfo() {
        return aura.getKey();
    }
}
