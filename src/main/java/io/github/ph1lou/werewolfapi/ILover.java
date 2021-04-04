package io.github.ph1lou.werewolfapi;

import java.util.List;

public interface ILover {

    List<? extends IPlayerWW> getLovers();

    boolean isKey(String key);

    String getKey();

    boolean isAlive();

    boolean swap(IPlayerWW oldIPlayerWW, IPlayerWW newIPlayerWW);

    void second();
}
