package io.github.ph1lou.werewolfapi;

import io.github.ph1lou.werewolfapi.enums.Sound;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Optional;

public class MessageAction {

    private final TextComponent message;
    private final Sound sound;

    public MessageAction(TextComponent message, Sound sound){
        this.message=message;
        this.sound=sound;
    }

    public MessageAction(String message, Sound sound){
        this(new TextComponent(message),sound);
    }

    public MessageAction(String message){
        this(message,null);
    }

    public MessageAction(TextComponent message){
        this(message,null);
    }

    public TextComponent getMessage() {
        return message;
    }

    public Optional<Sound> getSound() {
        if(sound==null){
            return Optional.empty();
        }
        return Optional.of(sound);
    }
}
