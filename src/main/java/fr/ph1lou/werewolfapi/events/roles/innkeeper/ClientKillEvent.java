package fr.ph1lou.werewolfapi.events.roles.innkeeper;

import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

public class ClientKillEvent extends SelectionEvent {
    public ClientKillEvent(IPlayerWW host, IPlayerWW client) {
        super(host, client);
    }
}
