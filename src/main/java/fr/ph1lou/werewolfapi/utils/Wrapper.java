package fr.ph1lou.werewolfapi.utils;

import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.util.Optional;

public class Wrapper<T> {

    private final Class<T> clazz;
    private final Annotation annotation;

    @Nullable
    private final T object;

    public Wrapper(Class<T> clazz, Annotation annotation, @Nullable T object) {
        this.clazz = clazz;
        this.annotation = annotation;
        this.object = object;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public Optional<T> getObject() {
        return Optional.ofNullable(object);
    }
}
