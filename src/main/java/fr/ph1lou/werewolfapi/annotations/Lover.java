package fr.ph1lou.werewolfapi.annotations;

public @interface Lover {
    String key();
    String[] loreKey() default {};
    String[] requireRoles() default {};
    String[] incompatibleRoles() default {};
    IntValue[] intValues() default {};
    Configuration[] configurations() default {};
    Timer[] timers() default {};
}
