package fr.ph1lou.werewolfapi.commands;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.entity.Player;

/**
 * Contexte d'exécution d'une commande {@code IParameterizedCommand} /
 * {@code IParameterizedCommandRole}. Les paramètres déclarés via
 * {@link fr.ph1lou.werewolfapi.annotations.Params} (tableaux typés
 * {@code PlayerArg}/{@code PlayerBukkitArg}/{@code IntArg}/{@code StringArg}/
 * {@code EnumArg}/{@code ChoiceArg}) y sont déjà validés et résolus par le dispatcher.
 *
 * <p>L'indexation correspond au champ {@code index} de chaque annotation :
 * {@code 0} = premier vrai paramètre.</p>
 */
public interface CommandContext {

    /** Arguments bruts reçus (post-sous-commande). */
    String[] args();

    /** {@code true} si le paramètre à {@code index} est présent (utile pour les args optionnels). */
    boolean has(int index);

    /** PLAYER : le {@code IPlayerWW} résolu à {@code index}. */
    IPlayerWW player(int index);

    /** PLAYER_BUKKIT : le {@link Player} en ligne résolu à {@code index} (hors logique de partie). */
    Player bukkitPlayer(int index);

    /** INT : l'entier résolu à {@code index}. */
    int intValue(int index);

    /** STRING / CHOICE : la chaîne résolue à {@code index}. */
    String string(int index);

    /** ENUM : la valeur d'énumération résolue à {@code index} (déjà validée par le dispatcher). */
    <E extends Enum<E>> E enumValue(int index, Class<E> enumClass);
}
