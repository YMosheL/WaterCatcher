package com.sdr.watercatcher;

import java.util.Random;

/**
 * Created by user on 10/11/15.
 */
public class HW {

    public static int[] generateArray(){

        Random random = new Random();

        int size = random.nextInt(15);

        int[] array = new int[size];

        for (int i = 0 ; i< size; i++){
            // 20 will be the maximum height of the poles, but this can change
            array[i] = random.nextInt(20);
        }

        return array;
    }


    public static int[] getWaterValues(int[] pillars){
        //TODO fill this in

        return new int[]{};
    }

}
