package com.sdr.watercatcher.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by user on 10/11/15.
 */
public class Pillars extends View {
    int [] arrayPuddlePosition;
    public static final int AMT_OF_PILLARS = 15;
    private static final int MAX_PILLAR_HEIGHT = 20;
    private static final String TAG ="Pillars";

    private static final Rect[] pillarArray = new Rect[AMT_OF_PILLARS];
    private static int[] pillarValues;
    public static int[] temporaryPillarValues = new int [15];

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
        Log.d(TAG,"Constructor pillars[0] : " +pillars[0] );

        waterValues = water;
    }

    public Pillars(Context context, AttributeSet attrs) {
        super(context, attrs);

//        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Pillars);
//        int pillarAmtFromXML = a.getInteger(R.styleable.Pillars_pillarAmt, AMT_OF_PILLARS);
//        Log.d(TAG, "The pillar value from xml is "+pillarAmtFromXML);
    }
    public void SetUpTemporaryPillarValues(int[] pillarValues){
        for (int i = 0;i<pillarValues.length;i++){
            int test =  Math.abs(pillarValues[i]-20);
            temporaryPillarValues[i] = test;
//            Log.d("testing","test: "+test);
//            Log.d("testing","i; "+i+" temporaryPillarValues[i]: "+temporaryPillarValues[i]);
//            Log.d("testing","i; "+i+" pillarValues[i]: "+pillarValues[i]);

        }
    }
    public void initSize(){
        pillarWidth = getWidth() / AMT_OF_PILLARS;
        gridSquareHeight = getHeight() / MAX_PILLAR_HEIGHT;
        Log.d(TAG,"gridSquareHeight: "+gridSquareHeight);
        Log.d(TAG,"getWidth(): "+getWidth());
    }

    public void initPillarArray(){
        for (int i = 0; i < AMT_OF_PILLARS; i++){
            pillarArray[i] = new Rect();//left,top,right,bottom
        }
    }

    public void initWaterArray(){
        for (int i = 0; i < AMT_OF_PILLARS; i++){
            waterArray[i] = new Rect();
        }
    }


    public void calculatePillarPositions(){
        // we have or pillarArray and pillarValues
//        Log.d(TAG,"calculatePillarPositions pillarWidth: " +pillarWidth );
//        Log.d(TAG,"calculatePillarPositions gridSquareHeight: " +gridSquareHeight );



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

//        canvas.drawColor(Color.GRAY);
//        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//        paint.setColor(color);

        paint.setColor(Color.rgb(152,251,152));
        Log.d(TAG, "pillarValues.length" + pillarValues.length);
        for (int i = 0 ;i<pillarValues.length;i++){
            drawPillars(canvas, paint);
        }


        paint.setColor(Color.BLUE);
        drawWater(canvas, paint);

    }


    int position;
    private void drawPillars(Canvas canvas, Paint paint) {
        // loop through the pillar rect array and call canvas.drawRect(rect, paint)
//        for (int i = 0;i <AMT_OF_PILLARS;i++) {//canvas.getClipBounds()
//        canvas.drawRect(10, 20, 35, 1050, paint);//left,top,right,bottom
        SetUpTemporaryPillarValues(pillarValues);
        for (int i = 0; i < AMT_OF_PILLARS; i++ ){//15 pillars
            Log.d(TAG,"i"+i+"          pillar       pillarValues[i]"+pillarValues[i]);
            position = i;
            float a= i*pillarWidth;//left
            float b=pillarValues[i]*20;//top////////////////////////////////////////
            float c= (i*pillarWidth)+pillarWidth;;//right
            float d= getHeight();//bottom
            canvas.drawRect(a, b, c, d, paint);//left,top,right,bottom

            Log.d(TAG,"a:"+a+" b: "+b+" c:"+c+" d:"+d);
        }
    }


