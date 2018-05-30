package com.phone.test_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by zhang on 2018/4/27.
 */

public class PriorityBroadcastReceiver  {
    public static class HighPriority extends BroadcastReceiver {
        //高级广播接收者
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("TAG", "优先级高的");
            //传递结果到下一个广播接收器
            int code = 3333;
            String data = "我是有序广播";
            Bundle bundle = null;
            setResult(code, data, bundle);

        }
    }

    public static class MidPriority extends BroadcastReceiver {
        //中级广播接收者
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("TAG", "优先级中等");
            //获取上一个广播接收器结果s
            int code = getResultCode();
            String data = getResultData();
            Log.e("TAG", "获取到上一个广播接收器结果：" + "code=" + code + "data=" + data);
            abortBroadcast();
        }
    }

    public static class LowPriority extends BroadcastReceiver {
        //低级广播接收者
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("TAG", "优先级低的");
            int code = getResultCode();
            String data = getResultData();
            Log.e("TAG", "获取到上一个广播接收器结果：" + "code=" + code + "data=" + data);
        }
    }

}
