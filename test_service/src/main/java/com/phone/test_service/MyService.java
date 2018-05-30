package com.phone.test_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zhang on 2018/4/23.
 */

public class MyService extends Service {


    private int count=1;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "onCreate.............................");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<100){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        }).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("TAG", "onBind.............................");
        return new Mybinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("TAG", "onUnbind.............................");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "onDestroy.............................");
    }

    /**
     * 自定义类去继承Binder最终返回给绑定者
     */
    class Mybinder extends Binder{
        MyService getMyservice(){
            return MyService.this;
        }
        public String getName(){
            return "mybinder";
        }

    }

    /**
     * MyService 方法获取count变量
     * @return
     */
    public  int  getNumber(){
        return count;
    }

}
