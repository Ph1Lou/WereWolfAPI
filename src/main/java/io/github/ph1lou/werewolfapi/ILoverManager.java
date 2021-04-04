package io.github.ph1lou.werewolfapi;

import java.util.List;

public interface ILoverManager {

    List<? extends ILover> getLovers();

    void removeLover(ILover ILover);

    void addLover(ILover ILover);

    void repartition(GetWereWolfAPI main);
}
