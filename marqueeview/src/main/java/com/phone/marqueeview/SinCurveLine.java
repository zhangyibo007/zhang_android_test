package com.phone.marqueeview;

/**
 * Created by zhang on 2018/6/18.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 绘制正弦曲线
 *
 */
public class SinCurveLine extends SurfaceView implements SurfaceHolder.Callback{

    private static final String TAG = "SinCurveLine";

    Paint paint;
    int x = 100;
    SurfaceHolder surfaceHolder;
    Canvas canvas;

    public SinCurveLine(Context context) {
        this(context, null);
        Log.d(TAG, "SinCurveLine");
    }

    public SinCurveLine(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SinCurveLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.parseColor("#a1a1a1"));
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);
    }

    /**
     * 角度转换成弧度
     * @param degree
     * @return
     */
    private double degreeToRad(double degree){
        return degree * Math.PI/180;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d(TAG,"surfaceCreated");
        init();
        final int width = getWidth();
        int height = getHeight();
        final int centerY = height/2;
        canvas = surfaceHolder.lockCanvas();
        canvas.drawColor(Color.WHITE);
        paint.setTextSize(50);
        canvas.drawText("正", 0, 50, paint);
        canvas.drawText("反",0,height-25,paint);
        canvas.drawLine(0, centerY, width, centerY, paint);//在屏幕中心绘制x轴
        canvas.drawLine(100, 0, 100, height, paint);//绘制Y轴
        while (x < width) {
            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(2);
            double rad = degreeToRad(x);//角度转换成弧度
            int y = (int) (centerY - Math.sin(rad)*100);
//            int y = (int)Math.random()*height;
            canvas.drawPoint(x,y,paint);
            x++;

            canvas.drawLine(100,centerY,x,y,paint);
            /*
            * 打开注释，运行代码，会看到意外图形
            */
        }
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}