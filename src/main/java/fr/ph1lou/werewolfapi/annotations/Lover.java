package fr.ph1lou.werewolfapi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Lover {
    String key();

    String color();

    String[] loreKey() default {};

    String[] requireRoles() default {};

    String[] incompatibleRoles() default {};

    IntValue[] configValues() default {};

    Configuration[] configurations() default {};

    Timer[] timers() default {};
}
