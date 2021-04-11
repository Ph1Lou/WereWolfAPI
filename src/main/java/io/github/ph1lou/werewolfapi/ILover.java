package io.github.ph1lou.werewolfapi;

import java.util.List;

public interface ILover {

    List<? extends IPlayerWW> getLovers();

    boolean isKey(String key);

    String getKey();

    boolean isAlive();

    /**
     * When a player is swap in the lover
     * @param oldIPlayerWW the player removed
     * @param newIPlayerWW the player added
     * @return true if the swap succeed
     */
    boolean swap(IPlayerWW oldIPlayerWW, IPlayerWW newIPlayerWW);

    /**
     * method call each second
     */
    void second();
}
