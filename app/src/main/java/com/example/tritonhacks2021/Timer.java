package com.example.tritonhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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
    Button nextTask;
    String[] tasks;
    int taskCounter;

    //timer variables
    TextView countdown;
    Button pause;
    Button reset;
    boolean isTimerRunning;
    CountDownTimer countDownTimer;
    long timeStart;
    long timeLeft=timeStart;
    static long lastTimeStop;
    static long lastTimeStart;
    long timeBreak;
    long timeStudy;
    static boolean isBreak;
    static int loopTimes;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        Intent i=getIntent(); //retrieving information from the previous activity

        backButton=findViewById(R.id.button_back_timer);
        homeButton=findViewById(R.id.button_home_timer);
        currentTask=findViewById(R.id.textview_currenttask_timer);
        motQuote=findViewById(R.id.textview_motivationalquote_timer);
        nextTask=findViewById(R.id.button_skip_timer);




        tasks=new String[5];
        taskCounter=1;


        if(i.getStringExtra("task1").equals("Enter a task")){
            tasks[0]=null;
        }else{
            tasks[0]=i.getStringExtra("task1");
        }
        if(i.getStringExtra("task2").equals("Enter a task")){
            tasks[1]=null;
        }else{
            tasks[1]=i.getStringExtra("task2");
        }
        if(i.getStringExtra("task3").equals("Enter a task")){
            tasks[2]=null;
        }else{
            tasks[2]=i.getStringExtra("task3");
        }
        if(i.getStringExtra("task4").equals("Enter a task")){
            tasks[3]=null;
        }else{
            tasks[3]=i.getStringExtra("task4");
        }
        if(i.getStringExtra("task5").equals("Enter a task")){
            tasks[4]=null;
        }else{
            tasks[4]=i.getStringExtra("task5");
        }
        //System.out.println(Arrays.toString(tasks));

        currentTask.setText(tasks[0]);






        //countdown setup
//        System.out.println(i.getStringExtra("studyValue1"));
        countdown=findViewById(R.id.text_view_countdown);
        pause=findViewById(R.id.button_pause_timer);
        reset=findViewById(R.id.button_reset_timer);
        try {

            timeStudy= Long.parseLong(i.getStringExtra("studyValue1"))*60000;
            timeBreak= Long.parseLong(i.getStringExtra("breakValue1"))*60000;
            if(timeStudy==0){
                timeStudy+=1000;
            }
            if(timeBreak==0)
            {
                timeBreak+=1000;
            }

            System.out.println(timeBreak+" +" +timeStudy);

            //resetTimer(); //TODO mdco modm o
        }catch(Exception e){
            timeLeft=lastTimeStop;
            timeStart=lastTimeStart;
            setTimer();
        }

       // startTimer();
        loopTimes=3;
        //for(int inc=0;inc<loopTimes;inc++)
        {
            if(timeLeft==lastTimeStop&&timeLeft!=0)
            {
                System.out.println("exit and back");
            }
            else if(isBreak==false)
            {
                timeStart= timeStudy;

                System.out.println("x");

            }else{
                timeStart=timeBreak;
                System.out.println("y");
            }
            System.out.println(timeStart);
            resetTimer();
            startTimer();

            isBreak=!isBreak;
            System.out.println("ran");
        }

//        while(isTimerRunning==true)
//        {
//
//        }









        //when pause is clicked
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isTimerRunning){ //if pause is displayed, then run method pause timer
                    pauseTimer();
                }else{ //run start timer
                    startTimer();
                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetTimer();
            }
        });

        updateCountDownText(); // end of countdown setup




        try {
            readData();
        }catch(Exception e)
        {

        }





        int quoteChosen= (int)(Math.random()*possibleQuotes.length);
        motQuote.setText(possibleQuotes[quoteChosen]);








        //currentTask.setText(i.getStringExtra("task1"));



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
                lastTimeStop=timeLeft;
                lastTimeStart=timeStart;
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Timer.this, MainActivity.class);
                startActivity(intent);
            }
        });

        nextTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    currentTask.setText(tasks[taskCounter]);
                    taskCounter++;
                }
                catch(Exception e){
                    currentTask.setText("End of your tasks!");
                }

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
    private void startTimer(){
        countDownTimer=new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft=millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() { //when timer is finished, the pause button is changed to start and only the reset is visible
                isTimerRunning=false;
                pause.setText("start");
                pause.setVisibility(View.INVISIBLE);
                reset.setVisibility(View.VISIBLE);

            }
        }.start();
        isTimerRunning=true;
        pause.setText("pause");
        reset.setVisibility(View.INVISIBLE);
    }
    private void setTimer()
    {
        timeLeft=lastTimeStop;
        updateCountDownText();
        reset.setVisibility(View.INVISIBLE);
        pause.setVisibility(View.VISIBLE);
    }
    private void pauseTimer()
    {
        countDownTimer.cancel();
        isTimerRunning=false;
        pause.setText("start");
        reset.setVisibility(View.VISIBLE);
    }
    private void resetTimer(){
        timeLeft=timeStart;
        updateCountDownText();
        reset.setVisibility(View.INVISIBLE);
        pause.setVisibility(View.VISIBLE);
    }
    private void updateCountDownText()
    {
        int minutes=(int) (timeLeft/1000)/60;
        int seconds=(int) (timeLeft/1000)%60;

        String timeLeftFormatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        countdown.setText(timeLeftFormatted);
    }


}