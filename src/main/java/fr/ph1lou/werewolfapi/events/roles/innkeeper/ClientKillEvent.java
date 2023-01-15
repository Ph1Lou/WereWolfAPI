package fr.ph1lou.werewolfapi.events.roles.innkeeper;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.innkeeper_kill")
public class ClientKillEvent extends SelectionEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public ClientKillEvent(IPlayerWW host, IPlayerWW client) {
        super(host, client);
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
