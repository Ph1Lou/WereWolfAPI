package io.github.ph1lou.pluginlgapi;

import io.github.ph1lou.pluginlgapi.enumlg.TimerLG;
import io.github.ph1lou.pluginlgapi.enumlg.ToolLG;

import java.util.Map;

/**
 * @author Ph1Lou
 */

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

     Map<TimerLG, Integer> getTimerValues();

     Map<ToolLG, Boolean> getConfigValues();

     Map<String, Integer> getRoleCount();

     Map<String, Boolean> getScenarioValues();

     int getAmnesiacLoverSize();
     void setAmnesiacLoverSize(int amnesiacLoverSize);

     int getCursedLoverSize();

     void setCursedLoverSize(int cursedLoverSize);

     int getLoverSize();

     void setLoverSize(int loverSize);

     void getConfig(WereWolfAPI api, String configName);

}
