package fr.ph1lou.werewolfapi.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Paramètre de commande de type chaîne libre (éventuellement restreinte).
 * Membre de {@link Params#strings()}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface StringArg {

    /** Position dans le tableau {@code args} reçu par {@code execute} (post-sous-commande). */
    int index();

    /** Valeurs autorisées (vide = aucune restriction). */
    String[] choices() default {};

    /** Longueur maximale (-1 = illimitée). */
    int maxLength() default -1;

    /** {@code false} = paramètre optionnel. */
    boolean required() default true;
}
