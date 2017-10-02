package com.example.sertac.renkbelirleyici;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private LinearLayout colorShower;
    private SeekBar redColor,greenColor,blueColor;
    private EditText redColorEdittext,greenColorEdittext,blueColorEdittext;
    int red,green,blue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init() {
        colorShower= (LinearLayout) findViewById(R.id.colorShower);
        redColor= (SeekBar) findViewById(R.id.redColorSeekbar);
            redColor.setMax(255);
        greenColor= (SeekBar) findViewById(R.id.greenColorSeekbar);
            greenColor.setMax(255);
        blueColor= (SeekBar) findViewById(R.id.blueColorSeekbar);
            blueColor.setMax(255);
        redColorEdittext= (EditText) findViewById(R.id.redColorEdittext);
            redColorEdittext.setText(String.valueOf(redColor.getProgress()));
        greenColorEdittext= (EditText) findViewById(R.id.greenColorEdittext);
            greenColorEdittext.setText(String.valueOf(greenColor.getProgress()));
        blueColorEdittext= (EditText) findViewById(R.id.blueColorEdittext);
            blueColorEdittext.setText(String.valueOf(blueColor.getProgress()));
        actionEvent();
    }

    private void actionEvent() {
    redColor.setOnSeekBarChangeListener(this);
    blueColor.setOnSeekBarChangeListener(this);
    greenColor.setOnSeekBarChangeListener(this);
    redColorEdittext.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            red=Integer.parseInt(String.valueOf(s));
            redColor.setProgress(red);
            backgroundChanger(red,green,blue);
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    });
    greenColorEdittext.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
                green=Integer.parseInt(String.valueOf(s));
                greenColor.setProgress(green);
                backgroundChanger(red,green,blue);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });
    blueColorEdittext.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
                blue=Integer.parseInt(String.valueOf(s));
                blueColor.setProgress(blue);
                backgroundChanger(red,green,blue);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });
        backgroundChanger(red,green,blue);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.redColorSeekbar:
                redColorEdittext.setText(String.valueOf(progress));
                break;
            case R.id.greenColorSeekbar:
                greenColorEdittext.setText(String.valueOf(progress));
                break;
            case R.id.blueColorSeekbar:
                blueColorEdittext.setText(String.valueOf(progress));
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void backgroundChanger(int red,int green,int blue){
        colorShower.setBackgroundColor(Color.rgb(red,green,blue));
    }
}
