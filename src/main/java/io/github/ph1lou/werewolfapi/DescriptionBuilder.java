package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.rolesattributs.Roles;
import io.github.ph1lou.werewolfapi.rolesattributs.Transformed;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class DescriptionBuilder {

    private Optional<Supplier<String>> description= Optional.empty();
    private Optional<Supplier<String>> power = Optional.empty();
    private Optional<Supplier<String>> items = Optional.empty();
    private Optional<Supplier<String>> effects = Optional.empty();
    private Optional<Supplier<String>> equipments = Optional.empty();
    private Optional<Supplier<String>> command = Optional.empty();
    private List<Supplier<String>> extraLines = new ArrayList<>();

    private final WereWolfAPI game;
    private final Roles roles;

    public DescriptionBuilder(WereWolfAPI game, Roles roles){
        this.game=game;
        this.roles=roles;
    }

    public DescriptionBuilder setDescription(Supplier<String> key){
        this.description= Optional.ofNullable(key);
        return this;
    }

    public DescriptionBuilder setPower(Supplier<String> key) {
        this.power = Optional.ofNullable(key);
        return this;
    }

    public DescriptionBuilder setCommand(Supplier<String> key) {
        this.command = Optional.ofNullable(key);
        return this;
    }

    public DescriptionBuilder setItems(Supplier<String> key) {
        this.items = Optional.ofNullable(key);
        return this;
    }

    public DescriptionBuilder addExtraLines(Supplier<String> key) {
        this.extraLines.add(key);
        return this;
    }

    public DescriptionBuilder setEffects(Supplier<String> key) {
        this.effects = Optional.ofNullable(key);
        return this;
    }

    public DescriptionBuilder setEquipments(Supplier<String> key) {
        this.equipments = Optional.ofNullable(key);
        return this;
    }

    public String build(){

        StringBuilder sb = new StringBuilder();

        sb.append(game.translate("werewolf.description.role", game.translate(roles.getDeathRole()) +
                (!roles.getDeathRole().equals(roles.getKey()) ? game.translate("werewolf.role.thief.thief", roles.getKey()) : "") +
                (roles.getInfected() ? game.translate("werewolf.end.infect") : "") +
                (roles.isSolitary() ? game.translate("werewolf.end.solitary") : "")));

        sb.append(game.translate("werewolf.description.camp",
                roles.getCamp().getChatColor()+game.translate(roles.getCamp().getKey())));

        sb.append(roles.getInfected()?
                game.translate("werewolf.description.effect",game.translate("werewolf.description.werewolf"))
                :"");

        sb.append(roles instanceof Transformed ?
                game.translate("werewolf.description.transformed",
                        game.translate(((Transformed)roles).getTransformed()?
                                "werewolf.description.yes"
                                : "werewolf.description.no"))
                : "");

        description.ifPresent(s -> sb.append(game.translate("werewolf.description.description", s.get())));

        power.ifPresent(s -> sb.append(game.translate("werewolf.description.power",s.get())));

        effects.ifPresent(s -> sb.append(game.translate("werewolf.description.effect",s.get())));

        items.ifPresent(s -> sb.append(game.translate("werewolf.description.item",s.get())));

        equipments.ifPresent(s -> sb.append(game.translate("werewolf.description.equipment",s.get())));

        command.ifPresent(s -> sb.append(game.translate("werewolf.description.command",s.get())));

        extraLines.forEach(stringSupplier -> sb.append(stringSupplier.get()));

        return game.translate("werewolf.description._") +
                sb.toString() +
                game.translate("werewolf.description._");

    }
}
