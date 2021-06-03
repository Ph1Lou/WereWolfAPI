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

    public String handle(String message){
        return message.replace(this.pattern,
                String.valueOf(this.supplier));
    }
}
