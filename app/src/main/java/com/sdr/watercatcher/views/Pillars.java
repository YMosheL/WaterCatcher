package com.sdr.watercatcher.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.sdr.watercatcher.R;

/**
 * Created by user on 10/11/15.
 */
public class Pillars extends View {

    private static final int AMT_OF_PILLARS = 15;
    private static final int MAX_PILLAR_HEIGHT = 20;
    private static final String TAG = Pillars.class.getName();

    private static final Rect[] pillarArray = new Rect[AMT_OF_PILLARS];
    private static int[] pillarValues;

    private static final Rect[] waterArray = new Rect[AMT_OF_PILLARS];
    private static int[] waterValues;

    Paint paint = new Paint();

    int pillarWidth;
    int gridSquareHeight;

    public Pillars(Context context, int[] pillars, int[] water) {
        super(context);
        initPillarArray();
        initWaterArray();
        pillarValues = pillars;
        waterValues = water;
    }

    public Pillars(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.Pillars);
        int pillarAmtFromXML =
                a.getInteger(R.styleable.Pillars_pillarAmt, AMT_OF_PILLARS);
        Log.d(TAG, "The pillar value from xml is "+pillarAmtFromXML);
    }

    public void initSize(){
        pillarWidth = getWidth() / AMT_OF_PILLARS;
        gridSquareHeight = getHeight() / MAX_PILLAR_HEIGHT;
    }

    public void initPillarArray(){
        for (int i = 0; i < AMT_OF_PILLARS; i++){
            pillarArray[i] = new Rect();
        }
    }

    public void initWaterArray(){
        for (int i = 0; i < AMT_OF_PILLARS; i++){
            waterArray[i] = new Rect();
        }
    }


    public void calculatePillarPositions(){
        // we have or pillarArray and pillarValues
    }

    public void calculateWaterPositions(){
        // we have or waterArray and waterValues
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        initSize();
        calculatePillarPositions();
        calculateWaterPositions();

        canvas.drawColor(Color.GRAY);

        paint.setColor(Color.GRAY);
        drawPillars(canvas, paint);

        paint.setColor(Color.BLUE);
        drawWater(canvas, paint);

    }

    private void drawPillars(Canvas canvas, Paint paint) {
        // loop through the pillar rect array and call canvas.drawRect(rect, paint)
    }

    private void drawWater(Canvas canvas, Paint paint) {

    }
}
