package io.github.ph1lou.werewolfapi.enumlg;

public enum ConfigsBase {

    VICTORY_LOVERS("werewolf.menu.global.victory_couple"),
    CHAT("werewolf.menu.global.chat"),
    SHOW_ROLE_TO_DEATH("werewolf.menu.global.show_role_to_death"),
    HIDE_COMPOSITION("werewolf.menu.global.hide_composition"),
    VOTE("werewolf.menu.global.vote"),
    EVENT_SEER_DEATH("werewolf.menu.global.event_seer_death"),
    AUTO_REZ_WITCH("werewolf.menu.global.auto_rez_witch"),
    AUTO_REZ_INFECT("werewolf.menu.global.auto_rez_infect"),
    POLYGAMY("werewolf.menu.global.polygamy"),
    COMPASS_MIDDLE("werewolf.menu.global.compass_middle"),
    SEER_EVERY_OTHER_DAY("werewolf.menu.global.seer_every_other_day"),
    PROXIMITY_CHAT("werewolf.menu.global.proximity_chat"),
    SWEET_ANGEL("werewolf.menu.global.sweet_angel"),
    RED_NAME_TAG("werewolf.menu.global.red_name_tag");


    private final String key;

    ConfigsBase(String key) {
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }

}