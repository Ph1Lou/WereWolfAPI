package fr.ph1lou.werewolfapi.registers;


import fr.ph1lou.werewolfapi.annotations.AdminCommand;
import fr.ph1lou.werewolfapi.annotations.Configuration;
import fr.ph1lou.werewolfapi.annotations.Lover;
import fr.ph1lou.werewolfapi.annotations.ModuleWerewolf;
import fr.ph1lou.werewolfapi.annotations.PlayerCommand;
import fr.ph1lou.werewolfapi.annotations.RandomEvent;
import fr.ph1lou.werewolfapi.annotations.Role;
import fr.ph1lou.werewolfapi.annotations.RoleCommand;
import fr.ph1lou.werewolfapi.annotations.Scenario;
import fr.ph1lou.werewolfapi.annotations.Timer;
import fr.ph1lou.werewolfapi.annotations.statistics.StatisticsEvent;
import fr.ph1lou.werewolfapi.commands.ICommand;
import fr.ph1lou.werewolfapi.commands.ICommandRole;
import fr.ph1lou.werewolfapi.enums.Category;
import fr.ph1lou.werewolfapi.listeners.impl.ListenerWerewolf;
import fr.ph1lou.werewolfapi.lovers.ILover;
import fr.ph1lou.werewolfapi.role.interfaces.IRole;
import fr.ph1lou.werewolfapi.utils.Wrapper;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;
import java.util.Set;

public interface IRegisterManager {

    Optional<String> getModuleKey(String key);

    Set<Wrapper<IRole, Role>> getRolesRegister();

    Set<Wrapper<ILover, Lover>> getLoversRegister();

    Set<Wrapper<ListenerWerewolf, Scenario>> getScenariosRegister();

    Set<Wrapper<?, Configuration>> getConfigsRegister();

    Set<Wrapper<?, Timer>> getTimersRegister();

    Set<Wrapper<ICommand, PlayerCommand>> getPlayerCommandsRegister();

    Set<Wrapper<ICommandRole, RoleCommand>> getRoleCommandsRegister();

    Set<Wrapper<ICommand, AdminCommand>> getAdminCommandsRegister();

    Set<Wrapper<JavaPlugin, ModuleWerewolf>> getModulesRegister();

    Set<Wrapper<ListenerWerewolf, RandomEvent>> getRandomEventsRegister();

    Set<Wrapper<Event, StatisticsEvent>> getEventsClass();

    Optional<JavaPlugin> getAddon(String key);

    Optional<Category> getCategory(String key);
}
