package fr.ph1lou.werewolfapi.commands;

import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import org.bukkit.entity.Player;

/**
 * Variante « paramétrée » de {@link ICommand}. Les paramètres déclarés via
 * {@link fr.ph1lou.werewolfapi.annotations.Params} sont validés et résolus par le
 * dispatcher puis passés via {@link CommandContext}.
 *
 * <p>L'ancienne signature {@link #execute(WereWolfAPI, Player, String[])} reçoit une
 * implémentation par défaut qui lève : elle n'est jamais appelée pour ces commandes
 * car le dispatcher branche sur {@code instanceof IParameterizedCommand}.</p>
 *
 * <p>Additif : les commandes existantes restent sur {@link ICommand} sans modification.</p>
 */
public interface IParameterizedCommand extends ICommand {

    /** Variante appelée par le dispatcher avec les paramètres déjà résolus dans {@code ctx}. */
    void execute(WereWolfAPI game, Player player, CommandContext ctx);

    @Override
    default void execute(WereWolfAPI game, Player player, String[] args) {
        throw new UnsupportedOperationException(
                "IParameterizedCommand must be dispatched via execute(..., CommandContext)");
    }
}
