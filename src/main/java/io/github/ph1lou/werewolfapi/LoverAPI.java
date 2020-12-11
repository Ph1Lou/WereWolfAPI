package io.github.ph1lou.werewolfapi;

import java.util.List;

public interface LoverAPI {

    List<? extends PlayerWW> getLovers();

    boolean isKey(String key);

    String getKey();

    boolean isAlive();

    boolean swap(PlayerWW oldPlayerWW,PlayerWW newPlayerWW);
}