//    }

    private void drawWater(Canvas canvas, Paint paint) {
        Log.d(TAG, "drawWater was called");
        // myResult = new MyResult();
        MyResult myResult = checkForTheHighest(temporaryPillarValues);
        for (int i = 0 ;i<myResult.waterPuddle.length;i++){
            Log.d(TAG,"drawWater...........  waterPuddle"+myResult.waterPuddle[i]);
        }


        int [] arrayOfMatching = myResult.arrayOfTheTwoHighestPositions;

        if (myResult.waterPuddle.length>0){

            for (int i = myResult.waterPuddle[0]; i < myResult.waterPuddle.length; i++ ){//15 pillars
                Log.d(TAG,"i: "+i+"           water       pillarValues[i]:  "+pillarValues[i]);
//will try to matchUp if i matches waterPuddle


                float a= myResult.waterPuddle[i]*pillarWidth;//left
                float b=0;//top
                float c= (myResult.waterPuddle[i]*pillarWidth)+pillarWidth;;//right
                float d= pillarValues[i]*20;//bottom///////////////////////////////////////////
                canvas.drawRect(a, b, c, d, paint);//left,top,right,bottom

                Log.d(TAG,"a:"+a+" b: "+b+" c:"+c+" d:"+d);
            }
        }



    }
    public MyResult checkForTheHighest(int[] temporaryPillarValues) {

        int[] array = new int[2];

        int position1 = -1;
        int position2 = -1;
        boolean found = false;
        MyResult myResult =  TwoMaxNumbersPositions(temporaryPillarValues);

        int[] twoMaxNumbersPosition = myResult.arrayOfTheTwoHighestPositions ;
        arrayPuddlePosition = myResult.waterPuddle;//lets see if this works
//        Log.d(TAG, "arrayPuddlePosition.length:" +arrayPuddlePosition.length);
//        for (int i = 0 ;i<arrayPuddlePosition.length;i++){//we are assigning the values into the arrayPuddlePosition
        //arrayPuddlePosition needs only to know the position to make the puddle
//            arrayPuddlePosition[i] = twoMaxNumbersPosition[i];
//            Log.d("testing","i: "+i+"  arrayPuddlePosition[i]:  "+arrayPuddlePosition[i]);

//        }
        Log.d("testing","twoMaxNumbers 1: "+ twoMaxNumbersPosition[0]+ " twoMaxNumbers 2:"+twoMaxNumbersPosition[1]);

        for (int i = 0 ;i<temporaryPillarValues.length;i++){
            Log.d("testing","i: "+i+"  temporaryPillarValues[i]:  "+temporaryPillarValues[i]);
        }
        Log.d("testing","position1: "+position1);
        Log.d("testing","position2: "+position2);
        array[0] = position1;
        array[1] = position2;
        myResult.arrayOfTheTwoHighestPositions = array;
        myResult.foundMatching = found;
        return myResult;
    }

    private boolean checkIfItGoesBackUp(int a ,int b) {
        if (b>a){
            return true;
        }
        return false;
    }
    public MyResult TwoMaxNumbersPositions(int[] nums){

        int pos1 = 0;
        int pos2 = 0;
        int[] array = new int[2];

        int maxOne = 0;
        int maxTwo = 0;
        for(int n:nums){
            if(maxOne < n){
                maxTwo = maxOne;
                maxOne =n;
            } else if(maxTwo < n){
                maxTwo = n;
            }
        }
        for (int i = 0 ;i< nums.length;i++){
            if (nums[i]==maxOne){
                pos1 = i;
            }
            if (nums[i]==maxTwo){
                pos2 = i;
            }
        }
        if (pos1>pos2){
            int temp = pos1;
            pos1 = pos2;
            pos2 =temp;
        }
        Log.d(TAG,"pos1: "+pos1+"   pos2:"+pos2);
        array[0] =pos1;
        array[1] =pos2;
        MyResult myResult = new MyResult();
        myResult.arrayOfTheTwoHighestPositions = array;
        myResult.sizeArrayOfTheTwoHighest = pos2 - pos1 -1;

        ArrayList<Integer> wp = new ArrayList<>();
        for (int i = 1 ; i<  pos2 - pos1 -1;i++){
//            waterPuddle[0] = pos1+i;
            wp.add(pos1+i);
//            if (waterPuddle.length>1){
//                waterPuddle[i] =waterPuddle[0]+i;
//            }
        }
        int[] waterPuddle = new int[wp.size()];
        for (int i = 0; i < waterPuddle.length; i++) {
            waterPuddle[i] = wp.get(i);
            Log.d(TAG,"waterPuddle: "+waterPuddle[i]+"   i: "+i);
        }
        myResult.waterPuddle = waterPuddle;
        return myResult;
    }
    public class MyResult {
        int []arrayOfTheTwoHighestPositions;
        int []waterPuddle;
        int sizeArrayOfTheTwoHighest;
        boolean foundMatching;
        // etc
    }
}
