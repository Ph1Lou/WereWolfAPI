package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.rolesattributs.IRole;
import io.github.ph1lou.werewolfapi.rolesattributs.ITransformed;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class DescriptionBuilder {

    private String description;
    private String power;
    private String items;
    private String effects;
    private String equipments;
    private String command;
    private final List<String> extraLines = new ArrayList<>();

    private final WereWolfAPI game;
    private final IRole role;

    public DescriptionBuilder(WereWolfAPI game, IRole role){
        this.game=game;
        this.role = role;
    }

    public DescriptionBuilder setDescription(String key){
        this.description= key;
        return this;
    }

    public DescriptionBuilder setPower(String key) {
        this.power = key;
        return this;
    }

    public DescriptionBuilder setCommand(String key) {
        this.command = key;
        return this;
    }

    public DescriptionBuilder setItems(String key) {
        this.items = key;
        return this;
    }

    public DescriptionBuilder addExtraLines(String key) {
        this.extraLines.add(key);
        return this;
    }

    public DescriptionBuilder setEffects(String key) {
        this.effects = key;
        return this;
    }

    public DescriptionBuilder setEquipments(String key) {
        this.equipments = key;
        return this;
    }

    public String build(){

        StringBuilder sb = new StringBuilder();

        sb.append(this.game.translate("werewolf.description.role", this.game.translate(this.role.getDeathRole()) +
                (!this.role.getDeathRole().equals(this.role.getKey()) ? this.game.translate("werewolf.role.thief.thief", this.game.translate(this.role.getKey())) : "") +
                (this.role.getInfected() ? this.game.translate("werewolf.end.infect") : "") +
                (this.role.isSolitary() ? this.game.translate("werewolf.end.solitary") : "")));

        sb.append(this.game.translate("werewolf.description.camp",
                this.role.getCamp().getChatColor()+this.game.translate(this.role.getCamp().getKey())));

        sb.append(this.role.getInfected()?
                this.game.translate("werewolf.description.effect",this.game.translate("werewolf.description.werewolf"))
                :"");

        sb.append(this.role instanceof ITransformed ?
                this.game.translate("werewolf.description.transformed",
                        this.game.translate(((ITransformed) this.role).getTransformed()?
                                "werewolf.description.yes"
                                : "werewolf.description.no"))
                : "");

        if(this.description!=null){
            sb.append(this.game.translate("werewolf.description.description", this.description));
        }

        if(this.power!=null){
            sb.append(this.game.translate("werewolf.description.power",this.power));
        }

        if(this.effects!=null){
            sb.append(this.game.translate("werewolf.description.effect",this.effects));
        }

        if(this.items!=null){
            sb.append(this.game.translate("werewolf.description.item",this.items));
        }

        if(this.equipments!=null){
            sb.append(this.game.translate("werewolf.description.equipment",this.equipments));
        }

        if(this.command!=null){
            sb.append(this.game.translate("werewolf.description.command",this.command));
        }

        this.extraLines.forEach(sb::append);

        return this.game.translate("werewolf.description._") +
                sb.toString() +
                this.game.translate("werewolf.description._");

    }
}
