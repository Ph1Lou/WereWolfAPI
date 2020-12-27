package io.github.ph1lou.werewolfapi.enums;

public enum ConfigsBase {

    VICTORY_LOVERS("werewolf.menu.global.victory_couple"),
    CHAT("werewolf.menu.global.chat"),
    SHOW_ROLE_TO_DEATH("werewolf.menu.global.show_role_to_death"),
    SHOW_ROLE_CATEGORY_TO_DEATH("werewolf.menu.global.show_role_category_to_death"),
    HIDE_COMPOSITION("werewolf.menu.global.hide_composition"),
    VOTE("werewolf.menu.global.vote"),
    EVENT_SEER_DEATH("werewolf.menu.global.event_seer_death"),
    AUTO_REZ_WITCH("werewolf.menu.global.auto_rez_witch"),
    POLYGAMY("werewolf.menu.global.polygamy"),
    SEER_EVERY_OTHER_DAY("werewolf.menu.global.seer_every_other_day"),
    PROXIMITY_CHAT("werewolf.menu.global.proximity_chat"),
    SWEET_ANGEL("werewolf.menu.global.sweet_angel"),
    RED_NAME_TAG("werewolf.menu.global.red_name_tag"),
    WEREWOLF_CHAT("werewolf.menu.global.werewolf_chat"),
    DOUBLE_TROLL("werewolf.menu.global.double_troll");

    private final String key;

    ConfigsBase(String key) {
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }

}