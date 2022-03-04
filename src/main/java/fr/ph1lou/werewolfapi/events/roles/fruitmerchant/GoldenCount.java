package fr.ph1lou.werewolfapi.events.roles.fruitmerchant;

public class GoldenCount {

    private final int oldCount;
    private final int newCount;

    public GoldenCount(int oldCount, int newCount){
        this.oldCount=oldCount;
        this.newCount=newCount;
    }

    public int getOldCount() {
        return oldCount;
    }

    public int getNewCount() {
        return newCount;
    }
}
