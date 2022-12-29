package fr.ph1lou.werewolfapi.utils;

public class Wrapper<T, U> {

    private final Class<T> clazz;
    private final U annotation;
    private final String addonKey;

    public Wrapper(Class<T> clazz,
                   U annotation,
                   String addonKey) {
        this.clazz = clazz;
        this.annotation = annotation;
        this.addonKey = addonKey;
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

}
