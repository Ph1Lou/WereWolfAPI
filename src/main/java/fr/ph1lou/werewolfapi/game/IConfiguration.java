package fr.ph1lou.werewolfapi.game;

/**
 * @author Ph1Lou
 */

@SuppressWarnings("unused")

public interface IConfiguration extends IStorageConfiguration {

    int getStrengthRate();

    void setStrengthRate(int strengthRate);

    int getLimitProtectionIron();

    void setLimitProtectionIron(int limitProtectionIron);

    int getLimitProtectionDiamond();

    void setLimitProtectionDiamond(int limitProtectionDiamond);

    int getLimitSharpnessDiamond();

    void setLimitSharpnessDiamond(int limitSharpnessDiamond);

    int getLimitSharpnessIron();

    void setLimitSharpnessIron(int limitSharpnessIron);

    int getLimitPowerBow();

    void setLimitPowerBow(int limitPowerBow);

    int getLimitKnockBack();

    void setLimitKnockBack(int limitKnockBack);

    int getLimitPunch();

    void setLimitPunch(int limitPunch);

    int getGoldenAppleParticles();

    void setGoldenAppleParticles(int goldenAppleParticles);

    int getResistanceRate();

    void setResistanceRate(int resistanceRate);

    int getBorderMax();

    void setBorderMax(int borderMax);

    int getBorderMin();

    void setBorderMin(int borderMin);

    double getBorderSpeed();

    void setBorderSpeed(double seed);

    int getLimitDepthStrider();

    void setLimitDepthStrider(int limitDepthRider);

    /**
     * return true if the whitelist is on
     *
     * @return boolean
     */

    boolean isWhiteList();

    /**
     * change the status of the whitelist
     *
     * @param whiteList the desired status
     */

    void setWhiteList(boolean whiteList);

    /**
     * return the maximum of player accepted in the game
     *
     * @return int
     */

    int getPlayerMax();

    /**
     * Set the maximum number of players
     *
     * @param playerMax maximum number of players
     */

    void setPlayerMax(int playerMax);

    /**
     * return the spectator Mode of the game (0 : disable, 1 : for death players, 2: for all players)
     *
     * @return int
     */

    int getSpectatorMode();

    /**
     * change the status of the Spectator Mode
     *
     * @param spectatorMode the desired status (0 : disable, 1 : for death players, 2: for all players)
     */

    void setSpectatorMode(int spectatorMode);

    String getTrollKey();

    void setTrollKey(String trollKey);

    boolean isKnockBackForInvisibleRoleOnly();

    void setKnockBackForInvisibleRoleOnly(boolean knockBackMode);

    boolean isMeetUp();

    void setMeetUp(boolean meetUp);
}
