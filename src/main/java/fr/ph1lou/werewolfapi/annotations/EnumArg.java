package fr.ph1lou.werewolfapi.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Paramètre de commande de type valeur d'énumération. Membre de {@link Params#enums()}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface EnumArg {

    /** Position dans le tableau {@code args} reçu par {@code execute} (post-sous-commande). */
    int index();

    /** Classe de l'énumération dont la valeur doit faire partie. */
    Class<? extends Enum> enumClass();

    /** {@code false} = paramètre optionnel. */
    boolean required() default true;
}
