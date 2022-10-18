package fr.ph1lou.werewolfapi.versions;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VersionUtils_1_10 extends VersionUtils_1_9{

    @Override
    public void sendActionBar(@NotNull Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(message).create());
    }
}
