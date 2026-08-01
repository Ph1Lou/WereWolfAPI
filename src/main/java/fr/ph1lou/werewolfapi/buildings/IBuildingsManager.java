package fr.ph1lou.werewolfapi.buildings;

import fr.ph1lou.werewolfapi.vote.IUrnVoteManager;
import org.bukkit.Location;

import java.util.List;

public interface IBuildingsManager {

    List<? extends IVoteOffice> getVoteOffices();

    List<? extends ICouncilChamber> getCouncilChambers();

    List<? extends ISanctuary> getSanctuaries();

    IUrnVoteManager getUrnVoteManager();

    IVoteOffice getVoteOffice(Location location);

    boolean isDisabled(IBuilding office);

    boolean isProtected(Location location);

    void revealBuildings();
}
