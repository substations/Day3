package com.example.day3;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Spot {
    private float cx, cy;
    private float radius;
    private Paint color;

    public Spot(){
        cx = cy = 50;
        radius = 50;
        color = new Paint();
        color.setARGB(255, 255, 0, 0);
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
}
