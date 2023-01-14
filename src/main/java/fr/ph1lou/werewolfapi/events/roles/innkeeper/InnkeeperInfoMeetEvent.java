package fr.ph1lou.werewolfapi.events.roles.innkeeper;

import fr.ph1lou.werewolfapi.events.roles.InfoNumberEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

public class InnkeeperInfoMeetEvent extends InfoNumberEvent {
    public InnkeeperInfoMeetEvent(IPlayerWW playerWW, int number) {
        super(playerWW, number);
    }
}
