package com.example.tritonhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Tasks extends AppCompatActivity {

    Button nextButton;
    Button backButton;
    TextInputEditText taskOne;
    TextInputEditText taskTwo;
    TextInputEditText taskThree;
    TextInputEditText taskFour;
    TextInputEditText taskFive;
    String studyValue;
    String breakValues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        nextButton= findViewById(R.id.button_next_tasks);
        backButton= findViewById(R.id.button_back_tasks);
        taskOne=findViewById(R.id.input_task1_tasks);
        taskTwo=findViewById(R.id.input_task2_tasks);
        taskThree=findViewById(R.id.input_task3_tasks);
        taskFour=findViewById(R.id.input_task4_tasks);
        taskFive=findViewById(R.id.input_task5_tasks);

        Intent i= getIntent();
        studyValue= i.getStringExtra("studyValue");
        breakValues= i.getStringExtra("breakValue");


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Tasks.this,Timer.class);
                intent.putExtra("task1", taskOne.getText());
                intent.putExtra("task2", taskTwo.getText());
                intent.putExtra("task3", taskThree.getText());
                intent.putExtra("task4", taskFour.getText());
                intent.putExtra("task5", taskFive.getText());
                intent.putExtra("studyValue1",studyValue);
                intent.putExtra("breakValue1",breakValues);

                startActivity(intent);
            }
        });





        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Tasks.this, Setting.class);
                startActivity(intent);
            }
        });



    }
}