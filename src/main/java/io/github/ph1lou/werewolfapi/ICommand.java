package io.github.ph1lou.werewolfapi;

import org.bukkit.entity.Player;

public interface ICommand {

    void execute(WereWolfAPI game,Player player, String[] args);

}
