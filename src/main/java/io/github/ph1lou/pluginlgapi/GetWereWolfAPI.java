package io.github.ph1lou.pluginlgapi;

import io.github.ph1lou.pluginlgapi.rolesattributs.Roles;

import java.lang.reflect.Constructor;
import java.util.Map;

public interface GetWereWolfAPI {
    WereWolfAPI getWereWolfAPI();
    Map<String, Constructor<? extends Roles>> registerRoles();
    Map<String,String> getExtraTexts();
}