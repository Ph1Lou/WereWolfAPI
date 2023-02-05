package fr.ph1lou.werewolfapi.role.interfaces;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.enums.Category;

import java.util.Set;

public interface IGuesser {

    boolean canGuess(IPlayerWW targetWW);

    void resolveGuess(String key, IPlayerWW targetWW);

    Set<Category> getAvailableCategories();
}
