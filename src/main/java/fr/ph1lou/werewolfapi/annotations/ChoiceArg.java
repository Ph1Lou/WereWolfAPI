package fr.ph1lou.werewolfapi.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Paramètre de commande de type choix parmi un ensemble fixe de chaînes.
 * Membre de {@link Params#choices()}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface ChoiceArg {

    /** Position dans le tableau {@code args} reçu par {@code execute} (post-sous-commande). */
    int index();

    /** Valeurs autorisées. */
    String[] choices();

    /** {@code false} = paramètre optionnel. */
    boolean required() default true;
}
