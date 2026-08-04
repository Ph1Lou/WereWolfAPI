package fr.ph1lou.werewolfapi.events.roles.trouble_maker;

import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsPlayer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsTarget;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Déclenché par le Trublion lors d'un échange des rôles de deux joueurs
 * (commande {@code /lg switch}). Annulable : un listener peut empêcher l'échange.
 */
@StatisticsEvent(key = "werewolf.trouble_maker_switch")
public class TroubleMakerSwitchEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final IPlayerWW playerWW;
    private final IPlayerWW target1;
    private final IPlayerWW target2;
    private boolean cancel = false;

    public TroubleMakerSwitchEvent(IPlayerWW playerWW, IPlayerWW target1, IPlayerWW target2) {
        this.playerWW = playerWW;
        this.target1 = target1;
        this.target2 = target2;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @StatisticsPlayer
    public IPlayerWW getPlayerWW() {
        return playerWW;
    }

    @StatisticsTarget
    public IPlayerWW getTarget1() {
        return target1;
    }

    @StatisticsTarget
    public IPlayerWW getTarget2() {
        return target2;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
