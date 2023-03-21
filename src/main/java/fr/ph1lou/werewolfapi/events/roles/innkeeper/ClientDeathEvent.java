package fr.ph1lou.werewolfapi.events.roles.innkeeper;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTarget;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.innkeeper.client_death")
public class ClientDeathEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW host;
    private final IPlayerWW client;
    private final String role;
    private boolean cancel = false;

    public ClientDeathEvent(IPlayerWW host, IPlayerWW client, String role) {
        this.host = host;
        this.client = client;
        this.role = role;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancel = b;
    }

    @StatisticsTarget
    public IPlayerWW getClient() {
        return client;
    }

    @StatisticsPlayer
    public IPlayerWW getHost() {
        return host;
    }

    @StatisticsExtraInfo
    public String getRole() {
        return role;
    }
}
