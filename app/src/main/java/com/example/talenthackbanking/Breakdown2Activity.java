package com.example.talenthackbanking;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Breakdown2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakdown2_screen);

        PieChart pie2 = findViewById(R.id.piechart2);
        pie2.setUsePercentValues(true);


        ArrayList <PieEntry> valueList2 = new ArrayList<>();
        valueList2.add(new PieEntry((float) 0.08, "Subscriptions"));
        valueList2.add(new PieEntry((float) 0.2, "utilities"));
        valueList2.add(new PieEntry((float) 0.3, "food"));
        valueList2.add(new PieEntry((float) 0.2, "travel"));
        valueList2.add(new PieEntry((float) 0.22, "other"));


        PieDataSet dataSet2 = new PieDataSet(valueList2, "Spend 2020 so far ");


        PieData pieData2 = new PieData(dataSet2);

        pie2.setData(pieData2);

        dataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
    }

}
