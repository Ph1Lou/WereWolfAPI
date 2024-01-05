package fr.ph1lou.werewolfapi.enums;

@SuppressWarnings({"unused"})
public enum RoleAttribute {
    VILLAGER("werewolf.attributes.villager"),
    MINOR_INFORMATION("werewolf.attributes.minor_information"),
    INFORMATION("werewolf.attributes.information"),
    WEREWOLF("werewolf.attributes.werewolf"),
    HYBRID("werewolf.attributes.hybrid"),
    NEUTRAL("werewolf.attributes.neutral");

    private final String key;

    RoleAttribute(String key){
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
