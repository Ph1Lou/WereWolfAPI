package io.github.ph1lou.werewolfapi.enums;

public enum TimerBase {
    INVULNERABILITY("werewolf.menu.timers.invulnerability"),
    ROLE_DURATION("werewolf.menu.timers.role_duration"),
    WEREWOLF_LIST("werewolf.menu.timers.werewolf_list"),
    PVP("werewolf.menu.timers.pvp"),
    VOTE_BEGIN("werewolf.menu.timers.vote_begin"),
    BORDER_BEGIN("werewolf.menu.timers.border_begin"),
    DIGGING("werewolf.menu.timers.digging_end"),
    LOVER_DURATION("werewolf.menu.timers.lover_duration"),
    MODEL_DURATION("werewolf.menu.timers.model_duration"),
    ANGEL_DURATION("werewolf.menu.timers.angel_duration"),
    CITIZEN_DURATION("werewolf.menu.timers.citizen_duration"),
    DAY_DURATION("werewolf.menu.timers.day_duration"),
    VOTE_DURATION("werewolf.menu.timers.vote_duration"),
    RIVAL_DURATION("werewolf.menu.timers.rival_duration"),
    POWER_DURATION("werewolf.menu.timers.power_duration"),
    FOX_SMELL_DURATION("werewolf.menu.timers.fox_smell_duration"),
    TWIN_DURATION("werewolf.menu.timers.twin_duration"),
    ANALYSE_DURATION("werewolf.menu.timers.analyse_duration"),

    WEREWOLF_CHAT_DURATION("werewolf.menu.timers.werewolf_chat_duration"),
    AUTO_RESTART_DURATION("werewolf.menu.timers.auto_restart_duration"),
    SUCCUBUS_DURATION("werewolf.menu.timers.succubus_duration"),
    CHARMER_COUNTDOWN("werewolf.menu.timers.charmer_countdown");

    private final String key;

    TimerBase(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

}
