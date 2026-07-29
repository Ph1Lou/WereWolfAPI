package fr.ph1lou.werewolfapi.buildings;

import java.util.List;

public interface IBuildingsManager {

    List<? extends IVoteOffice> getVoteOffices();

    List<? extends ICouncilChamber> getCouncilChambers();

    List<? extends ISanctuary> getSanctuaries();
}
