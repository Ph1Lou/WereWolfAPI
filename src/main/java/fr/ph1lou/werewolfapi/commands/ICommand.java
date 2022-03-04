package fr.ph1lou.werewolfapi.commands;

import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import org.bukkit.entity.Player;

public interface ICommand {

    void execute(WereWolfAPI game, Player player, String[] args);

}
