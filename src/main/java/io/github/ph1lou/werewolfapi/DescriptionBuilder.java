package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.rolesattributs.IRole;
import io.github.ph1lou.werewolfapi.rolesattributs.ITransformed;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class DescriptionBuilder {

    private Supplier<String> description;
    private Supplier<String> power;
    private Supplier<String> items;
    private Supplier<String> effects;
    private Supplier<String> equipments;
    private Supplier<String> command;
    private final List<Supplier<String>> extraLines = new ArrayList<>();

    private final WereWolfAPI game;
    private final IRole IRole;

    public DescriptionBuilder(WereWolfAPI game, IRole IRole){
        this.game=game;
        this.IRole = IRole;
    }

    public DescriptionBuilder setDescription(Supplier<String> key){
        this.description= key;
        return this;
    }

    public DescriptionBuilder setPower(Supplier<String> key) {
        this.power = key;
        return this;
    }

    public DescriptionBuilder setCommand(Supplier<String> key) {
        this.command = key;
        return this;
    }

    public DescriptionBuilder setItems(Supplier<String> key) {
        this.items = key;
        return this;
    }

    public DescriptionBuilder addExtraLines(Supplier<String> key) {
        this.extraLines.add(key);
        return this;
    }

    public DescriptionBuilder setEffects(Supplier<String> key) {
        this.effects = key;
        return this;
    }

    public DescriptionBuilder setEquipments(Supplier<String> key) {
        this.equipments = key;
        return this;
    }

    public String build(){

        StringBuilder sb = new StringBuilder();

        sb.append(game.translate("werewolf.description.role", game.translate(IRole.getDeathRole()) +
                (!IRole.getDeathRole().equals(IRole.getKey()) ? game.translate("werewolf.role.thief.thief", IRole.getKey()) : "") +
                (IRole.getInfected() ? game.translate("werewolf.end.infect") : "") +
                (IRole.isSolitary() ? game.translate("werewolf.end.solitary") : "")));

        sb.append(game.translate("werewolf.description.camp",
                IRole.getCamp().getChatColor()+game.translate(IRole.getCamp().getKey())));

        sb.append(IRole.getInfected()?
                game.translate("werewolf.description.effect",game.translate("werewolf.description.werewolf"))
                :"");

        sb.append(IRole instanceof ITransformed ?
                game.translate("werewolf.description.transformed",
                        game.translate(((ITransformed) IRole).getTransformed()?
                                "werewolf.description.yes"
                                : "werewolf.description.no"))
                : "");

        if(this.description!=null){
            sb.append(game.translate("werewolf.description.description", this.description.get()));
        }

        if(this.power!=null){
            sb.append(game.translate("werewolf.description.power",this.power.get()));
        }

        if(this.effects!=null){
            sb.append(game.translate("werewolf.description.effect",this.effects.get()));
        }

        if(this.items!=null){
            sb.append(game.translate("werewolf.description.item",this.items.get()));
        }

        if(this.equipments!=null){
            sb.append(game.translate("werewolf.description.equipment",this.equipments.get()));
        }

        if(this.command!=null){
            sb.append(game.translate("werewolf.description.command",this.command.get()));
        }

        extraLines.forEach(stringSupplier -> sb.append(stringSupplier.get()));

        return game.translate("werewolf.description._") +
                sb.toString() +
                game.translate("werewolf.description._");

    }
}
