package fr.ph1lou.werewolfapi.role.interfaces;

/**
 * methods to handling camp
 */
public interface ICamp {

    boolean isWereWolf();

    boolean isInfected();

    boolean isTransformedToNeutral();

    boolean isTransformedToVillager();

    void setTransformedToNeutral(boolean neutral);

    void setTransformedToVillager(boolean villager);

    boolean isNeutral();

    void setInfected();

    void setSolitary(boolean solitary);

    boolean isSolitary();
}
