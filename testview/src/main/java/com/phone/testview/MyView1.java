package com.phone.testview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhang on 2018/7/18.
 */

public class MyView1 extends View {

    public float getDegrees() {
        return degrees;
    }

    private float degrees = 0;          //旋转角度
    public void setRotate(float degrees) {
        this.degrees = degrees;
        invalidate();                   //重绘界面
    }
    private Paint whitePaint,blackPaint;

    public MyView1(Context context) {
        super(context);
        initPaint();
    }



    public MyView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        whitePaint=new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.WHITE);

        blackPaint=new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setAntiAlias(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        canvas.translate(width/2,height/2);

        canvas.drawColor(Color.GRAY);
        canvas.rotate(degrees);
        int radius = Math.min(width / 2, height / 2)-100;

        RectF rectf=new RectF(-radius,-radius,radius,radius);
        canvas.drawArc(rectf,90,180,true,blackPaint);

        canvas.drawArc(rectf,-90,180,true,whitePaint);


        canvas.drawCircle(0,-radius/2,radius/2,blackPaint);

        canvas.drawCircle(0,radius/2,radius/2,whitePaint);

        canvas.drawCircle(0,-radius/2,radius/8,whitePaint);
        canvas.drawCircle(0,radius/2,radius/8,blackPaint);



    }
}
