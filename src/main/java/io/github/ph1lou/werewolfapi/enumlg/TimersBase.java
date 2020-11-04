package io.github.ph1lou.werewolfapi.enumlg;

public enum TimersBase {
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
    POWER_DURATION("werewolf.menu.timers.power_duration"),
    BORDER_DURATION("werewolf.menu.timers.border_duration"),
    FOX_SMELL_DURATION("werewolf.menu.timers.fox_smell_duration"),
    SUCCUBUS_DURATION("werewolf.menu.timers.succubus_duration");

    private final String key;

    TimersBase(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

}
