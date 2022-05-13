package fr.ph1lou.werewolfapi.game;

public interface IStorageConfiguration {

    int getTimerValue(String key);

    boolean isConfigActive(String key);

    int getRoleCount(String key);

    void switchConfigValue(String key);

    void switchScenarioValue(String key);

    void removeOneRole(String key);

    void addOneRole(String key);

    void setRole(String key, int value);

    void moveTimer(String key, int value);

    void setConfig(String key,boolean enable);

    void setScenario(String key,boolean enable);

    void setTimerValue(String key, int value);

    boolean isScenarioActive(String key);

    /**
     * Get Random Event Probability
     * @param key of the random event
     * @return the probability
     */
    int getProbability(String key);

    /**
     * Set Probability of the random Event
     * @param key of the random event
     * @param probability the probability
     */
    void setProbability(String key,int probability);

    int getValue(String key);

    void setValue(String key, int value);

    int getLoverCount(String key);

    void setLoverCount(String key,int value);

    void addOneLover(String key);

    void removeOneLover(String key);
}
