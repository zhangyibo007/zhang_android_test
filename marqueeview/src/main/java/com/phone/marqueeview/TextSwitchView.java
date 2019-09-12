package com.phone.marqueeview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhang on 2018/6/18.
 */

public class TextSwitchView extends TextSwitcher implements ViewSwitcher.ViewFactory {
    private int index= -1;
    private Context context;
    private Handler mHandler = new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    index = next(); //取得下标值
                    updateText();  //更新TextSwitcherd显示内容;
                    break;
            }
        };
    };
    private String [] resources={
            "静夜思",
            "床前明月光","疑是地上霜",
            "举头望明月",
            "低头思故乡"
    };
    private Timer timer; //
    public TextSwitchView(Context context) {
        super(context);
        this.context = context;
        init();
    }
    public TextSwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }
    private void init() {
        if(timer==null)
            timer = new Timer();
        this.setFactory(this);
        this.setInAnimation(AnimationUtils.loadAnimation(context, R.anim.in_animation));
        this.setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.out_animation));
    }
    public void setResources(String[] res){
        this.resources = res;
    }
    public void setTextStillTime(long time){
        if(timer==null){
            timer = new Timer();
        }else{
            timer.scheduleAtFixedRate(new MyTask(), 1, time);//每3秒更新
        }
    }
    private class MyTask extends TimerTask {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(1);
        }
    }
    private int next(){
        int flag = index+1;
        if(flag>resources.length-1){
            flag=flag-resources.length;
        }
        return flag;
    }
    private void updateText(){
        this.setText(resources[index]);
    }
    @Override
    public View makeView() {
        TextView tv =new TextView(context);
        return tv;
    }
}
