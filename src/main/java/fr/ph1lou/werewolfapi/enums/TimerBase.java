package fr.ph1lou.werewolfapi.enums;
@SuppressWarnings({"unused"})
public enum TimerBase {
    INVULNERABILITY("werewolf.menu.timers.invulnerability"),
    ROLE_DURATION("werewolf.menu.timers.role_duration"),
    WEREWOLF_LIST("werewolf.menu.timers.werewolf_list"),
    PVP("werewolf.menu.timers.pvp"),
    VOTE_BEGIN("werewolf.menu.timers.vote_begin"),
    BORDER_BEGIN("werewolf.menu.timers.border_begin"),
    DIGGING("werewolf.menu.timers.digging_end"),
    LOVER_DURATION("werewolf.menu.timers.lover_duration"),
    MODEL_DURATION("werewolf.role.wild_child.model_duration"),
    ANGEL_DURATION("werewolf.role.angel.angel_duration"),
    VOTE_WAITING("werewolf.menu.timers.vote_waiting"),
    DAY_DURATION("werewolf.menu.timers.day_duration"),
    VOTE_DURATION("werewolf.menu.timers.vote_duration"),
    RIVAL_DURATION("werewolf.role.rival.rival_duration"),
    POWER_DURATION("werewolf.menu.timers.power_duration"),
    FOX_SMELL_DURATION("werewolf.role.fox.fox_smell_duration"),
    TWIN_DURATION("werewolf.role.twin.twin_duration"),
    ANALYSE_DURATION("werewolf.role.analyst.analyse_duration"),

    WEREWOLF_CHAT_DURATION("werewolf.menu.timers.werewolf_chat_duration"),
    AUTO_RESTART_DURATION("werewolf.menu.timers.auto_restart_duration"),
    SUCCUBUS_DURATION("werewolf.role.succubus.succubus_duration"),
    CHARMER_COUNTDOWN("werewolf.role.charmer.charmer_countdown"),
    FRUIT_MERCHANT_COOL_DOWN("werewolf.role.fruit_merchant.fruit_merchant_cooldown"),
    SCAM_DELAY("werewolf.role.scammer.config.name"),
    WEREWOLF_TENEBROUS_DURATION("werewolf.role.tenebrous_werewolf.darkness_duration");

    private final String key;

    TimerBase(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

}
