package io.github.ph1lou.werewolfapi;

public interface IScoreBoard {


    int getRole();

    void setRole(int role);

    void addTimer();

    int getPlayerSize();

    void removePlayerSize();

    void addPlayerSize();

    int getGroup();

    void setGroup(int group);

    void getKillCounter();

    int getTimer();

    void updateBoard();

}
