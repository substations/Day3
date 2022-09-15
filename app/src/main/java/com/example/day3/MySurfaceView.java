package com.example.day3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

//create SurfaceView subclass to draw own things
// ** Need to link this class to SurfaceView layout element in XML file to it knows to use this more specific version
public class MySurfaceView extends SurfaceView implements SeekBar.OnSeekBarChangeListener, View.OnClickListener{

    private Spot bigSpot;
    private TextView progressText;
    private Paint imgPaint;

    private int position;

    private boolean toggle = true;
    Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.duck); //R.drawable.myimage

    public MySurfaceView(Context context, AttributeSet attrs){
        super(context, attrs); //call parent constructor
        //enable drawing
        setWillNotDraw(false);
        //set up any required member variables

        bigSpot = new Spot();
        bigSpot.setCenters(550,550);

        imgPaint = new Paint();
        imgPaint.setColor(Color.BLACK);

    }
    //tell view what to draw
    protected void onDraw(Canvas canvas){
        //DO NOT allocate anything in this method, memory use optimization

        //if toggle is on it draws
        if(toggle) {
            bigSpot.draw(canvas);
        } else {
            canvas.drawBitmap(image, 2*position, 50, imgPaint);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        bigSpot.setRadius(progress);
        position = progress;
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

    @Override
    public void onClick(View view) {
        invalidate();
        toggle = !toggle;
    }
}
