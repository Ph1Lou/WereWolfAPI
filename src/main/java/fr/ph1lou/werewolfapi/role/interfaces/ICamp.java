package fr.ph1lou.werewolfapi.role.interfaces;

/**
 * methods to handling camp
 */
public interface ICamp {

    boolean isWereWolf();

    boolean isInfected();

    /**
     * this method can create errors
     */
    void setInfected(boolean infected);

    boolean isTransformedToNeutral();

    void setTransformedToNeutral(boolean neutral);

    boolean isTransformedToVillager();

    void setTransformedToVillager(boolean villager);

    boolean isNeutral();

    void setInfected();

    boolean isSolitary();

    void setSolitary(boolean solitary);
}
