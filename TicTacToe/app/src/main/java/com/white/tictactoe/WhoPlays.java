package com.white.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class WhoPlays extends AppCompatActivity {

    protected static WhoPlays whoPlays = new WhoPlays();
    int compPlaysFirst = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_plays);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    //private WhoPlays(){};

    public static WhoPlays getInstance()
    {
        return whoPlays;
    }
    public int getWhoPlays()
    {
        return compPlaysFirst;
    }

    public void iPlayFirst(View view)
    {
        whoPlays.compPlaysFirst = 0;
        ImageView player = (ImageView) findViewById(R.id.imageView23);
        player.animate().translationX(1000);
        player.animate().alpha(0f).setDuration(3000);

        ImageView player1 = (ImageView) findViewById(R.id.imageView22);
        player1.animate().translationX(1000);
        player1.animate().alpha(0f).setDuration(3000);

        ImageView player2 = (ImageView) findViewById(R.id.imageView20);
        player2.animate().translationX(1000);
        player2.animate().alpha(0f).setDuration(3000);

        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        startActivity(intent);
    }

    public void compPlaysFirst(View view)
    {
        whoPlays.compPlaysFirst = 1;

        ImageView player = (ImageView) findViewById(R.id.imageView23);
        player.animate().translationX(1000);
        player.animate().alpha(0f).setDuration(3000);

        ImageView player1 = (ImageView) findViewById(R.id.imageView22);
        player1.animate().translationX(1000);
        player1.animate().alpha(0f).setDuration(3000);

        ImageView player2 = (ImageView) findViewById(R.id.imageView20);
        player2.animate().translationX(1000);
        player2.animate().alpha(0f).setDuration(3000);

        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        startActivity(intent);
    }
}
