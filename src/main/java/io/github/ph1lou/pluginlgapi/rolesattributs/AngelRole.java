package io.github.ph1lou.pluginlgapi.rolesattributs;

import io.github.ph1lou.pluginlgapi.enumlg.AngelForm;

public interface AngelRole {

    boolean isChoice(AngelForm AngelForm);

    AngelForm getChoice();

    void setChoice(AngelForm choice);
}
