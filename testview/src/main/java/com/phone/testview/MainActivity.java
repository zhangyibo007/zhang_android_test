package com.phone.testview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        View.MeasureSpec
//        ViewGroup

        initView();
    }

    private void initView() {
        final PieView myView1= (PieView) findViewById(R.id.myview1);
        List<PieData> allData=new ArrayList<>();
        allData.add(new PieData("1",20, Color.RED));
        allData.add(new PieData("2",30, Color.YELLOW));
        allData.add(new PieData("3",40, Color.BLUE));
        allData.add(new PieData("4",50, Color.GREEN));

        myView1.setPieData(allData);
//        myView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"111111",Toast.LENGTH_SHORT).show();
//                myView1.setRotate(myView1.getDegrees()+20);
//            }
//        });

//        final Handler handler = new Handler() {
//            private float degrees = 0;
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                myView1.setRotate(degrees += 2);
//                this.sendEmptyMessageDelayed(0, 20);
//            }
//        };
//
//        handler.sendEmptyMessageDelayed(0, 20);
    }
}
