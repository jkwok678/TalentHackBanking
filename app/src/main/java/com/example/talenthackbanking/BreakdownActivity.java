package com.example.talenthackbanking;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BreakdownActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakdown_screen);
        PieChart pie = findViewById(R.id.piechart);
        pie.setUsePercentValues(true);

        SubscriptionModel model1 = new SubscriptionModel("Netflix Premium-£49.55");
        model1.setPlanCost(9.99);
        model1.setLast30Hours(80);
        model1.setMoneySpentThisYear(49.55);

        SubscriptionModel model2 = new SubscriptionModel("Disney+-£11.98");
        model2.setPlanCost(5.99);
        model2.setLast30Hours(13);
        model2.setMoneySpentThisYear(11.98);
        double total = model1.getMoneySpentThisYear() + model2.getMoneySpentThisYear();
        double model1Percent =model1.getMoneySpentThisYear()/total;
        double model2Parcent = 1- model1Percent;

        ArrayList <PieEntry> valueList = new ArrayList<>();
        valueList.add(new PieEntry((float) model1Percent, model1.getPlanName()));
        valueList.add(new PieEntry((float) model2Parcent, model2.getPlanName()));

        PieDataSet dataSet = new PieDataSet(valueList, "subscriptions 2020 ");


        PieData pieData = new PieData(dataSet);
        pie.setUsePercentValues(true);
        pie.setData(pieData);

        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);



    }
}
