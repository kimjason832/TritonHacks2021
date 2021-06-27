package com.example.tritonhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Timer extends AppCompatActivity {

    Button backButton;
    Button homeButton;
    TextView currentTask;
    TextView otherTasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        backButton=findViewById(R.id.button_back_timer);
        homeButton=findViewById(R.id.button_home_timer);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Timer.this, Tasks.class);
                startActivity(intent);
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Timer.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }

}