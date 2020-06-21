package io.github.ph1lou.pluginlgapi.enumlg;

public enum ToolLG {

	VICTORY_COUPLE(true, "werewolf.menu.global.victory_couple"),
	CHAT(true, "werewolf.menu.global.chat"),
	SHOW_ROLE_TO_DEATH(true, "werewolf.menu.global.show_role_to_death"),
	HIDE_COMPOSITION(false, "werewolf.menu.global.hide_composition"),
	VOTE(true, "werewolf.menu.global.vote"),
	EVENT_SEER_DEATH(true, "werewolf.menu.global.event_seer_death"),
	AUTO_REZ_WITCH(false, "werewolf.menu.global.auto_rez_witch"),
	AUTO_REZ_INFECT(false, "werewolf.menu.global.auto_rez_infect"),
	POLYGAMY(false, "werewolf.menu.global.polygamy"),
	COMPASS_MIDDLE(false, "werewolf.menu.global.compass_middle"),
	SEER_EVERY_OTHER_DAY(false, "werewolf.menu.global.seer_every_other_day"),
	PROXIMITY_CHAT(false,"werewolf.menu.global.proximity_chat"),
	RED_NAME_TAG(true, "werewolf.menu.global.red_name_tag");
	
	
	private final Boolean value;
	private final String key;

	ToolLG(Boolean value, String key) {
		this.value = value;
		this.key = key;
	}

	public Boolean getValue() {
		return this.value;
	}
	
	public String getKey(){
		return this.key;
	}

}


