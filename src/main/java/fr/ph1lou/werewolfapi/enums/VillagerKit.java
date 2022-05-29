package fr.ph1lou.werewolfapi.enums;
@SuppressWarnings({"unused"})
public enum VillagerKit {
    MINER("werewolf.roles.villager.miner","werewolf.role.villager.miner_desc"),
    BLACK_SMITH("werewolf.roles.villager.black_smith","werewolf.role.villager.black_smith_desc"),
    BOOK_SELLER("werewolf.roles.villager.book_seller","werewolf.role.villager.book_seller_desc"),
    GOLEM("werewolf.roles.villager.golem","werewolf.role.villager.golem_desc"),
    ARCHER("werewolf.roles.villager.archer","werewolf.role.villager.archer_desc"),
    PRIEST("werewolf.roles.villager.priest","werewolf.role.villager.priest_desc");

    private final String key;

    private final String description;

    VillagerKit(String key, String description){
        this.key=key;
        this.description=description;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

}
