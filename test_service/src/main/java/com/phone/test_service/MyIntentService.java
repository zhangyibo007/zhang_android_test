package com.phone.test_service;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by zhang on 2018/4/26.
 */

public class MyIntentService extends IntentService {


    /**
     * 无参数构造方法必须实现，而且需要的调用父类的构造方法传入字符串作为线程名称
     */
    public MyIntentService(){
        super("MyIntentService");
    }

    //生命周期方法
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 此方法用与接收传递过来数据，进行耗时操作，最终更新UI,任务执行完成之后，就会自动结束
     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
            //耗时操作
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }



}
