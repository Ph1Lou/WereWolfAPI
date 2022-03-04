package fr.ph1lou.werewolfapi.lovers;

import java.util.List;

public interface ILoverManager {

    List<? extends ILover> getLovers();

    void removeLover(ILover ILover);

    void addLover(ILover ILover);
}
