package fr.ph1lou.werewolfapi.events.werewolf;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.player.utils.Formatter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WereWolfChatPrefixEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private final IPlayerWW requester;
    private final List<Formatter> formatters = new ArrayList<>();
    private String prefix = "werewolf.commands.player.ww_chat.prefix";

    public WereWolfChatPrefixEvent(IPlayerWW playerWW, IPlayerWW requester) {
        this.playerWW = playerWW;
        this.requester = requester;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    public IPlayerWW getRequester() {
        return this.requester;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public List<? extends Formatter> getFormatters() {
        return this.formatters;
    }

    public void addFormatter(Formatter formatter) {
        this.formatters.add(formatter);
    }
}
