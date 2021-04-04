package io.github.ph1lou.werewolfapi.rolesattributs;

import java.util.List;

public interface IStorage {

    List<? extends String> getStorage();

    void addStorage(String message);

    void clearStorage();
}
