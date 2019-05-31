package com.ais.barkov.numbersgame;

import android.widget.Toast;

import com.ais.barkov.numbersgame.elements.Element;
import com.ais.barkov.numbersgame.properties.GameAttempts;
import com.ais.barkov.numbersgame.properties.GameChances;
import com.ais.barkov.numbersgame.properties.GameLevel;
import com.ais.barkov.numbersgame.properties.GameScore;
import com.ais.barkov.numbersgame.rules.IRule;
import com.ais.barkov.numbersgame.rules.RulesFactory;

public class GameLogic {

    private GameLevel level;
    private GameScore score;
    private GameAttempts attempts;
    private GameChances chances;
    private RulesFactory rulesFactory;
    private IRule currentRule;

    private final int CHANGE_RULE_START_LEVEL = 3;

    public GameLogic() {

        this.rulesFactory = new RulesFactory();

        this.level = new GameLevel(1);
        this.score = new GameScore();
        this.attempts = new GameAttempts();
        this.chances = new GameChances();

        this.initRound();
    }

    protected boolean initRound()
    {
        IRule rule;
        try {
            this.currentRule = (IRule)rulesFactory.getRandomRule();
        } catch (ClassNotFoundException e) {
            //Toast.makeText(this, "unable to load rule class", Toast.LENGTH_LONG);
            return false;
        }

        return true;
    }

    public boolean evaluateChoice(Element[] elements, Element selectedElement)
    {
        Element result;
        try {
            result = currentRule.applyRule(elements);
        } catch (NoSuchMethodException e) {
            return false;
        }

        this.attempts.increaseAttempts();
        if (result.getValue().equals(selectedElement.getValue())) {
            this.score.increaseScore(this.getLevel().getLevel());
            this.level.dispenseLevel();
            if (this.level.getLevel() > this.CHANGE_RULE_START_LEVEL) {
                this.initRound();
            }
            return true;
        }

        this.chances.decreaseChances();
        return false;
    }

    public GameLevel getLevel() {
        return level;
    }

    public GameScore getScore() {
        return score;
    }

    public GameAttempts getAttempts() {
        return attempts;
    }

    public GameChances getChances() {
        return chances;
    }

    public IRule getCurrentRule() {
        return currentRule;
    }

    public boolean checkGameFinished()
    {
        if (this.chances.getChances() == 0) {
            return true;
        }

        return false;
    }
}
