package io.github.ph1lou.werewolfapi.enums;

public enum ConfigsBase {

    VICTORY_LOVERS("werewolf.menu.global.victory_couple"),
    CHAT("werewolf.menu.global.chat"),
    SHOW_ROLE_TO_DEATH("werewolf.menu.global.show_role_to_death"),
    SHOW_ROLE_CATEGORY_TO_DEATH("werewolf.menu.global.show_role_category_to_death"),
    HIDE_COMPOSITION("werewolf.menu.global.hide_composition"),
    VOTE("werewolf.menu.global.vote"),
    AUTO_REZ_WITCH("werewolf.menu.global.auto_rez_witch"),
    SEER_EVERY_OTHER_DAY("werewolf.menu.global.seer_every_other_day"),
    DETECTIVE_EVERY_OTHER_DAY("werewolf.menu.global.detective_every_other_day"),
    PROXIMITY_CHAT("werewolf.menu.global.proximity_chat"),
    SWEET_ANGEL("werewolf.menu.global.sweet_angel"),
    RED_NAME_TAG("werewolf.menu.global.red_name_tag"),
    WEREWOLF_CHAT("werewolf.menu.global.werewolf_chat"),
    EVIL_THIEF("werewolf.menu.global.evil_thief"),
    DOUBLE_TROLL("werewolf.menu.global.double_troll"),
    HIDE_EVENTS("werewolf.menu.global.hide_events"),
    HIDE_SCENARIOS("werewolf.menu.global.hide_scenarios"),
    LONE_WOLF("werewolf.menu.global.lone_wolf");

    private final String key;

    ConfigsBase(String key) {
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }

}