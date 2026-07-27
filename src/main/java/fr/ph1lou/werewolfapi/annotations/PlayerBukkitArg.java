package fr.ph1lou.werewolfapi.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Paramètre de commande de type joueur Bukkit, résolu en {@link org.bukkit.entity.Player}
 * via {@code Bukkit.getPlayer(name)}. Contrairement à {@link PlayerArg}, <strong>aucune</strong>
 * vérification d'appartenance à la partie ({@code getPlayerWW}) ni d'état n'est effectuée :
 * la seule contrainte est que le joueur soit en ligne.
 *
 * <p>Conçu pour les commandes admin ciblant un joueur arbitraire (host, modérateur,
 * whitelist, retardataire, inventaire…) qui n'est pas nécessairement un
 * {@code IPlayerWW} de la partie. Membre de {@link Params#bukkitPlayers()}.</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface PlayerBukkitArg {

    /**
     * Position dans le tableau {@code args} reçu par {@code execute} (post-sous-commande) :
     * {@code 0} = premier vrai paramètre.
     */
    int index();

    /** {@code false} = paramètre optionnel. */
    boolean required() default true;
}
