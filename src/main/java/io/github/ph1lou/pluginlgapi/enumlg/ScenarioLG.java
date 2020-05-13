package io.github.ph1lou.pluginlgapi.enumlg;

public enum ScenarioLG {
    VANILLA_PLUS(true,"werewolf.menu.scenarios.vanilla_plus"),
    ROD_LESS(true,"werewolf.menu.scenarios.rod_less"),
    HORSE_LESS(true,"werewolf.menu.scenarios.horse_less"),
    FIRE_LESS(true,"werewolf.menu.scenarios.fire_less"),
    CUT_CLEAN(true,"werewolf.menu.scenarios.cut_clean"),
    DIAMOND_LIMIT(true,"werewolf.menu.scenarios.diamond_limit"),
    FAST_SMELTING(true,"werewolf.menu.scenarios.fast_smelting"),
    HASTEY_BOYS(true,"werewolf.menu.scenarios.hastey_boys"),
    NO_FALL(false,"werewolf.menu.scenarios.no_fall"),
    NO_EGG_SNOWBALL(true,"werewolf.menu.scenarios.no_egg_snowball"),
    NO_POISON(true,"werewolf.menu.scenarios.no_poison"),
    XP_BOOST(true,"werewolf.menu.scenarios.xp_boost"),
    COMPASS_TARGET_LAST_DEATH(false,"werewolf.menu.scenarios.compass_target_last_death"),
    NO_CLEAN_UP(true,"werewolf.menu.scenarios.no_clean_up"),
    NO_NAME_TAG(false,"werewolf.menu.scenarios.no_name_tag"),
    CAT_EYES(true,"werewolf.menu.scenarios.cat_eyes"),
    NO_FIRE_WEAPONS(true,"werewolf.menu.scenarios.no_fire_weapons"),
    TIMBER(false,"werewolf.menu.scenarios.timber"),
    SLOW_BOW(false,"werewolf.menu.scenarios.slow_bow");

    private final Boolean value;
    private final String key;

    ScenarioLG(Boolean value, String key) {
        this.value = value;
        this.key=key;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String getKey(){
        return this.key;
    }

}



