package fr.ph1lou.werewolfapi.role.utils;

import fr.ph1lou.werewolfapi.annotations.Role;
import fr.ph1lou.werewolfapi.basekeys.ConfigBase;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.player.utils.Formatter;
import fr.ph1lou.werewolfapi.role.interfaces.IRole;
import fr.ph1lou.werewolfapi.role.interfaces.ITransformed;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class DescriptionBuilder {

    private final List<String> extraLines = new ArrayList<>();
    private final WereWolfAPI game;
    private final IRole role;
    private String description;
    private String power;
    private String items;
    private String effects;
    private String command;

    public DescriptionBuilder(WereWolfAPI game, IRole role) {
        this.game = game;
        this.role = role;
    }

    public DescriptionBuilder setDescription(String key) {
        this.description = key;
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

    public DescriptionBuilder addExtraLines(Supplier<String> supplier, boolean condition) {
        if (condition) {
            this.extraLines.add(supplier.get());
        }
        return this;
    }

    public DescriptionBuilder setEffects(String key) {
        this.effects = key;
        return this;
    }

    public String build() {

        StringBuilder sb = new StringBuilder();

        Role roleClass = role.getClass().getAnnotation(Role.class);

        sb.append(this.game.translate("werewolf.description.role", Formatter.format("&role&", this.game.translate(this.role.getPlayerWW().getDeathRole()) +
                                                                                              (!this.role.getPlayerWW().getDeathRole().equals(this.role.getKey()) ? this.game.translate("werewolf.roles.thief.thief",
                                                                                                      Formatter.format("&role&", this.game.translate(this.role.getKey()))) : "") +
                                                                                              (this.role.isInfected() ? this.game.translate("werewolf.end.infect") : "") +
                                                                                              (this.role.isSolitary() ? this.game.translate("werewolf.end.solitary") : ""))));

        sb.append(this.game.translate("werewolf.description.camp",
                Formatter.format("&camp&", this.game.translate(this.role.getCamp().getKey()))));

        sb.append(this.role instanceof ITransformed ?
                this.game.translate("werewolf.description.transformed",
                        Formatter.format("&on&", this.game.translate(((ITransformed) this.role).isTransformed() ?
                                "werewolf.description.yes"
                                : "werewolf.description.no")))
                : "");

        sb.append(this.game.translate("werewolf.description.aura", Formatter.format("&aura&",
                game.translate(this.role.getAura().getKey()))));

        if (!this.role.isAbilityEnabled()) {
            sb.append(game.translate("werewolf.description.disable"));
        } else {

            if (this.description != null) {
                sb.append(this.game.translate("werewolf.description.description",
                        Formatter.format("&text&", this.description)));
            }

            if (this.role.isInfected() && this.effects != null && !this.effects.equals(this.game.translate("werewolf.description.werewolf"))) {
                sb.append(this.game.translate("werewolf.description.effect",
                        Formatter.format("&effect&", this.game.translate("werewolf.description.werewolf"))));
            }

            if (this.power != null) {
                sb.append(this.game.translate("werewolf.description.power",
                        Formatter.format("&on&", this.power)));
            }

            if (this.effects != null) {
                sb.append(this.game.translate("werewolf.description.effect",
                        Formatter.format("&effect&", this.effects)));
            }

            if (this.items != null) {
                sb.append(this.game.translate("werewolf.description.item",
                        Formatter.format("&items&", this.items)));
            }

            if (this.command != null) {
                sb.append(this.game.translate("werewolf.description.command",
                        Formatter.format("&command&", this.command)));
            }

            StringBuilder equipments = new StringBuilder();
            if (roleClass.powerModifier() != 0) {
                equipments.append(game.translate("werewolf.description.equipments_attribut.power",
                                Formatter.number(roleClass.powerModifier())))
                        .append("\n");

            }
            if (roleClass.sharpnessIronModifier() != 0) {
                equipments.append(game.translate("werewolf.description.equipments_attribut.sharpness_iron",
                                Formatter.number(roleClass.sharpnessIronModifier())))
                        .append("\n");
            }

            if (roleClass.sharpnessDiamondModifier() != 0) {
                equipments.append(game.translate("werewolf.description.equipments_attribut.sharpness_diamond",
                                Formatter.number(roleClass.sharpnessDiamondModifier())))
                        .append("\n");
            }
            if (roleClass.protectionIronModifier() != 0) {
                equipments.append(game.translate("werewolf.description.equipments_attribut.protection_iron",
                                Formatter.number(roleClass.protectionIronModifier())))
                        .append("\n");
            }
            if (roleClass.protectionDiamondModifier() != 0) {
                equipments.append(game.translate("werewolf.description.equipments_attribut.protection_diamond",
                                Formatter.number(roleClass.protectionDiamondModifier())))
                        .append("\n");
            }

            if (equipments.length() > 0) {
                sb.append(this.game.translate("werewolf.description.equipment",
                        Formatter.format("&equipment&", equipments.toString())));
            }

            this.extraLines.forEach(s -> sb.append(s).append("\n"));
        }

        if (game.getConfig().isConfigActive(ConfigBase.WEREWOLF_HOWLING) && this.role.isWereWolf()) {
            sb.append(game.translate("werewolf.configurations.werewolf_howling.can_use")).append("\n");
        }

        return this.game.translate("werewolf.description._") + '\n' +
               sb +
               this.game.translate("werewolf.description._");

    }
}
