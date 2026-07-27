package fr.ph1lou.werewolfapi.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Paramètre de commande de type entier. Membre de {@link Params#integers()}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface IntArg {

    /** Position dans le tableau {@code args} reçu par {@code execute} (post-sous-commande). */
    int index();

    /** Borne minimale (inclusive). */
    int min() default Integer.MIN_VALUE;

    /** Borne maximale (inclusive). */
    int max() default Integer.MAX_VALUE;

    /** {@code false} = paramètre optionnel. */
    boolean required() default true;
}
