package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.PlayerWW;

import java.util.List;

public interface LoverAPI {

    List<? extends PlayerWW> getLovers();

    boolean isKey(String key);

    String getKey();

    boolean isAlive();

    void swap(PlayerWW oldPlayerWW,PlayerWW newPlayerWW);
}
