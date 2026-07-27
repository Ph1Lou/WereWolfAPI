package fr.ph1lou.werewolfapi.commands;

import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

/**
 * Variante « paramétrée » de {@link ICommandRole}. Les paramètres déclarés via
 * {@link fr.ph1lou.werewolfapi.annotations.Params} sont validés et résolus par le
 * dispatcher puis passés via {@link CommandContext}.
 *
 * <p>L'ancienne signature {@link #execute(WereWolfAPI, IPlayerWW, String[])} reçoit une
 * implémentation par défaut qui lève : elle n'est jamais appelée pour ces commandes
 * car le dispatcher branche sur {@code instanceof IParameterizedCommandRole}.</p>
 *
 * <p>Additif : les commandes existantes restent sur {@link ICommandRole} sans modification.</p>
 */
public interface IParameterizedCommandRole extends ICommandRole {

    /** Variante appelée par le dispatcher avec les paramètres déjà résolus dans {@code ctx}. */
    void execute(WereWolfAPI game, IPlayerWW player, CommandContext ctx);

    @Override
    default void execute(WereWolfAPI game, IPlayerWW player, String[] args) {
        throw new UnsupportedOperationException(
                "IParameterizedCommandRole must be dispatched via execute(..., CommandContext)");
    }
}
