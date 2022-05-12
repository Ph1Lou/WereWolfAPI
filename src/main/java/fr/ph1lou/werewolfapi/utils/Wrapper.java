package fr.ph1lou.werewolfapi.utils;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class Wrapper<T, U> {

    private final Class<T> clazz;
    private final U annotation;
    private final String addonKey;

    @Nullable
    private final T object;

    public Wrapper(Class<T> clazz,
                   U annotation,
                   String addonKey,
                   @Nullable T object) {
        this.clazz = clazz;
        this.annotation = annotation;
        this.addonKey = addonKey;
        this.object = object;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public U getMetaDatas() {
        return annotation;
    }

    public String getAddonKey() {
        return addonKey;
    }

    public Optional<T> getObject() {
        return Optional.ofNullable(object);
    }
}
