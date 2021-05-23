package io.github.ph1lou.werewolfapi.events.werewolf;

import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.WereWolfAPI;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import java.util.function.Function;

public class WereWolfChatPrefixEvent extends Event  {

    private final WereWolfAPI api;
    private final IPlayerWW playerWW;
    private final IPlayerWW requester;

    private Function<WereWolfAPI,String> prefix= (game) -> game.translate("werewolf.commands.admin.ww_chat.prefix",
            "%s");
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public WereWolfChatPrefixEvent(WereWolfAPI api,IPlayerWW playerWW, IPlayerWW requester){
        this.api=api;
        this.playerWW=playerWW;
        this.requester=requester;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public IPlayerWW getPlayerWW() {
        return this.playerWW;
    }

    public IPlayerWW getRequester() {
        return this.requester;
    }

    public String getPrefix() {
        return prefix.apply(this.api).replace("&name&",playerWW.getName());
    }

    public void setPrefix(Function<WereWolfAPI,String> prefix) {
        this.prefix = prefix;
    }
}
