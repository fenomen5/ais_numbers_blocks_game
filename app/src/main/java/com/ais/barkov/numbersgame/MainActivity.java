package com.ais.barkov.numbersgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_foreground);
    }

    public void doAbout(View v)
    {
        Intent about = new Intent(this, AboutActivity.class);
        startActivity(about);
    }

    public void doTwoBlocksGame(View v)
    {
        Intent twoBlocksGame = new Intent(this, TwoBlocksGameActivity.class);
        startActivity(twoBlocksGame);
    }

    public void doFourBlocksGame(View v)
    {
        Intent fourBlocksGame = new Intent(this, FourBlocksGameActivity.class);
        startActivity(fourBlocksGame);
    }
}
