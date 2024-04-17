package com.example.task31p_qc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Process;

import androidx.appcompat.app.AppCompatActivity;

public class Final_ScoreActivity extends AppCompatActivity {

    TextView sent , finalscore;
    Button tryagain, gameover;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_scoreactivity);

        sent = findViewById(R.id.finishtext);
        finalscore = findViewById(R.id.finalscore);
        tryagain = findViewById(R.id.playagain);
        gameover = findViewById(R.id.Finish);


        int score = getIntent().getIntExtra("User_score",0);
        String name = getIntent().getStringExtra("username");

        sent.setText("Final score of " + name);
        finalscore.setText(score + " / 5");


        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ff =1;
            Intent intent = new Intent(Final_ScoreActivity.this, MainActivity.class);
                intent.putExtra("username",name);
                startActivity(intent);
                finish();
            }
        });

        gameover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Final_ScoreActivity.this, MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent.putExtra("EXIT", true);
                finish();
                System.exit(0);
            }
        });
    }
    
}
