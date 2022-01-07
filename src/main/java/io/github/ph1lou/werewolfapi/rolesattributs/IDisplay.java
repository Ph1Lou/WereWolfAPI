package io.github.ph1lou.werewolfapi.rolesattributs;

public interface IDisplay {

    void setDisplayCamp(String camp);

    boolean isDisplayCamp(String camp);

    String getDisplayCamp();

    String getDisplayRole();

    void setDisplayRole(String key);

    void clearDisplay();
}
