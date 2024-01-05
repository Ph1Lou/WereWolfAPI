package fr.ph1lou.werewolfapi.lovers.impl;

import fr.ph1lou.werewolfapi.annotations.Lover;
import fr.ph1lou.werewolfapi.lovers.ILoverBase;
import org.bukkit.Bukkit;

public class LoverBaseImpl implements ILoverBase {
    @Override
    public boolean isKey(String key) {
        return this.getKey().equals(key);
    }

    @Override
    public final String getKey() {

        Lover lover = this.getClass().getAnnotation(Lover.class);

        if (lover == null) {
            Bukkit.getLogger().severe(String.format("The class %s has not been annotated by the lover annotation",
                    this.getClass().getName()));
            return this.getClass().getName();
        }
        return lover.key();
    }

    @Override
    public String getColor() {
        Lover lover = this.getClass().getAnnotation(Lover.class);

        if (lover == null) {
            Bukkit.getLogger().severe(String.format("The class %s has not been annotated by the lover annotation",
                    this.getClass().getName()));
            return this.getClass().getName();
        }
        return lover.color();
    }
}
