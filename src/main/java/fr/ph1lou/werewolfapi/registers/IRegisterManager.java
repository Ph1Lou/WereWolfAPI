package fr.ph1lou.werewolfapi.registers;


import fr.ph1lou.werewolfapi.commands.ICommand;
import fr.ph1lou.werewolfapi.listeners.impl.ListenerManager;
import fr.ph1lou.werewolfapi.role.interfaces.IRole;
import fr.ph1lou.werewolfapi.utils.Wrapper;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IRegisterManager {

    Set<Wrapper<IRole>> getRolesRegister();

    Set<Wrapper<ListenerManager>> getScenariosRegister();

    Set<Wrapper<?>> getConfigsRegister();

    Set<Wrapper<?>> getTimersRegister();

    Set<Wrapper<ICommand>> getCommandsRegister();

    Set<Wrapper<ICommand>> getAdminCommandsRegister();

    Set<Wrapper<JavaPlugin>> getAddonsRegister();

    Set<Wrapper<ListenerManager>> getRandomEventsRegister();
}
