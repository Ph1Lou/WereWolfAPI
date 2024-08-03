package fr.ph1lou.werewolfapi.versions;


import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.Nullable;

public class VersionUtils_1_16 extends VersionUtils_1_15 {

    @Override
    public TextComponent createClickableText(String text, String command, ClickEvent.Action action, @Nullable String hover) {
        TextComponent textComponent = new TextComponent(text);
        textComponent.setClickEvent(new ClickEvent(action, command));
        if(hover != null){
            textComponent.setHoverEvent(
                    new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(hover)));
        }
        return textComponent;
    }
}

