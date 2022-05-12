package fr.ph1lou.werewolfapi.registers;


import fr.ph1lou.werewolfapi.annotations.Addon;
import fr.ph1lou.werewolfapi.annotations.AdminCommand;
import fr.ph1lou.werewolfapi.annotations.PlayerCommand;
import fr.ph1lou.werewolfapi.annotations.Configuration;
import fr.ph1lou.werewolfapi.annotations.Event;
import fr.ph1lou.werewolfapi.annotations.Role;
import fr.ph1lou.werewolfapi.annotations.RoleCommand;
import fr.ph1lou.werewolfapi.annotations.Scenario;
import fr.ph1lou.werewolfapi.annotations.Timer;
import fr.ph1lou.werewolfapi.commands.ICommand;
import fr.ph1lou.werewolfapi.listeners.impl.ListenerManager;
import fr.ph1lou.werewolfapi.role.interfaces.IRole;
import fr.ph1lou.werewolfapi.utils.Wrapper;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public interface IRegisterManager {

    Set<Wrapper<IRole, Role>> getRolesRegister();

    Set<Wrapper<ListenerManager, Scenario>> getScenariosRegister();

    Set<Wrapper<?, Configuration>> getConfigsRegister();

    Set<Wrapper<?, Timer>> getTimersRegister();

    Set<Wrapper<ICommand, PlayerCommand>> getPlayerCommandsRegister();

    Set<Wrapper<ICommand, RoleCommand>> getRoleCommandsRegister();

    Set<Wrapper<ICommand, AdminCommand>> getAdminCommandsRegister();

    Set<Wrapper<JavaPlugin, Addon>> getAddonsRegister();

    Set<Wrapper<ListenerManager, Event>> getRandomEventsRegister();
}
