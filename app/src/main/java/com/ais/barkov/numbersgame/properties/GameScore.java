package com.ais.barkov.numbersgame.properties;

public class GameScore {

    private int score;

    public GameScore() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int level) {
        this.score += level;
    }

}
