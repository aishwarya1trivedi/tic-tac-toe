package com.white.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import static com.white.tictactoe.R.drawable.cross;

public class ThirdActivity extends WhoPlays {

    int isGameActive = 1;
    int compPlaysFirst = 2; // 0 = false, 1 = true
    int activePlayer = 2; // 1 = comp, 0 = person
    int[] gameState = {2, 3, 4, 5, 6, 7, 8, 9, 10}; //1 = comp, 0 = person


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        WhoPlays whoPlays = WhoPlays.getInstance();
        compPlaysFirst = whoPlays.getWhoPlays();
        if(compPlaysFirst == 1)
        {
            activePlayer = 1;
            compPlots();
        }
        else
        {
            activePlayer = 0;
        }

    }

 /*   public void compPlotsFirst()
    {
        ImageView counter = (ImageView) view;
        if(activePlayer == 1)
        {
            activePlayer = 0;
            int min = 0;
            int max = 8;

            //Generate random int value from 0 to 8
            int plotCounter = (int) (Math.random() * (max - min + 1) + min);
            gameState[plotCounter] = 1;

            if(compPlaysFirst == 0)
            {
                counter.setImageResource(R.drawable.zero);
            }
            else
            {
                counter.setImageResource(cross);
            }
        }
    }
*/
 public void isGameOver()
    {
        int stateCount = 0;

        if(gameState[0] == gameState[1] && gameState[0] == gameState[2] ||
                gameState[3] == gameState[4] && gameState[3] == gameState[5] ||
                gameState[6] == gameState[7] && gameState[6] == gameState[8] ||
                gameState[0] == gameState[3] && gameState[0] == gameState[6] ||
                gameState[1] == gameState[4] && gameState[1] == gameState[7] ||
                gameState[2] == gameState[5] && gameState[2] == gameState[8] ||
                gameState[0] == gameState[4] && gameState[0] == gameState[8] ||
                gameState[2] == gameState[4] && gameState[2] == gameState[6])
        {
            isGameActive = 0;
            ImageView firework = (ImageView) findViewById(R.id.imageView17);
            firework.animate().alpha(1f).setDuration(2000);

            if(activePlayer == 0)
            {
                if(compPlaysFirst == 0) {
                    ImageView winner = (ImageView) findViewById(R.id.imageView18);
                    winner.animate().alpha(1f).setDuration(2000);
                }
                else {
                    ImageView winner = (ImageView) findViewById(R.id.imageView16);
                    winner.animate().alpha(1f).setDuration(2000);
                }
            }
            else
            {
                    if(compPlaysFirst == 0) {
                        ImageView winner = (ImageView) findViewById(R.id.imageView16);
                        winner.animate().alpha(1f).setDuration(2000);
                    }
                    else {
                        ImageView winner = (ImageView) findViewById(R.id.imageView18);
                        winner.animate().alpha(1f).setDuration(2000);
                    }
                }
        }
        else
        {
            for(int i = 0; i <= 8; i++)
            {
                if(gameState[i] < 2)
                {
                    stateCount++;
                }
            }
            if(stateCount == 9)
            {
                isGameActive = 0;
                ImageView winner = (ImageView) findViewById(R.id.imageView19);
                winner.animate().alpha(1f).setDuration(2000);
            }
        }
    }

    public int getPlotCounter()
    {
        int max = 8, min = 0, plotCounter = 0, count = 0;

        if(((gameState[0] == gameState[1] && gameState[0] == 1) ||
                (gameState[5] == gameState[8] && gameState[5] == 1) ||
                (gameState[4] == gameState[6] && gameState[4] == 1)) && gameState[2] > 1)
        {
            plotCounter = 2;
        }
        else if(((gameState[0] == gameState[2] && gameState[0] == 1) ||
                (gameState[4] == gameState[7] && gameState[4] == 1)) && gameState[1] > 1)
        {
            plotCounter = 1;
        }
        else if(((gameState[1] == gameState[3] && gameState[1] == 1) ||
                (gameState[3] == gameState[6] && gameState[3] == 1) ||
                (gameState[4] == gameState[8] && gameState[4] == 1)) && gameState[0] > 1)
        {
            plotCounter = 0;
        }
        else if(((gameState[0] == gameState[8] && gameState[0] == 1) ||
                (gameState[2] == gameState[6] && gameState[2] == 1)) && gameState[4] > 1)
        {
            plotCounter = 4;
        }
        else if(((gameState[3] == gameState[4] && gameState[3] == 1) ||
                (gameState[2] == gameState[8] && gameState[2] == 1)) && gameState[5] > 1)
        {
            plotCounter = 5;
        }
        else if(((gameState[3] == gameState[5] && gameState[3] == 1) ||
                (gameState[1] == gameState[7] && gameState[1] == 1)) && gameState[4] > 1)
        {
            plotCounter = 4;
        }
        else if(((gameState[4] == gameState[5] && gameState[4] == 1) ||
                (gameState[0] == gameState[6] && gameState[0] == 1)) && gameState[3] > 1)
        {
            plotCounter = 3;
        }
        else if(((gameState[6] == gameState[7] && gameState[6] == 1) ||
                (gameState[2] == gameState[5] && gameState[2] == 1) ||
                (gameState[0] == gameState[4] && gameState[0] == 1)) && gameState[8] > 1)
        {
            plotCounter = 8;
        }
        else if(((gameState[6] == gameState[8] && gameState[6] == 1) ||
                (gameState[1] == gameState[4] && gameState[1] == 1)) && gameState[7] > 1)
        {
            plotCounter = 7;
        }
        else if(((gameState[7] == gameState[8] && gameState[7] == 1) ||
                (gameState[0] == gameState[3] && gameState[0] == 1) ||
                (gameState[4] == gameState[2] && gameState[4] == 1)) && gameState[6] > 1)
        {
            plotCounter = 6;
        }


        //--------------------------------------------------//


        else if(((gameState[0] == gameState[1] && gameState[0] == 0) ||
                (gameState[5] == gameState[8] && gameState[5] == 0) ||
                (gameState[4] == gameState[6] && gameState[4] == 0)) && gameState[2] > 1)
        {
            plotCounter = 2;
        }
        else if(((gameState[0] == gameState[2] && gameState[0] == 0) ||
                (gameState[4] == gameState[7] && gameState[4] == 0)) && gameState[1] > 1)
        {
            plotCounter = 1;
        }
        else if(((gameState[1] == gameState[2] && gameState[1] == 0) ||
                (gameState[3] == gameState[6] && gameState[3] == 0) ||
                (gameState[4] == gameState[8] && gameState[4] == 0)) && gameState[0] > 1)
        {
            plotCounter = 0;
        }
        else if(((gameState[0] == gameState[8] && gameState[0] == 0) ||
                (gameState[2] == gameState[6] && gameState[2] == 0)) && gameState[4] > 1)
        {
            plotCounter = 4;
        }
        else if(((gameState[3] == gameState[4] && gameState[3] == 0) ||
                (gameState[2] == gameState[8] && gameState[2] == 0)) && gameState[5] > 1)
        {
            plotCounter = 5;
        }
        else if(((gameState[3] == gameState[5] && gameState[3] == 0) ||
                (gameState[1] == gameState[7] && gameState[1] == 0)) && gameState[4] > 1)
        {
            plotCounter = 4;
        }
        else if(((gameState[4] == gameState[5] && gameState[4] == 0) ||
                (gameState[0] == gameState[6] && gameState[0] == 0)) && gameState[3] > 1)
        {
            plotCounter = 3;
        }
        else if(((gameState[6] == gameState[7] && gameState[6] == 0) ||
                (gameState[2] == gameState[5] && gameState[2] == 0) ||
                (gameState[0] == gameState[4] && gameState[0] == 0)) && gameState[8] > 1)
        {
            plotCounter = 8;
        }
        else if(((gameState[6] == gameState[8] && gameState[6] == 0) ||
                (gameState[1] == gameState[4] && gameState[1] == 0)) && gameState[7] > 1)
        {
            plotCounter = 7;
        }
        else if(((gameState[7] == gameState[8] && gameState[7] == 0) ||
                (gameState[0] == gameState[3] && gameState[0] == 0) ||
                (gameState[4] == gameState[2] && gameState[4] == 0)) && gameState[6] > 1)
        {
            plotCounter = 6;
        }
        else
        {
            do {
                plotCounter = (int) (Math.random() * (max - min + 1) + min);
                if (gameState[plotCounter] > 1) {
                    count++;
                }
            }while(count != 1);
        }
        return plotCounter;
    }

    public void compPlots() {
//        isGameOver();
        activePlayer = 0;
        int max = 8, min = 0;
        int count = 0;
        if(isGameActive == 1)
        {
     //   do {
            //Generate random int value from 0 to 8
            int plotCounter = getPlotCounter();
            switch (plotCounter) {
                case 0: {
                        if (compPlaysFirst == 0) {
                            ImageView view = (ImageView) findViewById(R.id.imageView39);
                            view.animate().alpha(1f).setDuration(2000);
                        } else {
                            ImageView view = (ImageView) findViewById(R.id.imageView30);
                            view.animate().alpha(1f).setDuration(2000);
                        }
                        gameState[plotCounter] = 1;
                }
                break;
                case 1: {
                        if (compPlaysFirst == 0) {
                            ImageView view = (ImageView) findViewById(R.id.imageView31);
                            view.animate().alpha(1f).setDuration(2000);
                        } else {
                            ImageView view = (ImageView) findViewById(R.id.imageView40);
                            view.animate().alpha(1f).setDuration(2000);
                        }
                        gameState[plotCounter] = 1;
                }
                break;
                case 2: {
                        if (compPlaysFirst == 0) {
                            ImageView view = (ImageView) findViewById(R.id.imageView41);
                            view.animate().alpha(1f).setDuration(2000);
                        } else {
                            ImageView view = (ImageView) findViewById(R.id.imageView32);
                            view.animate().alpha(1f).setDuration(2000);
                        }
                        gameState[plotCounter] = 1;
                }
                break;
                case 3: {
                        if (compPlaysFirst == 0) {
                            ImageView view = (ImageView) findViewById(R.id.imageView33);
                            view.animate().alpha(1f).setDuration(2000);
                        } else {
                            ImageView view = (ImageView) findViewById(R.id.imageView42);
                            view.animate().alpha(1f).setDuration(2000);
                        }
                        gameState[plotCounter] = 1;
                }
                break;
                case 4: {
                        if (compPlaysFirst == 0) {
                            ImageView view = (ImageView) findViewById(R.id.imageView43);
                            view.animate().alpha(1f).setDuration(2000);
                        } else {
                            ImageView view = (ImageView) findViewById(R.id.imageView34);
                            view.animate().alpha(1f).setDuration(2000);
                        }
                        gameState[plotCounter] = 1;
                }
                break;
                case 5: {
                        if (compPlaysFirst == 0) {
                            ImageView view = (ImageView) findViewById(R.id.imageView35);
                            view.animate().alpha(1f).setDuration(2000);
                        } else {
                            ImageView view = (ImageView) findViewById(R.id.imageView44);
                            view.animate().alpha(1f).setDuration(2000);
                        }
                        gameState[plotCounter] = 1;
                }
                break;
                case 6: {
                        if (compPlaysFirst == 0) {
                            ImageView view = (ImageView) findViewById(R.id.imageView45);
                            view.animate().alpha(1f).setDuration(2000);
                        } else {
                            ImageView view = (ImageView) findViewById(R.id.imageView36);
                            view.animate().alpha(1f).setDuration(2000);
                        }
                        gameState[plotCounter] = 1;
                }
                break;
                case 7: {
                        if (compPlaysFirst == 0) {
                            ImageView view = (ImageView) findViewById(R.id.imageView37);
                            view.animate().alpha(1f).setDuration(2000);
                        } else {
                            ImageView view = (ImageView) findViewById(R.id.imageView46);
                            view.animate().alpha(1f).setDuration(2000);
                        }
                        gameState[plotCounter] = 1;
                }
                break;
                case 8: {
                        if (compPlaysFirst == 0) {
                            ImageView view = (ImageView) findViewById(R.id.imageView47);
                            view.animate().alpha(1f).setDuration(2000);
                        } else {
                            ImageView view = (ImageView) findViewById(R.id.imageView38);
                            view.animate().alpha(1f).setDuration(2000);
                    }
                    gameState[plotCounter] = 1;
                }
                break;

            }

           /* if(count > 0) {
                break;
            }*/
       // } while (count != 1);
        isGameOver();
    }
    }

    public void iPlot(View view)
    {
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(activePlayer == 0 && gameState[tappedCounter] > 1)
        {
            gameState[tappedCounter] = 0;
            activePlayer = 1;
            if(compPlaysFirst == 0)
            {
                counter.setImageResource(R.drawable.cross);
            }
            else
            {
                counter.setImageResource(R.drawable.zero);
            }
            isGameOver();
         if(isGameActive == 1)
         {
             compPlots();
         }
         //  isGameOver();
        }
    }

    public void dropInComp(View view) {
        if (isGameActive == 1) {
            iPlot(view);
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
