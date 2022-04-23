package fr.ph1lou.werewolfapi.enums;

@SuppressWarnings({"unused"})
public enum RolesBase {

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
    IMITATOR("werewolf.role.imitator.display"),
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
    FLUTE_PLAYER("werewolf.role.flute_player.display"),
    STUD("werewolf.role.stud.display"),
    MYSTICAL_WEREWOLF("werewolf.role.mystical_werewolf.display"),
    VILLAGE_IDIOT("werewolf.role.village_idiot.display"),
    PRIESTESS("werewolf.role.priestess.display"),
    ORACLE("werewolf.role.oracle.display"),
    RIVAL("werewolf.role.rival.display"),
    WOLF_DOG("werewolf.role.wolf_dog.display"),
    GRIMY_WEREWOLF("werewolf.role.grimy_werewolf.display"),
    GUARD("werewolf.role.guard.display"),
    HUNTER("werewolf.role.hunter.display"),
    BIG_BAD_WEREWOLF("werewolf.role.big_bad_werewolf.display"),
    AVENGER_WEREWOLF("werewolf.role.avenger_werewolf.display"),
    CHARMER("werewolf.role.charmer.display"),
    SHAMAN("werewolf.role.shaman.display"),
    FEARFUL_WEREWOLF("werewolf.role.fearful_werewolf.display"),
    HERMIT("werewolf.role.hermit.display"),
    ALPHA_WEREWOLF("werewolf.role.alpha_werewolf.display"),
    WILL_O_THE_WISP("werewolf.role.will_o_the_wisp.display"),
    HOWLING_WEREWOLF("werewolf.role.howling_werewolf.display"),
    TWIN("werewolf.role.twin.display"),
    ANALYST("werewolf.role.analyst.display"),
    WISE_ELDER("werewolf.role.wise_elder.display"),
    SERVITOR("werewolf.role.servitor.display"),
    FRUIT_MERCHANT("werewolf.role.fruit_merchant.display"),
    DRUID("werewolf.role.druid.display"),
    SCAMMER("werewolf.role.scammer.display"),
    OCCULTIST("werewolf.role.occultist.display"),
    TENEBROUS_WEREWOLF("werewolf.role.tenebrous_werewolf.display"),
    GRAVEDIGGER("werewolf.role.gravedigger.display"),
    THUG("werewolf.role.thug.display"),
    BARBARIAN("werewolf.role.barbarian.display"),
    NECROMANCER("werewolf.role.necromancer.display"),
    DEVOTED_SERVANT("werewolf.role.devoted_servant.display"),
    STORY_TELLER("werewolf.role.story_teller.display"),
    SPY("werewolf.role.spy.display"),
    BENEFACTOR("werewolf.role.benefactor.display"),
    RABBIT("werewolf.role.rabbit.display");

    private final String key;

    RolesBase(String key) {
        this.key = key;
    }


    public String getKey() {
        return key;
    }
}