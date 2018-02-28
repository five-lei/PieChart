package com.yilei.piechart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yilei.piechart.entity.PieModel;
import com.yilei.piechart.view.PieChart;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PieChart pieChart;
    private ArrayList<PieModel> pieModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieModels.add(new PieModel(0.1f, "Android4.4", "#FFC1C1"));
        pieModels.add(new PieModel(0.2f, "Android5.0", "#FFC125"));
        pieModels.add(new PieModel(0.3f, "Android6.0", "#EE0000"));
        pieModels.add(new PieModel(0.4f, "Android7.0", "#A020F0"));
        pieChart = (PieChart) findViewById(R.id.pieChart);
        pieChart.setPieList(pieModels);
    }
}
