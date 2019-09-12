package com.phone.mpandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;


public class LinCharts extends AppCompatActivity {

    private LineChart lineChart,lineChart2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lin_charts);

        initView();
    }

    private void initView() {
        lineChart= (LineChart) findViewById(R.id.lineChart);
        lineChart2= (LineChart) findViewById(R.id.lineChart2);
//        显 示一条折线
        showAlone();
        LineChartManager lineChartManager=new LineChartManager(lineChart2);
        //设置x轴的数据
        ArrayList<Float> xValues = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            xValues.add((float) i);
        }

        //设置y轴的数据()
        List<List<Float>> yValues = new ArrayList<>();

        List<Float> y1Value = new ArrayList<>();
        List<Float> y2Value = new ArrayList<>();

        List<String> lableNameList = new ArrayList<>();
        lableNameList.add("交通运行");
        lableNameList.add("拥挤指数");

        for (int j = 0; j <= 4; j++) {
            float value = (float) (Math.random() * 80);
            y1Value.add(value);
            y2Value.add(value-5);
        }
        yValues.add(y1Value);
        yValues.add(y2Value);

        List<Integer> colorList = new ArrayList<>();
        colorList.add(Color.parseColor("#6785f2"));
        colorList.add(Color.parseColor("#eecc44"));
        lineChartManager.showLineChart(xValues, yValues, lableNameList, colorList);
        lineChartManager.setDescription("");

    }

    private void showAlone() {
        LineChartManager lineChartManager=new LineChartManager(lineChart);

        List<Float> xAxisValues=new ArrayList<>();
        List<Float> yAxisValues=new ArrayList<>();
        xAxisValues.add(0.0f);
        xAxisValues.add(1.0f);
        xAxisValues.add(2.0f);
        xAxisValues.add(3.0f);
        xAxisValues.add(4.0f);
        xAxisValues.add(5.0f);
        yAxisValues.add(50f);
        yAxisValues.add(60f);
        yAxisValues.add(70f);
        yAxisValues.add(40f);
        yAxisValues.add(80f);
        yAxisValues.add(60f);
        lineChartManager.showLineChart(xAxisValues,yAxisValues,"", Color.parseColor("#da6268"));
    }
}
