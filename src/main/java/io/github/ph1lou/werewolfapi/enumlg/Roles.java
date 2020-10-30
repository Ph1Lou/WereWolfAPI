package io.github.ph1lou.werewolfapi.enumlg;

public enum Roles {

    CUPID("werewolf.role.cupid.display"),
    WEREWOLF("werewolf.role.werewolf.display"),
    INFECT("werewolf.role.infect_father_of_the_wolves.display"),
    FALSIFIER_WEREWOLF("werewolf.role.falsifier_werewolf.display"),
    MISCHIEVOUS_WEREWOLF("werewolf.role.mischievous_werewolf.display"),
    NAUGHTY_LITTLE_WOLF("werewolf.role.naughty_little_wolf.display"),
    THIEF("werewolf.role.thief.display"),
    WILD_CHILD("werewolf.role.wild_child.display"),
    WITCH("werewolf.role.witch.display"),
    LITTLE_GIRL("werewolf.role.little_girl.display"),
    PROTECTOR("werewolf.role.protector.display"),
    FOX("werewolf.role.fox.display"),
    BEAR_TRAINER("werewolf.role.bear_trainer.display"),
    CHATTY_SEER("werewolf.role.chatty_seer.display"),
    SEER("werewolf.role.seer.display"),
    TROUBLEMAKER("werewolf.role.troublemaker.display"),
    SISTER("werewolf.role.sister.display"),
    ELDER("werewolf.role.elder.display"),
    RAVEN("werewolf.role.raven.display"),
    VILLAGER("werewolf.role.villager.display"),
    DETECTIVE("werewolf.role.detective.display"),
    MINER("werewolf.role.miner.display"),
    CITIZEN("werewolf.role.citizen.display"),
    SIAMESE_TWIN("werewolf.role.siamese_twin.display"),
    COMEDIAN("werewolf.role.comedian.display"),
    TRAPPER("werewolf.role.trapper.display"),
    ANGEL("werewolf.role.angel.display"),
    GUARDIAN_ANGEL("werewolf.role.guardian_angel.display"),
    FALLEN_ANGEL("werewolf.role.fallen_angel.display"),
    AMNESIAC_WEREWOLF("werewolf.role.amnesiac_werewolf.display"),
    WHITE_WEREWOLF("werewolf.role.white_werewolf.display"),
    ASSASSIN("werewolf.role.assassin.display"),
    SERIAL_KILLER("werewolf.role.serial_killer.display"),
    SUCCUBUS("werewolf.role.succubus.display"),
    LIBRARIAN("werewolf.role.librarian.display"),
    FLUTE_PLAYER("werewolf.role.flute_player.display");

    private final String key;

    Roles(String key) {
        this.key = key;
    }


    public String getKey() {
        return key;
    }
}