package fr.ph1lou.werewolfapi.events.game.honor;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class HonorChangeEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final IPlayerWW playerWW;
    private final int oldHonor;

    public HonorChangeEvent(IPlayerWW playerWW, int oldHonor) {
        this.playerWW = playerWW;
        this.oldHonor = oldHonor;
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
        return playerWW;
    }

    public int getOldHonor() {
        return oldHonor;
    }
}
