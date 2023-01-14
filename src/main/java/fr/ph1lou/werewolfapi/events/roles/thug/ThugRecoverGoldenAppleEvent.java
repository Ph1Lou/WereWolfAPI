package fr.ph1lou.werewolfapi.events.roles.thug;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInt;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.thug_recover_golden_apple")
public class ThugRecoverGoldenAppleEvent extends SelectionEvent {

    private int goldenApple;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public ThugRecoverGoldenAppleEvent(IPlayerWW playerWW, IPlayerWW targetWW, int goldenApple) {
        super(playerWW, targetWW);
        this.goldenApple=goldenApple;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }


    @StatisticsExtraInt
    public int getGoldenApple() {
        return goldenApple;
    }

    public void setGoldenApple(int goldenApple) {
        this.goldenApple = goldenApple;
    }
}