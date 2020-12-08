package io.github.ph1lou.werewolfapi;

import java.util.List;

public interface LoverManagerAPI {

    List<LoverAPI> getLovers();

    void repartition(GetWereWolfAPI main);
}
