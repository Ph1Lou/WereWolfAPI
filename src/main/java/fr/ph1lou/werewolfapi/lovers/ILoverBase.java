package fr.ph1lou.werewolfapi.lovers;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.Listener;

import java.util.List;

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
