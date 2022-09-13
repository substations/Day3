package com.example.day3;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;


public class ViewController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private TextView helloText;
    private TextView progressText;
    private int numClicks;

    public ViewController(TextView ht, TextView pt){
        progressText = pt;
        helloText = ht;
        numClicks = 0;
    }
    @Override
    public void onClick(View v){
        if (v.getId() == R.id.goodbyeButton){
            helloText.setText("goodbye (clicks: " + ++numClicks + ")");
        }else if (v.getId() == R.id.helloButton){
            helloText.setText("hello (clicks: " + ++numClicks + ")");
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
        progressText.setText("" + progress);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}


