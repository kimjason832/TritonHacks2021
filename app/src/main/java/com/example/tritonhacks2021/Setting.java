package com.example.tritonhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;

public class Setting extends AppCompatActivity {

    Button nextButton;
    Button backButton;
    Spinner roundsSpinner;
    SeekBar studyTime;
    SeekBar breakTime;
    Spinner themeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        nextButton= findViewById(R.id.button_nextsetting_setting);
        backButton= findViewById(R.id.button_backsetting_setting);
        roundsSpinner= findViewById(R.id.spinner_rounds_setting);
        studyTime= findViewById(R.id.seekbar_studytime_setting);
        breakTime=findViewById(R.id.seekbar_breaktime_setting);
        themeSpinner=findViewById(R.id.spinner_theme_setting);

        //setting the spinner
        String[] roundsChoices={"1","2","3","4","5"};
        ArrayAdapter aa=new ArrayAdapter(this, android.R.layout.simple_spinner_item,roundsChoices);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roundsSpinner.setAdapter(aa);

        String[] themesChoices={"Christmas","Blizzard","Space","Spring","Forest"};
        ArrayAdapter ab=new ArrayAdapter(this, android.R.layout.simple_spinner_item,themesChoices);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themeSpinner.setAdapter(ab);

        studyTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        breakTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Setting.this, MainActivity.class);
                startActivity(intent);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Setting.this, Tasks.class);
                startActivity(intent);
            }
        });
    }
}