package fr.ph1lou.werewolfapi.role.interfaces;

public interface IDisplay {

    void setDisplayCamp(String camp);

    boolean isDisplayCamp(String camp);

    String getDisplayCamp();

    String getDisplayRole();

    void setDisplayRole(String key);

    void clearDisplay();
}
