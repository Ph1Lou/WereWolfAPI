package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.enumlg.StatePlayer;
import io.github.ph1lou.werewolfapi.enumlg.StateGame;

import java.util.HashSet;
import java.util.Set;

public class CommandRegister {


    private String name;
    private final Set<String> roleKeys = new HashSet<>();
    private String permission;
    private boolean roleOnly = false;
    private boolean moderatorAccess = false;
    private final Set<StatePlayer> statePlayerAccesses = new HashSet<>();
    private final Set<StateGame> stateWW = new HashSet<>();
    private final Set<Integer> argNumbers = new HashSet<>();
    private boolean hostAccess = false;
    private boolean autoCompletion = true;
    private boolean requiredPower = false;
    private boolean requiredPlayerInGame = false;
    private Commands command=null;


    public CommandRegister registerCommand(Commands command) {
        this.command=command;
        return this;
    }

    public boolean getRoleOnly(){
        return roleOnly;
    }

    public CommandRegister setRoleOnly(){
        this.roleOnly = true;
        this.requiredPlayerInGame=true;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public boolean isRoleKey(String roleKey) {
        return this.roleKeys.contains(roleKey);
    }

    public CommandRegister setName(String name) {
        this.name = name;
        this.permission="a."+name;
        return this;
    }

    public Commands getCommand() {
        return command;
    }

    public String getPermission() {
        return permission;
    }

    public boolean isRoleOnly() {
        return roleOnly;
    }

    public boolean isModeratorAccess() {
        return moderatorAccess;
    }

    public CommandRegister setModeratorAccess() {
        this.moderatorAccess = true;
        return this;
    }

    public CommandRegister addRoleKey(String roleKeys) {
        this.roleKeys.add(roleKeys);
        return this;
    }

    public boolean isHostAccess() {
        return hostAccess;
    }

    public CommandRegister setHostAccess() {
        this.hostAccess = true;
        return this;
    }

    public boolean isAutoCompletion() {
        return autoCompletion;
    }

    public CommandRegister unsetAutoCompletion() {
        this.autoCompletion = false;
        return this;
    }


    public boolean isRequiredPlayerInGame() {
        return requiredPlayerInGame;
    }

    public CommandRegister setRequiredPlayerInGame() {
        this.requiredPlayerInGame = true;
        return this;
    }


    public boolean isStateAccess(StatePlayer statePlayer) {
        return statePlayerAccesses.isEmpty() || statePlayerAccesses.contains(statePlayer);
    }

    public CommandRegister addStateAccess(StatePlayer statePlayerAccess) {
        this.statePlayerAccesses.add(statePlayerAccess);
        this.requiredPlayerInGame = true;
        return this;
    }

    public boolean isArgNumbers(int args) {
        return argNumbers.isEmpty() || argNumbers.contains(args);
    }

    public CommandRegister addArgNumbers(int argNumbers) {
        this.argNumbers.add(argNumbers);
        return this;
    }

    public boolean isRequiredPower() {
        return requiredPower;
    }

    public CommandRegister setRequiredPower() {
        this.requiredPower = true;
        return this;
    }

    public boolean isStateWW(StateGame stateLG) {

        return stateWW.isEmpty() || stateWW.contains(stateLG);
    }

    public CommandRegister addStateWW(StateGame stateLG) {
        stateWW.add(stateLG);
        return this;
    }

    public int getMinArgNumbers() {
        return argNumbers.stream()
                .min(Integer::compareTo)
                .orElse(0);
    }
}