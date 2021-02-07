package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.enums.Camp;

public interface Display {

    void setDisplayCamp(String camp);

    boolean isDisplayCamp(String camp);

    String getDisplayCamp() ;

    String getDisplayRole();

    void setDisplayRole(String key);
}
