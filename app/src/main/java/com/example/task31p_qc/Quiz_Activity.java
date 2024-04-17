package com.example.task31p_qc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz_Activity extends AppCompatActivity implements View.OnClickListener {

    public static  String question[] = {
            "Question 1",
            "Question 2",
            "Question 3",
            "Question 4",
            "Question 5"
    };
    public static  String choices[][]={
            {"Answer 1", "Answer 2", "Answer 3", "Answer 4"},
            {"Answer 1", "Answer 2", "Answer 3", "Answer 4"},
            {"Answer 1", "Answer 2", "Answer 3", "Answer 4"},
            {"Answer 1", "Answer 2", "Answer 3", "Answer 4"},
            {"Answer 1", "Answer 2", "Answer 3", "Answer 4"},
    };
    public static String correctAnswers[] = {
            "Answer 1",
            "Answer 2",
            "Answer 3",
            "Answer 4",
            "Answer 3"
    };

    TextView No_of_Question;
    TextView QuestionTextView, User_text;
    Button buttons[] = new Button[4];
    Button Submit;
    ProgressBar ProgressBarQsn;
    int score = 0;
    int Totalquestion = question.length;
    int currentindex = 0;
    String selectAns = "";
    int selectid ;
    int flag =0 ;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
        score = 0;
         name = getIntent().getStringExtra("username");


        No_of_Question = findViewById(R.id.No_of_Question);
        QuestionTextView = findViewById(R.id.QuestionsTextView);
        buttons[0] = findViewById(R.id.Option1);
        buttons[1] = findViewById(R.id.Option2);
        buttons[2] = findViewById(R.id.Option3);
        buttons[3] = findViewById(R.id.Option4);
        User_text = findViewById(R.id.User_text);
        Submit = findViewById(R.id.Submit);
        ProgressBarQsn = findViewById(R.id.progressBarQsn);
        User_text.setText("Hey, "+name);


        buttons[0].setOnClickListener(this);
        buttons[1].setOnClickListener(this);
        buttons[2].setOnClickListener(this);
        buttons[3].setOnClickListener(this);
        Submit.setOnClickListener(this);
        Submit.setText("Submit");

        ProvideQuestions();


    }
    @Override
    public void onClick(View view){



        Button selButton = (Button) view;

        if(selButton.getId() == R.id.Submit){

            Submit.setText("Next");
            if(flag== 0) {
                if (selectAns.equals(correctAnswers[currentindex])) {
                    for (int i = 0; i < 4; i++) {
                        if (buttons[i].getText().toString() == correctAnswers[currentindex]) {
                            buttons[i].setBackgroundColor(Color.GREEN);
                        }

                    }
                    score++;

                } else {
                    for (int i = 0; i < 4; i++) {
                        if (buttons[i].getId() == selectid) {
                            buttons[i].setBackgroundColor(Color.RED);
                        } else if (buttons[i].getText().toString() == correctAnswers[currentindex]) {
                            buttons[i].setBackgroundColor(Color.GREEN);
                        }
                    }

                }
                flag = 1;
            }


            else if(flag==1){
                currentindex++;
                ProvideQuestions();
            }
        }else{
            selectAns = selButton.getText().toString();
            selectid = selButton.getId();
            selButton.setBackgroundColor(Color.BLUE);
        }

    }

    public void ProvideQuestions(){
        if(currentindex < question.length) {
            Submit.setText("Submit");
            QuestionTextView.setText(question[currentindex]);
            No_of_Question.setText(currentindex + 1 + "/" + question.length);
            selectid = -1;
            flag = 0;
            ProgressBarQsn.setProgress((currentindex + 1)*100/question.length);

            for (int i = 0; i < 4; i++) {
                buttons[i].setText(choices[currentindex][i]);
                buttons[i].setBackgroundColor(Color.GRAY);
                buttons[i].setTextColor(Color.BLACK);
            }

        }
        else{
            Submit.setText("Finish");
            Submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Quiz_Activity.this, Final_ScoreActivity.class);
                    intent.putExtra("User_score",score);
                    intent.putExtra("username", getIntent().getStringExtra("username"));
                    startActivity(intent);
                    finish();
                }
            });
        }

    }

}
