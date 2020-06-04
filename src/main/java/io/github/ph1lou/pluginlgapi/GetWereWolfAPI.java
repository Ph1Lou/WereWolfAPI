package io.github.ph1lou.pluginlgapi;

import io.github.ph1lou.pluginlgapi.rolesattributs.Roles;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;

/**
 * @author Ph1Lou
 */

public interface GetWereWolfAPI {
    WereWolfAPI getWereWolfAPI();
    List<RoleRegister> getRegisterRoles();
    Map<String,String> getExtraTexts();
}