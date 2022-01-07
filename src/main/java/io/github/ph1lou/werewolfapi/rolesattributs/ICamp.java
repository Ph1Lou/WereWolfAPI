package io.github.ph1lou.werewolfapi.rolesattributs;

/**
 * methods to handling camp
 */
public interface ICamp {

    boolean isWereWolf();

    boolean isInfected();

    boolean isTransformedToNeutral();

    void setTransformedToNeutral(boolean neutral);

    boolean isNeutral();

    void setInfected();

    void setSolitary(boolean solitary);

    boolean isSolitary();
}
