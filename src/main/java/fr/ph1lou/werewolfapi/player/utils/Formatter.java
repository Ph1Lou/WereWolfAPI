package fr.ph1lou.werewolfapi.player.utils;

import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.utils.Utils;
import org.apache.commons.lang.StringEscapeUtils;

import java.util.function.Function;

public class Formatter {

    private final String pattern;
    private final Function<WereWolfAPI, String> supplier;

    private Formatter(String pattern, Object supplier) {
        this.pattern = pattern;
        this.supplier = wereWolfAPI -> supplier.toString();
    }

    private Formatter(String pattern, Function<WereWolfAPI, String> supplier) {
        this.pattern = pattern;
        this.supplier = supplier;
    }

    public static Formatter format(String pattern, Object supplier) {
        return new Formatter(pattern, supplier);
    }

    public static Formatter format(String pattern, Function<WereWolfAPI, String> supplier) {
        return new Formatter(pattern, supplier);
    }


    public static Formatter player(String player) {
        return format("&player&", player);
    }

    public static Formatter timer(String timer) {
        return format("&timer&", timer);
    }

    public static Formatter timer(WereWolfAPI game, String timer) {
        return format("&timer&", Utils.conversion(game.getConfig().getTimerValue(timer)));
    }

    public static Formatter number(int number) {
        return format("&number&", number);
    }

    public static Formatter role(String role) {
        return format("&role&", role);
    }

    public String handle(WereWolfAPI wereWolfAPI, String message) {
        return message.replaceAll(StringEscapeUtils.escapeJava(this.pattern),
                String.valueOf(this.supplier.apply(wereWolfAPI)));
    }
}
