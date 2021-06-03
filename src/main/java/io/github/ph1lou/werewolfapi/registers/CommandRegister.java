package io.github.ph1lou.werewolfapi.registers;

import io.github.ph1lou.werewolfapi.ICommands;
import io.github.ph1lou.werewolfapi.enums.StatePlayer;
import io.github.ph1lou.werewolfapi.enums.StateGame;

import java.util.HashSet;
import java.util.Set;

public class CommandRegister implements IRegister {

    private final Set<String> roleKeys = new HashSet<>();

    private final String key;

    private boolean roleOnly = false;

    private boolean moderatorAccess = false;

    private final Set<StatePlayer> statePlayerAccesses = new HashSet<>();

    private final Set<StateGame> stateWW = new HashSet<>();

    private final Set<Integer> argNumbers = new HashSet<>();

    private boolean hostAccess = false;

    private boolean autoCompletion = true;

    private boolean requiredPower = false;

    private boolean requiredPlayerInGame = false;

    private final ICommands command;

    private final String addonKey;

    private String description="";

    public CommandRegister(String addonKey, String key, ICommands command){
        this.addonKey=addonKey;
        this.key=key;
        this.command=command;
    }

    public boolean getRoleOnly(){
        return roleOnly;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getAddonKey() {
        return addonKey;
    }

    public boolean isRoleKey(String roleKey) {
        return this.roleKeys.contains(roleKey);
    }

    public String getOneRoleKey(){
        return roleKeys.stream().findFirst().orElse("");
    }

    public ICommands getCommand() {
        return command;
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
        this.roleOnly=true;
        this.requiredPlayerInGame=true;
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
        this.requiredPlayerInGame=true;
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


    public String getDescription() {
        return description;
    }

    public CommandRegister setDescription(String description) {
        this.description = description;
        return this;
    }
}