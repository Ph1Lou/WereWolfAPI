package io.github.ph1lou.werewolfapi;

import java.util.List;

public interface LoverManagerAPI {

    List<? extends LoverAPI> getLovers();

    void removeLover(LoverAPI loverAPI);

    void addLover(LoverAPI loverAPI);

    void repartition(GetWereWolfAPI main);
}
