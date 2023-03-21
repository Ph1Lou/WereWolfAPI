package fr.ph1lou.werewolfapi.events.game.life_cycle;

import fr.ph1lou.werewolfapi.annotations.TellableStoryEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StatisticsEvent(key = "werewolf.kill_event")
@TellableStoryEvent
public class PlayerWWKillEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public PlayerWWKillEvent(@Nullable IPlayerWW killerWW, IPlayerWW playerWW) {
        super(killerWW, playerWW);
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
