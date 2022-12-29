package fr.ph1lou.werewolfapi.game;

import com.eclipsesource.json.JsonValue;
import fr.ph1lou.werewolfapi.player.utils.Formatter;

import java.util.List;
import java.util.Map;

public interface ILanguageManager {

    List<String> getTranslationList(String key, Formatter... formatters);

    String getTranslation(String key, Formatter... formatters);

    void loadTranslations(String addonKey, Map<String, JsonValue> translations);
}
