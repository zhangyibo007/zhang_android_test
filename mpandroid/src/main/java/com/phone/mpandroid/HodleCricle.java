package com.phone.mpandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class HodleCricle extends AppCompatActivity {

    private PieChart pieChart,pie_chat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hodle_cricle);

        initView();
    }

    private void initView() {
        pieChart = (PieChart) findViewById(R.id.pie_chat1);
        pie_chat2= (PieChart) findViewById(R.id.pie_chat2);
        showhodlePieChart();

        showRingPieChart();
    }

    private void showRingPieChart() {
        //设置每份所占数量
        List<PieEntry> yvals = new ArrayList<>();
        yvals.add(new PieEntry(2.0f, "本科"));
        yvals.add(new PieEntry(3.0f, "硕士"));
        yvals.add(new PieEntry(4.0f, "博士"));
        yvals.add(new PieEntry(5.0f, "大专"));
        yvals.add(new PieEntry(1.0f, "其他"));
        //设置每份的颜色
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#6785f2"));
        colors.add(Color.parseColor("#675cf2"));
        colors.add(Color.parseColor("#496cef"));
        colors.add(Color.parseColor("#aa63fa"));
        colors.add(Color.parseColor("#f5a658"));
        PieChartManagger pieChartManagger=new PieChartManagger(pie_chat2);
        pieChartManagger.showRingPieChart(yvals,colors);
    }

    private void showhodlePieChart() {
        //设置每份所占数量
        List<PieEntry> yvals = new ArrayList<>();
        yvals.add(new PieEntry(2.0f, "汉族"));
        yvals.add(new PieEntry(3.0f, "回族"));
        yvals.add(new PieEntry(4.0f, "壮族"));
        yvals.add(new PieEntry(5.0f, "维吾尔族"));
        yvals.add(new PieEntry(6.0f, "土家族"));
        //设置每份的颜色
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#6785f2"));
        colors.add(Color.parseColor("#675cf2"));
        colors.add(Color.parseColor("#496cef"));
        colors.add(Color.parseColor("#aa63fa"));
        colors.add(Color.parseColor("#58a9f5"));

        PieChartManagger pieChartManagger=new PieChartManagger(pieChart);
        pieChartManagger.showSolidPieChart(yvals,colors);
    }
}
