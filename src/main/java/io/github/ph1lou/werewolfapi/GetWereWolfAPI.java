package io.github.ph1lou.werewolfapi;

import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.Map;

/**
 * @author Ph1Lou
 */

@SuppressWarnings("unused")

public interface GetWereWolfAPI {
    WereWolfAPI getWereWolfAPI();
    List<RoleRegister> getRegisterRoles();
    Map<String,String> getExtraTexts();
    void loadTranslation(Plugin plugin, String defaultLang);
    Map<String, Commands> getListCommands();
    Map<String, Commands> getListAdminCommands();
    List<Plugin> getAddonsList();
    List<ScenarioRegister> getRegisterScenarios();
    List<ConfigRegister> getRegisterConfigs();
    List<TimerRegister> getRegisterTimers();
}