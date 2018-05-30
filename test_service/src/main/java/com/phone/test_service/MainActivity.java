package com.phone.test_service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    public MyService.Mybinder myBinder;
    private ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //绑定成功之后返回service实际上就是Myservice中的Mybinder内部类
            myBinder= (MyService.Mybinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("TAG", "Service connected  error"+name.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


//    public  void startService(View view){
//        intent=new Intent(this,MyService.class);
//        startService(intent);
//    }
//
//    public  void stopService(View view){
//        if(null!=intent) {
//            stopService(intent);
//        }
//
//    }

    public  void callMethodgetNumber(View view){
        if(null!=myBinder){
            MyService myservice = myBinder.getMyservice();
            int number = myservice.getNumber();
            Toast.makeText(this,number+"",Toast.LENGTH_LONG).show();
        }


    }

    public  void callMethodgetName(View view){
        if(null!=myBinder){
            String name = myBinder.getName();
            Toast.makeText(this,name+"",Toast.LENGTH_LONG).show();
        }
    }

    public  void bindService(View view){
        intent=new Intent(this,MyService.class);
        bindService(intent,conn, Service.BIND_AUTO_CREATE);
    }

    public  void unbindService(View view){
        if(null!=conn){
            unbindService(conn);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(conn!=null){
            unbindService(conn);
        }
    }
}
