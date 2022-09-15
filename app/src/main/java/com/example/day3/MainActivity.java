package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView helloText = findViewById(R.id.hello);
        TextView progressText = findViewById(R.id.progressText);


        //attach progressText to surfaceView
        MySurfaceView surfaceView = findViewById(R.id.surfaceView);
        surfaceView.setProgressText(progressText);

        SeekBar seekBar = findViewById(R.id.progress);
        seekBar.setOnSeekBarChangeListener(surfaceView);


        //attach hello and goodbye buttons to viewcontroller
        ViewController viewController = new ViewController(helloText, progressText);

        Button goodbyeButton = findViewById(R.id.goodbyeButton);
        goodbyeButton.setOnClickListener(viewController);

        Button helloButton = findViewById(R.id.helloButton);
        helloButton.setOnClickListener(viewController);





    }
}