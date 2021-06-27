package com.example.tritonhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import com.opencsv.CSVReader;





public class Timer extends AppCompatActivity {

    Button backButton;
    Button homeButton;
    TextView currentTask;
    TextView otherTasks;
    TextView motQuote;
    int minDelay;
    String[] possibleQuotes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        backButton=findViewById(R.id.button_back_timer);
        homeButton=findViewById(R.id.button_home_timer);
        currentTask=findViewById(R.id.textview_currenttask_timer);
        motQuote=findViewById(R.id.textview_motivationalquote_timer);


        try {
            readData();
        }catch(Exception e)
        {

        }





        int quoteChosen= (int)(Math.random()*possibleQuotes.length);
        motQuote.setText(possibleQuotes[quoteChosen]);






        Intent i= new Intent();

        currentTask.setText(i.getStringExtra("task1"));



//        minDelay=Integer.parseInt(i.getStringExtra());
//        try{
//            Thread.sleep(minDelay*60000);
//        }catch(Exception e){
//
//        }




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
    public void readData() throws IOException
    {
        //reads the csv file
        CSVReader reader = new CSVReader(new InputStreamReader(getResources().openRawResource(R.raw.studyquotes)));
        List<String[]> dataset = reader.readAll();
        possibleQuotes= new String[dataset.size()];
        for(int i=0;i<dataset.size();i++)
        {
            possibleQuotes[i]=dataset.get(i)[0];
        }
    }


}