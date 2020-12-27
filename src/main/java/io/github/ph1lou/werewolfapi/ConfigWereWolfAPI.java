package io.github.ph1lou.werewolfapi;

/**
 * @author Ph1Lou
 */

@SuppressWarnings("unused")

public interface ConfigWereWolfAPI {

     int getDiamondLimit();

     void setDiamondLimit(int diamond_limit);

     int getStrengthRate();

     void setStrengthRate(int strengthRate);

     int getPlayerRequiredVoteEnd();

     void setPlayerRequiredVoteEnd(int player_required_before_voting_ends);

     int getPearlRate() ;

     void setPearlRate(int pearlRate);

     int getFlintRate() ;

     void setFlintRate(int flintRate) ;

     int getAppleRate() ;

     void setAppleRate(int appleRate);

     int getXpBoost();

     void setXpBoost(int xpBoost);

     int getLimitProtectionIron() ;

     void setLimitProtectionIron(int limitProtectionIron);

     int getLimitProtectionDiamond() ;

     void setLimitProtectionDiamond(int limitProtectionDiamond);

     int getLimitSharpnessDiamond();

     void setLimitSharpnessDiamond(int limitSharpnessDiamond) ;

     int getLimitSharpnessIron();

     void setLimitSharpnessIron(int limitSharpnessIron);

     int getLimitPowerBow() ;

     void setLimitPowerBow(int limitPowerBow);

     int getLimitKnockBack() ;

     void setLimitKnockBack(int limitKnockBack);

     int getLimitPunch() ;

     void setLimitPunch(int limitPunch);

     int getUseOfFlair() ;

     void setUseOfFlair(int useOfFlair);

     int getGoldenAppleParticles() ;

     void setGoldenAppleParticles(int goldenAppleParticles);

     int getDistanceBearTrainer();

     void setDistanceBearTrainer(int distanceBearTrainer);

     int getDistanceFox();

     void setDistanceFox(int distanceFox);

     int getResistanceRate() ;

     void setResistanceRate(int resistanceRate);

     boolean isTrollSV();

     void setTrollSV(boolean trollSV);

     int getDistanceSuccubus();

     void setDistanceSuccubus(int distanceSuccubus) ;

     int getBorderMax();

     void setBorderMax(int borderMax);

     int getBorderMin();

     void setBorderMin(int borderMin);

     int getDistanceAmnesiacLovers();

     void setDistanceAmnesiacLovers(int distanceAmnesiacLovers);

     int getTimerValue(String key);

     boolean isConfigActive(String key);

     int getRoleCount(String key);

     boolean isScenarioActive(String key);

     double getBorderSpeed();

     void setBorderSpeed(double seed);

     void switchConfigValue(String key);

     void switchScenarioValue(String key);

     void removeOneRole(String key);

     void addOneRole(String key);

     void setRole(String key, int value);

     void decreaseTimer(String key);

     void moveTimer(String key, int value);

     int getAmnesiacLoverSize();

     void setConfig(String key,boolean enable);

     void setScenario(String key,boolean enable);

     void setAmnesiacLoverSize(int amnesiacLoverSize);

     int getCursedLoverSize();

     void setCursedLoverSize(int cursedLoverSize);

     int getLoverSize();

     void setLoverSize(int loverSize);

     int getLimitDepthStrider();

     void setTimerValue(String key, int value);

     void setLimitDepthStrider(int limitDepthRider);

     /**
      * return true if the whitelist is on
      * @return boolean
      */

     boolean isWhiteList();

     /**
      * change the status of the whitelist
      * @param whiteList the desired status
      */

     void setWhiteList(boolean whiteList);

     /**
      * return the maximum of player accepted in the game
      * @return int
      */

     int getPlayerMax();

     /**
      * Set the maximum number of players
      * @param playerMax maximum number of players

      */

     void setPlayerMax(int playerMax);

     /**
      * return the spectator Mode of the game (0 : disable, 1 : for death players, 2: for all players)
      * @return int
      */

     int getSpectatorMode();

     /**
      * change the status of the Spectator Mode
      * @param spectatorMode the desired status (0 : disable, 1 : for death players, 2: for all players)
      */

     void setSpectatorMode(int spectatorMode);


     String getTrollKey();


     void setTrollKey(String trollKey);

     int getKnockBackMode();

     void setKnockBackMode(int knockBackMode);

     int getWereWolfChatMaxMessage();

     void setWereWolfChatMaxMessage(int nbMessage);



}
