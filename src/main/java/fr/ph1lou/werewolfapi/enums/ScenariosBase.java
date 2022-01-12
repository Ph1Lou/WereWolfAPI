package fr.ph1lou.werewolfapi.enums;

public enum ScenariosBase {
    VANILLA_PLUS("werewolf.menu.scenarios.vanilla_plus"),
    ROD_LESS("werewolf.menu.scenarios.rod_less"),
    HORSE_LESS("werewolf.menu.scenarios.horse_less"),
    FIRE_LESS("werewolf.menu.scenarios.fire_less"),
    CUT_CLEAN("werewolf.menu.scenarios.cut_clean"),
    DIAMOND_LIMIT("werewolf.menu.scenarios.diamond_limit"),
    FAST_SMELTING("werewolf.menu.scenarios.fast_smelting"),
    HASTEY_BOYS("werewolf.menu.scenarios.hastey_boys"),
    NO_FALL("werewolf.menu.scenarios.no_fall"),
    NO_EGG_SNOWBALL("werewolf.menu.scenarios.no_egg_snowball"),
    NO_POISON("werewolf.menu.scenarios.no_poison"),
    COMPASS_MIDDLE("werewolf.menu.scenarios.compass_middle"),
    XP_BOOST("werewolf.menu.scenarios.xp_boost"),
    COMPASS_TARGET_LAST_DEATH("werewolf.menu.scenarios.compass_target_last_death"),
    NO_CLEAN_UP("werewolf.menu.scenarios.no_clean_up"),
    NO_NAME_TAG("werewolf.menu.scenarios.no_name_tag"),
    CAT_EYES("werewolf.menu.scenarios.cat_eyes"),
    NO_FIRE_WEAPONS("werewolf.menu.scenarios.no_fire_weapons"),
    TIMBER("werewolf.menu.scenarios.timber"),
    SLOW_BOW("werewolf.menu.scenarios.slow_bow"),
    NO_NETHER("werewolf.menu.scenarios.no_nether"),
    NO_END("werewolf.menu.scenarios.no_end"),
    DOUBLE_JUMP("werewolf.menu.scenarios.double_jump");

    public String getKey() {
        return key;
    }

    private final String key;

    ScenariosBase(String key) {
        this.key=key;
    }


}