package fr.ph1lou.werewolfapi.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Conteneur des paramètres d'entrée d'une commande. Membre {@code args()} de
 * {@link AdminCommand}, {@link PlayerCommand} et {@link RoleCommand}.
 *
 * <p>Chaque type de paramètre est décrit par une annotation dédiée (avec uniquement
 * ses champs pertinents), regroupée ici. Le résolveur fusionne tous les tableaux par
 * {@code index} avant validation.</p>
 *
 * <pre>{@code
 * @RoleCommand(key = "...",
 *     args = @Params(
 *         players  = @PlayerArg(index = 0, states = { StatePlayer.ALIVE }, excludeSelf = true),
 *         integers  = @IntArg(index = 1, min = 1, max = 5)))
 * }</pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Params {

    /** Paramètres joueurs cibles. */
    PlayerArg[] players() default {};

    /** Paramètres joueurs Bukkit (en ligne, hors logique de partie). */
    PlayerBukkitArg[] bukkitPlayers() default {};

    /** Paramètres entiers. */
    IntArg[] integers() default {};

    /** Paramètres chaînes. */
    StringArg[] strings() default {};

    /** Paramètres énumérations. */
    EnumArg[] enums() default {};

    /** Paramètres choix fixes. */
    ChoiceArg[] choices() default {};
}
