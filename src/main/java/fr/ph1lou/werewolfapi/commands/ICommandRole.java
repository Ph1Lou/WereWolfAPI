package fr.ph1lou.werewolfapi.commands;

import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

public interface ICommandRole {

    void execute(WereWolfAPI game, IPlayerWW player, String[] args);

}
