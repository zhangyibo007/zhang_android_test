package com.phone.mpandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 实心圆显示
     * @param view
     */
    public void showHodleCricle(View view){
        startActivity(new Intent(this,HodleCricle.class));
    }

//    雷达图
    public void showRadarChart(View view){
        startActivity(new Intent(this,MRadarChart.class));
    }
//    柱状图
    public void showBarChart(View view){

        startActivity(new Intent(this,KindBarChart.class));
    }
//    折线图
    public void showLinChart(View view){
        startActivity(new Intent(this,LinCharts.class));
    }
}
