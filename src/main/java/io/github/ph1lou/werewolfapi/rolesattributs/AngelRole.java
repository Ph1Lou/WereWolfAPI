package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.enums.AngelForm;

public interface AngelRole {

    boolean isChoice(AngelForm AngelForm);

    AngelForm getChoice();

    void setChoice(AngelForm choice);


}
