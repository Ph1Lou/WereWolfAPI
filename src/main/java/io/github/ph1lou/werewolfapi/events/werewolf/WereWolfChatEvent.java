package io.github.ph1lou.werewolfapi.events.werewolf;

import io.github.ph1lou.werewolfapi.Formatter;
import io.github.ph1lou.werewolfapi.IPlayerWW;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WereWolfChatEvent extends Event implements Cancellable {

    private final IPlayerWW playerWW;
    private final String message;
    private boolean cancel=false;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public WereWolfChatEvent(IPlayerWW playerWW, String message){
        this.playerWW = playerWW;
        this.message=message;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel=cancel;
    }

    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    public String getMessage() {
        return message;
    }

    public void sendMessage(IPlayerWW playerWW){

        WereWolfChatPrefixEvent event1 = new WereWolfChatPrefixEvent(this.getPlayerWW(),playerWW);

        Bukkit.getPluginManager().callEvent(event1);

        Formatter[] formatters = (Formatter[]) ArrayUtils.addAll(
                event1.getFormatters().toArray(new Formatter[0]),
                new Formatter[]{Formatter.format("&message&", this.message)});

        playerWW.sendMessageWithKey(event1.getPrefix(),formatters);
    }


}

