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
    List<Plugin> getAddonsList();
    List<ScenarioRegister> getRegisterScenarios();
    List<ConfigRegister> getRegisterConfigs();
    List<TimerRegister> getRegisterTimers();
    void registerAdminCommands(CommandRegister commandRegister);
    void registerCommands(CommandRegister commandRegister);
}