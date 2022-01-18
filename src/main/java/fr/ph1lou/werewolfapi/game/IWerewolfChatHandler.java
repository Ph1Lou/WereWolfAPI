package fr.ph1lou.werewolfapi.game;

import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

import java.util.List;

public interface IWerewolfChatHandler {
    /**
     * Enable Werewolf Chat
     */
    void enableWereWolfChat();

    /**
     * Disable WereWolf chat
     */
    void disableWereWolfChat();

    boolean isWereWolfChatEnable();

    int getMessagesCount(IPlayerWW playerWW);

    List<String> getMessages(IPlayerWW playerWW);

    void addMessage(IPlayerWW playerWW, String message);
}
