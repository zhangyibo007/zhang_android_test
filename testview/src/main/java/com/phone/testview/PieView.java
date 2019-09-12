package com.phone.testview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by zhang on 2018/7/18.
 */

public class PieView extends View {

    private Paint mPaint;
    private List<PieData> allData;
    private int mWidth,mHeight;
    private  float startAngle=0;
    public PieView(Context context) {
        super(context);
        initView();
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initView();
    }

    private void initView() {
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(allData==null) {
            return;
        }

        canvas.translate(mWidth/2,mHeight/2);
//            圆心半径
        float mRadius= (float) (Math.min(mWidth/2,mHeight/2)*0.8);
//        绘制圆形区域

        RectF rectf=new RectF(-mRadius,-mRadius,mRadius,mRadius);

        for (int i=0;i<allData.size();i++){
            PieData pieData = allData.get(i);
            mPaint.setColor(pieData.getColor());
            canvas.drawArc(rectf,startAngle,pieData.getAngle(),false,mPaint);
            startAngle+=pieData.getAngle();
        }


    }



    public void setPieData(List<PieData> allData){
        this.allData=allData;
        initData();
        invalidate();
    }

    private void initData() {
        if(allData==null){
            return;
        }
        float sumValue=0;
        for (int i=0;i<allData.size();i++){
            PieData pieData = allData.get(i);
            float value = pieData.getValue();
            sumValue+=value;
        }
        for (int i=0;i<allData.size();i++){
            PieData pieData = allData.get(i);
            float angle=pieData.getValue()/sumValue;
            pieData.setAngle(angle*360);
        }
    }
}
