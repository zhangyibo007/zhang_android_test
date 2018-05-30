package com.phone.test_broadcastreceiver;

import android.app.AppOpsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity {
    MyDynamicBroadCastReceiver myDynamicBroadCastReceiver;
    LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerBroadCastReceiver();

        registerReceiverLocal();

        boolean b = checkCanDrawOverlays();

        Log.e("TAG", "===============b:"+b);


    }


    public boolean checkCanDrawOverlays(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Log.e("TAG", "大于8.0================="+checkCanDrawOverlays26());
            return  checkCanDrawOverlays26();
        }else {
            Log.e("TAG", "小于8.0================="+ Settings.canDrawOverlays(this));
            return  Settings.canDrawOverlays(this);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean checkCanDrawOverlays26(){
        AppOpsManager appOpsMgr = (AppOpsManager) this.getSystemService(Context.APP_OPS_SERVICE);
        if (appOpsMgr == null){
            return false;
        }else{
            int mode = appOpsMgr.checkOpNoThrow("android:system_alert_window", android.os.Process.myUid(), this
                    .getPackageName());
            Log.e("TAG", "mode========="+mode);
            return mode == AppOpsManager.MODE_ALLOWED || mode == AppOpsManager.MODE_IGNORED;
        }
    }

    /**
     * 注册广播
     */
    private void registerReceiverLocal() {
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        IntentFilter filter=new IntentFilter();
        filter.addAction("com.org.localreceiver");
        localBroadcastManager.registerReceiver(myDynamicBroadCastReceiver,filter);
    }


    /**
     * 发送本地广播
     */
    public void sendLocalReceiver(){

        Intent intent=new Intent();
        intent.setAction("com.org.localreceiver");
        localBroadcastManager.sendBroadcast(intent);
    }

    /**
     * 2)注册广播
     */
    private void registerBroadCastReceiver() {
         myDynamicBroadCastReceiver = new MyDynamicBroadCastReceiver();
        IntentFilter intent=new IntentFilter();
        intent.addAction("com.org.mydynamicbroadcastreceiver");
        registerReceiver(new MyDynamicBroadCastReceiver(),intent);
    }

    public void sendBroadCastReceiverStatic(View view){
        Intent intent=new Intent();
        intent.setAction("com.org.mybroadcastreceiver");
        intent.putExtra("name","我是通过静态注册的普通广播");
        sendBroadcast(intent);
    }

    /**
     * 4）发送广播
     * @param view
     */
    public void sendBroadCastReceiverDynamic(View view){
        Intent intent=new Intent();
        intent.setAction("com.org.mydynamicbroadcastreceiver");
        intent.putExtra("name","我是通过动态注册的普通广播");
        sendBroadcast(intent);
    }

    public void sendBroadCastReceiverSort(View view){
        Intent intent=new Intent();
        intent.setAction("com.org.mysortbroadcastreceiver");
        intent.putExtra("name","我是有序广播");
        sendOrderedBroadcast(intent,null,new PriorityBroadcastReceiver.LowPriority(),new Handler(),0,null,null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //3）解注册广播释放资源
        unregisterReceiver(myDynamicBroadCastReceiver);
        localBroadcastManager.unregisterReceiver(myDynamicBroadCastReceiver);
    }

    /**
     * 1)自定义广播类
     */
    class MyDynamicBroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("TAG", "==============="+intent.getStringExtra("name"));
        }
    }


}
