package com.example.day3;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;


public class Spot {
    Random rand = new Random();
    private float cx, cy;
    private float radius;
    private Paint color;

    public Spot(){
        cx = cy = 50;
        radius = rand.nextInt(200) + 10;
        color = new Paint();
        color.setARGB(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }

    public void setRadius(float r){
        if (r > 0) {
            radius = r;
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(cx, cy, radius, color);
    }

    public void setCenters(float x, float y){
        cx = x;
        cy = y;
    }

    public float getCx(){
        return cx;
    }

    public float getCy(){
        return cy;
    }

}
