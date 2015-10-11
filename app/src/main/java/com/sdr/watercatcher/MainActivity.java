package com.sdr.watercatcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sdr.watercatcher.utils.Tools;
import com.sdr.watercatcher.views.Pillars;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int x = 9;

        TextView textView = new TextView(this);
        textView.setText("This is my custom textview");

        int[] pillars = HW.generateArray();
        int[] water = HW.getWaterValues(pillars);

        Pillars myPillarView = new Pillars(this, pillars, water);

        x = 17;

        myPillarView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) Tools.convertDpToPixel(200, this)));

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.root_layout);

        rootLayout.addView(textView);
        rootLayout.addView(myPillarView);

    }
}
