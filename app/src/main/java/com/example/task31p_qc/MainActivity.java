package com.example.task31p_qc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText EnterName;
    private Button Quiz_Button;
    String name  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        name = getIntent().getStringExtra("username");
        EnterName = findViewById(R.id.EnterName);
        Quiz_Button = findViewById(R.id.Quiz_Button);
        EnterName.setText(name);
        Quiz_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                name = EnterName.getText().toString();
                Intent intent = new Intent(MainActivity.this, Quiz_Activity.class);
                intent.putExtra("username",name);
                startActivity(intent);
                finish();
            }

        });
    }
}