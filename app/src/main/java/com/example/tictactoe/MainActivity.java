package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Boolean gameActive = true;
    //Player representation
    //0 - o
    //1 - tick
    int activeplayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2,};
    //State meanings
    //    0 - o_
    //    1 - tick_
    //    2 - Null
    int[][] winPositions = {{0,1,2}, {3,4,5},{6,7,8},
                             {0,3,6},{1,4,7},{2,5,8},
                                {0,4,8},{2,4,6}};
public void playertap (View view){
    ImageView img = (ImageView) view;
    int tappedImage = Integer.parseInt(img.getTag().toString());
    if (!gameActive){
        gameReset(view);
    }
    if(gameState[tappedImage] == 2) {
        gameState[tappedImage] = activeplayer;
        img.setTranslationY(-1000f);
        if (activeplayer == 0) {
            img.setImageResource(R.drawable.o);
            activeplayer = 1;
            TextView status = findViewById(R.id.status);
            status.setText("Tick's Turn - Tap to play");
        } else {
            img.setImageResource(R.drawable.tick);
            activeplayer = 0;
            TextView status = findViewById(R.id.status);
            status.setText("O's Turn - Tap to play");
        }

        img.animate().translationYBy(1000f).setDuration(300);
    }
    //Check if any player has won
    for(int[] winPositions: winPositions){
       if (gameState[winPositions[0]] == gameState[winPositions[1]] &&
               gameState[winPositions[1]] == gameState[winPositions[2]] &&
               gameState[winPositions[0]]!=2){
           //Somebody has won! - Find out who!
           String winnerStr;
           gameActive = false;
           if (gameState[winPositions[0]] == 0) {
               winnerStr = "0 has won";
           }
           else {
               winnerStr = "Tick has won";

           }
           //Update the status bar for winner announcement
           TextView status = findViewById(R.id.status);
           status.setText(winnerStr);
       }
    }
}

public void gameReset(View view){

}
    public void playertap2 (View view){
    gameActive = true;
    activeplayer = 0;
    for (int i=0; i<gameState.length; i++){
        gameState[i] = 2;
    }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}