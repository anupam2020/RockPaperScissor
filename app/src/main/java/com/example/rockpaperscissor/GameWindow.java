package com.example.rockpaperscissor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameWindow extends AppCompatActivity {

    private ImageView rock;
    private ImageView paper;
    private ImageView scissor;
    private ImageView rockpaperscissor;
    private Random rand = new Random();
    private TextView score;
    private TextView score1;
    public int value;
    public int points = 0;
    public int comp = 0;
    private TextView play;
    public int playerCount=0;
    public int compCount=0;
    private ImageView imagechanger;

    MainActivity main = new MainActivity();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_window);

        rock = (ImageView) findViewById(R.id.rock);
        paper = (ImageView) findViewById(R.id.paper);
        scissor = (ImageView) findViewById(R.id.scissor);
        rockpaperscissor = (ImageView) findViewById(R.id.start);
        score = (TextView) findViewById(R.id.PlayerScore);
        score1 = (TextView) findViewById(R.id.CompScore);
        play=(TextView)findViewById(R.id.Play);
        imagechanger=(ImageView)findViewById(R.id.change);

            rock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imagechanger.setImageResource(R.drawable.rocktrans);
                    RockPaperScissor();
                    if(value==1)
                    {
                        play.setText("Oops that's weird!");
                    }
                    else if (value == 3) {
                        points++;
                        playerCount++;
                        score.setText(String.valueOf(points));
                        play.setText("Great! Keep It Up.");
                    } else {
                        comp++;
                        compCount++;
                        score1.setText(String.valueOf(comp));
                        play.setText("Better Luck Next Time!");
                    }
                    if(points==5 || comp==5)
                        CheckForWin(points,comp);

                }
            });
            paper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imagechanger.setImageResource(R.drawable.handtrans);
                    RockPaperScissor();
                    if(value==2)
                    {
                        play.setText("Oops that's weird!");
                    }
                    else if (value == 1) {
                        points++;
                        playerCount++;
                        score.setText(String.valueOf(points));
                        play.setText("Great! Keep it Up.");
                    } else {
                        comp++;
                        compCount++;
                        score1.setText(String.valueOf(comp));
                        play.setText("Better Luck Next Time!");
                    }
                    if(points==5 || comp==5)
                        CheckForWin(points,comp);
                }
            });
            scissor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imagechanger.setImageResource(R.drawable.scissortrans);
                    RockPaperScissor();
                    if(value==3)
                    {
                        play.setText("Oops that's weird!");
                    }
                    else if (value == 2) {
                        points++;
                        playerCount++;
                        score.setText(String.valueOf(points));
                        play.setText("Great! Keep it Up.");
                    } else {
                        comp++;
                        compCount++;
                        score1.setText(String.valueOf(comp));
                        play.setText("Better Luck Next Time!");
                    }
                    if(points==5 || comp==5)
                        CheckForWin(points,comp);
                }
            });



        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        }

    void reset()
    {
        rockpaperscissor.setImageResource(R.drawable.rpswall);
        points=0;
        comp=0;
        score.setText("0");
        score1.setText("0");
        imagechanger.setImageResource(R.drawable.sample);
        play.setText("");
    }

    void CheckForWin(int pc,int cc)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Result");

        reset();
        if(pc==5 && pc>cc)
        {
            builder.setMessage("You Win! :)");
            reset();
        }
        if(cc==5 && cc>pc)
        {
            builder.setMessage("Computer Wins! :(");
            reset();
        }
        if(pc==5 && cc==5)
        {
            builder.setMessage("Draw!");
            reset();
        }

        reset();
        builder.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                recreate();
                reset();
            }
        });

        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        reset();
        builder.show();

    }

    void RockPaperScissor() {
        int random = rand.nextInt(3) + 1;
        switch (random) {
            case 1:
                rockpaperscissor.setImageResource(R.drawable.rocktrans);
                value = 1;
                break;
            case 2:
                rockpaperscissor.setImageResource(R.drawable.handtrans);
                value = 2;
                break;
            case 3:
                rockpaperscissor.setImageResource(R.drawable.scissortrans);
                value = 3;
                break;
        }
    }
}
