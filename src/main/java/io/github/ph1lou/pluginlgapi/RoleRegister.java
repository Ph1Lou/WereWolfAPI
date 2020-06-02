package io.github.ph1lou.pluginlgapi;

import io.github.ph1lou.pluginlgapi.rolesattributs.Roles;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class RoleRegister {

    GetWereWolfAPI api;
    String key;
    String name="";
    List<String> lore=new ArrayList<>();
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
    public RoleRegister setLore(List<String> lore){
        this.lore=lore;
        return this;
    }

    public void create(){
        if(constructors==null) return;
        api.getRegisterRoles().put(key,constructors);
        api.getExtraTexts().put(key.toLowerCase(),name);
        if(lore.isEmpty()) return;
        api.getExtraLore().put(key,lore);
    }
}
