package io.github.ph1lou.pluginlgapi;

import io.github.ph1lou.pluginlgapi.rolesattributs.Roles;

import java.lang.reflect.Constructor;

public class RoleRegister {

    GetWereWolfAPI api;
    String key;
    String name="";
    Constructor<? extends Roles> constructors= null;


    public RoleRegister(GetWereWolfAPI api, String key) {
        this.api= api;
        this.key=key;
    }


    public RoleRegister registerRole(Constructor<? extends Roles> constructors) {
        this.constructors=constructors;
        return this;
    }

    public RoleRegister setName(String name){
        this.name=name;
        return this;
    }

    public void create(){
        if(constructors==null) return;
        api.getRegisterRoles().put(key,constructors);
        api.getExtraTexts().put(key,name);
    }
}
