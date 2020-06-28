package io.github.ph1lou.werewolfapi.enumlg;

public enum TimerLG {
	INVULNERABILITY(30, "werewolf.menu.timers.invulnerability"),
	ROLE_DURATION(1200, "werewolf.menu.timers.role_duration"),
	WEREWOLF_LIST(600, "werewolf.menu.timers.werewolf_list"),
	PVP(1500, "werewolf.menu.timers.pvp"),
	VOTE_BEGIN(2400, "werewolf.menu.timers.vote_begin"),
    BORDER_BEGIN(3600, "werewolf.menu.timers.border_begin"),
    DIGGING(4200, "werewolf.menu.timers.digging_end"),
    LOVER_DURATION(240, "werewolf.menu.timers.lover_duration"),
    MODEL_DURATION(240, "werewolf.menu.timers.model_duration"),
    ANGEL_DURATION(240, "werewolf.menu.timers.angel_duration"),
    CITIZEN_DURATION(60, "werewolf.menu.timers.citizen_duration"),
    DAY_DURATION(300, "werewolf.menu.timers.day_duration"),
    VOTE_DURATION(180, "werewolf.menu.timers.vote_duration"),
    POWER_DURATION(240, "werewolf.menu.timers.power_duration"),
    BORDER_DURATION(280, "werewolf.menu.timers.border_duration"),
    FOX_SMELL_DURATION(120, "werewolf.menu.timers.fox_smell_duration"),
    SUCCUBUS_DURATION(180, "werewolf.menu.timers.succubus_duration");

    private final int value;
    private final String key;
    
    TimerLG(int value, String key) {
        this.value = value;
        this.key = key;
    }

    public int getValue() {
        return this.value;
    }
    
    public String getKey() {
        return this.key;
    }

}



