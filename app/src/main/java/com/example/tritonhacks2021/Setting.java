package com.example.tritonhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    Button nextButton;
    Button backButton;
    Spinner roundsSpinner;
    SeekBar studyTime;
    SeekBar breakTime;
    Spinner themeSpinner;
    TextView studyTimeBox;
    TextView breakTimeBox;
    String rounds;
    String theme;


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
        studyTimeBox=findViewById(R.id.textview_study_setting);
        breakTimeBox=findViewById(R.id.textview_break_setting);

        //setting the spinner
        String[] roundsChoices={"1","2","3","4","5"};
        ArrayAdapter aa=new ArrayAdapter(this, android.R.layout.simple_spinner_item,roundsChoices);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roundsSpinner.setAdapter(aa);

        //"Christmas","Blizzard","Space","Spring","Forest"
        String[] themesChoices={"Default","Red","Green","Black", "magenta","Tzuching"};
        ArrayAdapter ab=new ArrayAdapter(this, android.R.layout.simple_spinner_item,themesChoices);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themeSpinner.setAdapter(ab);

        themeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                theme=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        roundsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rounds= parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        studyTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress=10*progress;
                studyTimeBox.setText(String.valueOf(progress));
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

                breakTimeBox.setText(String.valueOf(progress));

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
                intent.putExtra("studyValue",studyTimeBox.getText());
                intent.putExtra("breakValue",breakTimeBox.getText());
                intent.putExtra("rounds",rounds);
                intent.putExtra("theme",theme);
                startActivity(intent);

            }
        });
    }

}