package com.ais.barkov.numbersgame;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ais.barkov.numbersgame.blocks.BlocksManager;
import com.ais.barkov.numbersgame.elements.Element;

public class FourBlocksGameActivity extends AppCompatActivity {


    private static final int BLOCKS_NUMBER = 4;
    private static final int ACTIVIY_EXIT = 5;
    private GameLogic gameLogic;
    private Element[] elements;
    private BlocksManager bManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_blocks);

        this.initGame();
    }

    protected boolean initGame() {

        this.gameLogic = new GameLogic();
        String ruleText = this.gameLogic.getCurrentRule().getRuleText();
        ((TextView)findViewById(R.id.txtCurrentRule)).setText(ruleText);

        bManager = new BlocksManager();
        int level = gameLogic.getLevel().getLevel();
        this.elements = bManager.generateIntNumbers(this.BLOCKS_NUMBER, level);

        this.boundNumsToButtons(this.elements);
        return  true;
    }

    public void doSelectNumber(View v)
    {
        this.processChoice(v.getId());
        if (this.gameLogic.checkGameFinished()) {
            Intent resultIntent = new Intent(this, GameResultActivity.class);
            resultIntent.putExtra("score", this.gameLogic.getScore().getScore());
            startActivityForResult(resultIntent, ACTIVIY_EXIT);
            this.finish();
        }
    }

    protected void boundNumsToButtons(Element[] elements)
    {
        Resources r = getResources();
        Button btnOne = (Button)findViewById(R.id.btnOne);
        btnOne.setText(elements[0].getValue().toString());
        ((Element)elements[0]).setElementId(r.getResourceName(R.id.btnOne));

        Button btnTwo = (Button)findViewById(R.id.btnTwo);
        btnTwo.setText(elements[1].getValue().toString());
        ((Element)elements[1]).setElementId(r.getResourceName(R.id.btnTwo));

        Button btnThree = (Button)findViewById(R.id.btnThree);
        btnThree.setText(elements[2].getValue().toString());
        ((Element)elements[2]).setElementId(r.getResourceName(R.id.btnThree));

        Button btnFour = (Button)findViewById(R.id.btnFour);
        btnFour.setText(elements[3].getValue().toString());
        ((Element)elements[3]).setElementId(r.getResourceName(R.id.btnFour));

    }

    protected Element getSelectedElement(String elementId)
    {
        for (Element element: this.elements) {
            if (element.getElementId().equals(elementId)) {
                return element;
            }
        }

        return null;
    }

    protected void processChoice(int id)
    {
        String resId = this.getResources().getResourceName(id);
        Element value = this.getSelectedElement(resId);

        this.gameLogic.evaluateChoice(this.elements, value);
        this.updateGameInfo();

        //Log.println(5, "elements", );
    }

    protected void updateGameInfo()
    {
        Resources r = getResources();
        int score = this.gameLogic.getScore().getScore();
        TextView txtScore = (TextView)findViewById(R.id.txtScore);
        txtScore.setText(""+score);

        int attempts = this.gameLogic.getAttempts().getAttempts();
        TextView txtAttempts = (TextView)findViewById(R.id.txtAttempts);
        txtAttempts.setText(""+attempts);

        int chances = this.gameLogic.getChances().getChances();
        TextView txtChances = (TextView)findViewById(R.id.txtChanses);
        txtChances.setText(""+chances);

        String ruleText = this.gameLogic.getCurrentRule().getRuleText();
        ((TextView)findViewById(R.id.txtCurrentRule)).setText(ruleText);

        int level = this.gameLogic.getLevel().getLevel();
        this.elements = bManager.generateIntNumbers(this.BLOCKS_NUMBER, level);
        this.boundNumsToButtons(this.elements);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == ACTIVIY_EXIT) {
            this.finish();
        }
    }
}
