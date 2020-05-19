package com.white.tictactoe;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        ImageView symbol = (ImageView) findViewById(R.id.imageView5);
        symbol.setTranslationX(-1000);
        symbol.setTranslationX(50);
        symbol.animate().rotationBy(1080).setDuration(2000);

        ImageView name = (ImageView) findViewById(R.id.imageView6);
        name.animate().alpha(1f).setDuration(3000);

    }

    public void gameStartWithFriends(View view)
    {
        // TODO Auto-generated method stub
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
        //      setContentView(R.layout.activity_game_start);
    }

    public void gameStartWithComputer(View view)
    {
        // TODO Auto-generated method stub
        Intent intent = new Intent(getApplicationContext(), WhoPlays.class);
        startActivity(intent);
        //      setContentView(R.layout.activity_game_start);
    }

}
