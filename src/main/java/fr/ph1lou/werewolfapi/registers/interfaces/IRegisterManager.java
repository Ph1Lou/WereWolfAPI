package fr.ph1lou.werewolfapi.registers.interfaces;

import fr.ph1lou.werewolfapi.registers.impl.AddonRegister;
import fr.ph1lou.werewolfapi.registers.impl.CommandRegister;
import fr.ph1lou.werewolfapi.registers.impl.ConfigRegister;
import fr.ph1lou.werewolfapi.registers.impl.RandomEventRegister;
import fr.ph1lou.werewolfapi.registers.impl.RoleRegister;
import fr.ph1lou.werewolfapi.registers.impl.ScenarioRegister;
import fr.ph1lou.werewolfapi.registers.impl.TimerRegister;

import java.util.List;
import java.util.Optional;

public interface IRegisterManager {

    void registerAddon(AddonRegister addonRegister);
    void registerRole(RoleRegister roleRegister);
    void registerScenario(ScenarioRegister scenarioRegister);
    void registerConfig(ConfigRegister configRegister);
    void registerTimer(TimerRegister timerRegister);
    void registerAdminCommands(CommandRegister commandRegister);
    void registerCommands(CommandRegister commandRegister);
    void registerRandomEvents(RandomEventRegister randomEventRegister);

    Optional<IRegisterManager> getRegister(String key);

    List<? extends RoleRegister> getRolesRegister();

    List<? extends ScenarioRegister> getScenariosRegister();

    List<? extends ConfigRegister> getConfigsRegister();

    List<? extends TimerRegister> getTimersRegister();

    List<? extends CommandRegister> getCommandsRegister();

    List<? extends CommandRegister> getAdminCommandsRegister();

    List<? extends AddonRegister> getAddonsRegister();

    List<? extends RandomEventRegister> getRandomEventsRegister();
}
