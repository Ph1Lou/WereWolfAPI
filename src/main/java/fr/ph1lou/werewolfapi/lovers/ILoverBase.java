package fr.ph1lou.werewolfapi.lovers;

import org.bukkit.event.Listener;

public interface ILoverBase extends Listener {

    boolean isKey(String key);

    /**
     * Get the lover type key
     *
     * @return the string key
     */
    String getKey();

    String getColor();
}
