package fr.ph1lou.werewolfapi.annotations;

public @interface DisableAutoLoad {
    boolean isDisable() default true;
}
