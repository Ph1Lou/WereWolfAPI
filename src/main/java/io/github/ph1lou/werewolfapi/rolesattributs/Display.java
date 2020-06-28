package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.enumlg.Camp;

public interface Display {

    void setDisplayCamp(Camp camp);

    boolean isDisplayCamp(Camp camp);

    Camp getDisplayCamp() ;

    Roles getDisplayRole();

    void setDisplayRole(Roles roleLG);
}
