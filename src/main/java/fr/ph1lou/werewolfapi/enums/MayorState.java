package fr.ph1lou.werewolfapi.enums;

public enum MayorState {
    DOCTOR("werewolf.elections.election.regime.doctor.name",
            "werewolf.elections.election.regime.doctor.description"),
    FARMER("werewolf.elections.election.regime.farmer.name",
            "werewolf.elections.election.regime.farmer.description"),
    UNDERTAKER("werewolf.elections.election.regime.undertaker.name",
            "werewolf.elections.election.regime.undertaker.description"),
    BLACK_SMITH("werewolf.elections.election.regime.black_smith.name",
            "werewolf.elections.election.regime.black_smith.description");

    private final String key;
    private final String description;

    MayorState(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }
}
