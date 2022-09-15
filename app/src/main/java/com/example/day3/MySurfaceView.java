package com.example.day3;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;

//create SurfaceView subclass to draw own things
// ** Need to link this class to SurfaceView layout element in XML file to it knows to use this more specific version
public class MySurfaceView extends SurfaceView implements SeekBar.OnSeekBarChangeListener{

    private Spot bigSpot;
    private TextView progressText;

    public MySurfaceView(Context context, AttributeSet attrs){
        super(context, attrs); //call parent constructor
        //enable drawing
        setWillNotDraw(false);
        //set up any required member variables

        bigSpot = new Spot();
        bigSpot.setCenters(550,550);

    }
    //tell view what to draw
    protected void onDraw(Canvas canvas){
        //DO NOT allocate anything in this method, memory use optimization
        bigSpot.draw(canvas);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        bigSpot.setRadius(progress);
        progressText.setText(""+progress);
        invalidate();       //tell surfaceview that old view is no longer valid, should redraw

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    public void setProgressText(TextView progressText){
        this.progressText = progressText;
    }

}
