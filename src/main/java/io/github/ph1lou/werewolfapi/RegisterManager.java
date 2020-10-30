package io.github.ph1lou.werewolfapi;

public interface RegisterManager {

    void registerAddon(AddonRegister addonRegister);
    void registerRole(RoleRegister roleRegister);
    void registerScenario(ScenarioRegister scenarioRegister);
    void registerConfig(ConfigRegister configRegister);
    void registerTimer(TimerRegister timerRegister);
    void registerAdminCommands(CommandRegister commandRegister);
    void registerCommands(CommandRegister commandRegister);
}
