package com.sdr.watercatcher;

import android.util.Log;

import com.sdr.watercatcher.views.Pillars;

import java.util.Random;

/**
 * Created by user on 10/11/15.
 */
public class HW {

    private static final String TAG = "HW";

    public static int[] generateArray(){

        Random random = new Random();

        int size = Pillars.AMT_OF_PILLARS;

        int[] array = new int[size];

        for (int i = 0 ; i< size; i++){
            // 20 will be the maximum height of the poles, but this can change
            array[i] = random.nextInt(20);
            Log.d(TAG,"generateArray in action: " +array[i]+"    i:"+ i );
        }

        return array;
    }


    public static int[] getWaterValues(int[] pillars){
      int [] waterFill = new int[pillars.length];
        for (int i = 0 ; i <pillars.length;i++){
            //wrorng at first
            if (pillars[i]<18){
                waterFill[i] =pillars[i]+2;
//                Log.d(TAG,"getWaterValues pillars: " +pillars[i] );

            }
        }
        return waterFill;
    }

}
