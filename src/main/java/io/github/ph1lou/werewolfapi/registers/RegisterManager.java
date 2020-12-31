package io.github.ph1lou.werewolfapi.registers;

import java.util.List;

public interface RegisterManager {

    void registerAddon(AddonRegister addonRegister);
    void registerRole(RoleRegister roleRegister);
    void registerScenario(ScenarioRegister scenarioRegister);
    void registerConfig(ConfigRegister configRegister);
    void registerTimer(TimerRegister timerRegister);
    void registerAdminCommands(CommandRegister commandRegister);
    void registerCommands(CommandRegister commandRegister);
    void registerRandomEvents(RandomEventRegister randomEventRegister);

    List<? extends RoleRegister> getRolesRegister();

    List<? extends ScenarioRegister> getScenariosRegister();

    List<? extends ConfigRegister> getConfigsRegister();

    List<? extends TimerRegister> getTimersRegister();

    List<? extends CommandRegister> getCommandsRegister();

    List<? extends CommandRegister> getAdminCommandsRegister();

    List<? extends AddonRegister> getAddonsRegister();

    List<? extends RandomEventRegister> getRandomEventsRegister();
}
