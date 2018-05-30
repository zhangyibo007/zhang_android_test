package com.phone.test_sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    SensorManager sensorManager;
    Sensor lightSensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.获取传感器管理服务
         sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        2.获取手机支持的传感器列表集合
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensorList) {
            Log.e("TAG", "==============="+sensor);
        }
//        3.获取光线传感器
         lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }

    @Override
    protected void onResume() {
        super.onResume();
//        4.注册传感器
        if(sensorManager!=null) {
//            参数1监听接口
//            参数2获取的传感器
//            参数3接收事件的频率 SENSOR_DELAY_UI>SENSOR_DELAY_NORMAL>SENSOR_DELAY_GAME>SENSOR_DELAY_FASTEST
            sensorManager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

//    当传感器接受的事件的时候
    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        Log.e("TAG", "当前亮度==============="+values[0]);
    }

//    当注册传感器的精度改变时调用
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onPause();
//       取消注册
        if(sensorManager!=null){
            sensorManager.unregisterListener(this);
        }
    }
}
