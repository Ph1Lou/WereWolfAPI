package fr.ph1lou.werewolfapi.events.werewolf;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsExtraInfo;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.player.utils.Formatter;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@StatisticsEvent(key = "werewolf.werewolf_message")
public class WereWolfChatEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private final String message;
    private boolean cancel = false;

    public WereWolfChatEvent(IPlayerWW playerWW, String message) {
        this.playerWW = playerWW;
        this.message = message;
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
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @StatisticsPlayer
    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    @StatisticsExtraInfo
    public String getMessage() {
        return message;
    }

    public void sendMessage(IPlayerWW playerWW) {

        WereWolfChatPrefixEvent event1 = new WereWolfChatPrefixEvent(this.getPlayerWW(), playerWW);

        Bukkit.getPluginManager().callEvent(event1);

        Formatter[] formatters = (Formatter[]) ArrayUtils.addAll(
                event1.getFormatters().toArray(new Formatter[0]),
                new Formatter[]{Formatter.format("&message&", this.message)});

        playerWW.sendMessageWithKey(event1.getPrefix(), formatters);
    }


}

