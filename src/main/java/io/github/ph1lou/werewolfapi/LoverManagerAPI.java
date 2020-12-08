package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.rolesattributs.LoverAPI;

import java.util.List;

public interface LoverManagerAPI {

    List<LoverAPI> getLovers();

    void repartition(GetWereWolfAPI main);
}
