package com.white.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Toast.makeText(this, "X plays first", Toast.LENGTH_SHORT).show();
    }

    // 0 = X, 1 = o
    int activePlayer = 0;

    //2 = Not played
    int[] gameState = {2, 3, 4, 5, 6, 7, 8, 9, 10};

    int count = 0;
    boolean isGameActive = true;

    public void dropIn(View view)
    {
       // Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();

        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter] >= 2 && isGameActive)
        {
            gameState[tappedCounter] = activePlayer;
            count++;
            if(activePlayer == 0)
            {
                activePlayer = 1;
                counter.setImageResource(R.drawable.cross);
            }
            else
            {
                activePlayer = 0;
                counter.setImageResource(R.drawable.zero);
            }

            if(gameState[0] == gameState[1] && gameState[0] == gameState[2] ||
               gameState[3] == gameState[4] && gameState[3] == gameState[5] ||
               gameState[6] == gameState[7] && gameState[6] == gameState[8] ||
               gameState[0] == gameState[3] && gameState[0] == gameState[6] ||
               gameState[1] == gameState[4] && gameState[1] == gameState[7] ||
               gameState[2] == gameState[5] && gameState[2] == gameState[8] ||
               gameState[0] == gameState[4] && gameState[0] == gameState[8] ||
               gameState[2] == gameState[4] && gameState[2] == gameState[6])
            {
                isGameActive = false;
                ImageView firework = (ImageView) findViewById(R.id.imageView17);
                firework.animate().alpha(1f).setDuration(2000);

                if(activePlayer == 0)
                {
                    ImageView winner = (ImageView) findViewById(R.id.imageView18);
                    winner.animate().alpha(1f).setDuration(2000);
                }
                else
                {
                    ImageView winner = (ImageView) findViewById(R.id.imageView16);
                    winner.animate().alpha(1f).setDuration(2000);
                }
            }

            if(count >= 9 && isGameActive)
            {
                isGameActive = false;
                ImageView winner = (ImageView) findViewById(R.id.imageView19);
                winner.animate().alpha(1f).setDuration(2000);
            }
        }
    }

    public void goBack(View view)
    {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void backToMain(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

}
