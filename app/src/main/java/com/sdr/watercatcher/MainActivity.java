package com.sdr.watercatcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sdr.watercatcher.views.Pillars;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView textView = new TextView(this);
        textView.setText("This is my custom textview");

        int[] pillars = HW.generateArray();
        int[] water = HW.getWaterValues(pillars);
        for (int i =0 ;i <pillars.length;i++) {
            Log.d(TAG, "Pillars.length: " + pillars.length);
            Log.d(TAG, "MainActivity pillars[i]: " + pillars[i]);

        }
        Pillars myPillarView = new Pillars(this, pillars, water);



//        myPillarView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) Tools.convertDpToPixel(200, this)));

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.root_layout);

        rootLayout.addView(textView);
        rootLayout.addView(myPillarView);

    }
}
