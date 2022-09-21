package com.example.day3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

//create SurfaceView subclass to draw own things
// ** Need to link this class to SurfaceView layout element in XML file to it knows to use this more specific version
public class MySurfaceView extends SurfaceView implements SeekBar.OnSeekBarChangeListener,
        View.OnClickListener, View.OnTouchListener{

    private Spot bigSpot;
    private TextView progressText;
    private Paint imgPaint;
    private ArrayList<Spot> spots;

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

        spots = new ArrayList<Spot>();

    }

    //tell view what to draw
    protected void onDraw(Canvas canvas){
        //DO NOT allocate anything in this method, memory use optimization

        //if toggle is on it draws
        if(toggle) {
            bigSpot.draw(canvas);
        } else {
            canvas.drawBitmap(image, 2 * position, 50, imgPaint);
        }

        for(Spot s : spots){
            //s.setCenters(s.getCx(),s.getCy() + 5);
            s.draw(canvas);
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

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        if(event.getActionMasked() == MotionEvent.ACTION_DOWN) { //static access for MotionEvent
            //get location of tap
            float x = event.getX();
            float y = event.getY();

            //iterate through all spots to see if any spots match
            for(Spot s : spots){
                if((s.getCx() > x - 50 && s.getCx() < x + 50) && (s.getCy() > y - 50 && s.getCy() < y + 50)){
                    spots.remove(s);
                    invalidate();
                    return true; //consumed event
                }
            }

            //if no spot is found to remove, adds the new spot to arraylist
            Spot newSpot = new Spot();
            newSpot.setCenters(x,y);
            spots.add(newSpot);
            invalidate();

            return true; //consumed event
        }
        return false; //nothing was done
    }
}
