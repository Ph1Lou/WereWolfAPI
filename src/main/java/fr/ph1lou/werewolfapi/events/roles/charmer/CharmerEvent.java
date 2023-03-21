package fr.ph1lou.werewolfapi.events.roles.charmer;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.charmer_charmed")
public class CharmerEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public CharmerEvent(IPlayerWW playerWW, IPlayerWW charmerWW) {
        super(playerWW, charmerWW);
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

}