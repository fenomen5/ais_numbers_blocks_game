package com.ais.barkov.numbersgame.properties;

public class GameChances {

    public static final int DEFAULT_CHANCES_AMOUNT = 3;

    private int chances;

    public GameChances(int ... chances)
    {
        this.chances = chances.length > 0 ? chances[0] : GameChances.DEFAULT_CHANCES_AMOUNT;
    }

    public int getChances()
    {
        return this.chances;
    }

    public boolean decreaseChances()
    {
        if (this.isChancesRemain()) {
            this.chances--;
            return true;
        }

        return false;
    }

    public boolean isChancesRemain()
    {
        if (this.getChances() > 0) {
            return true;
        }

        return false;
    }
}
