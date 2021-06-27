package com.example.tritonhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.*;




public class Timer extends AppCompatActivity {

    Button backButton;
    Button homeButton;
    TextView currentTask;
    TextView otherTasks;
    TextView motQuote;
    int minDelay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        backButton=findViewById(R.id.button_back_timer);
        homeButton=findViewById(R.id.button_home_timer);
        currentTask=findViewById(R.id.input_task1_tasks);
        motQuote=findViewById(R.id.textview_motivationalquote_timer);

//        File file= new File();
//        Scanner sc= new Scanner(file);
//        String string= "";
//        while(sc.hasNextLine())
//        {
//            string+=sc.nextLine()+",";
//        }
//        string.split();




        Intent i= new Intent();
        currentTask.setText(i.getStringExtra("task1"));



//        minDelay=Integer.parseInt(i.getStringExtra());
//        try{
//            Thread.sleep(minDelay*60000);
//        }catch(Exception e){
//
//        }

        currentTask.setText(i.getStringExtra("task2"));


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