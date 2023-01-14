package fr.ph1lou.werewolfapi.events.roles.innkeeper;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.player.utils.Formatter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ClientDeathEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW host;
    private final IPlayerWW client;
    private final Formatter formatterRole;
    private boolean cancel = false;

    public ClientDeathEvent(IPlayerWW host, IPlayerWW client, Formatter formatterRole) {
        this.host = host;
        this.client = client;
        this.formatterRole = formatterRole;
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

    public IPlayerWW getClient() {
        return client;
    }

    public IPlayerWW getHost() {
        return host;
    }

    public Formatter getFormatterRole() {
        return formatterRole;
    }
}
