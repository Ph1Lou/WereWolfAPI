package io.github.ph1lou.werewolfapi;

public class Formatter {

    private final String pattern;
    private final Object supplier;

    private Formatter(String pattern, Object supplier){
        this.pattern=pattern;
        this.supplier=supplier;
    }

    public static Formatter format(String pattern, Object supplier){
        return new Formatter(pattern,supplier);
    }

    public static Formatter player(String player){
        return format("&player&",player);
    }

    public static Formatter timer(String timer){
        return format("&timer&",timer);
    }

    public static Formatter number(int number){
        return format("&number&",number);
    }
    public static Formatter role(String role){
        return format("&role&",role);
    }

    public String handle(String message){
        return message.replaceAll(this.pattern,
                String.valueOf(this.supplier));
    }
}
