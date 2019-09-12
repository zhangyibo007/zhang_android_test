package com.phone.testview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhang on 2018/7/16.
 */

public class MyCustomView extends View {

    private Path path;
    private Paint paint;

    public MyCustomView(Context context) {
        this(context,null);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        intView(context);
    }

    private void intView(Context context) {
        path=new Path();
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.parseColor("#FF0000"));

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        DrawLine(canvas);
//        drawRect(canvas);
//        DrawTixing(canvas);
//        drawCirCle(canvas);
//        drawArc(canvas);
        // 实例：合并矩形路径和圆形路径

        // 为了方便观察,平移坐标系
        canvas.translate(350, 500);
        // 创建路径的对象
        Path pathRect = new Path();
        Path  pathCircle = new Path();
        // 画一个矩形路径
        pathRect.addRect(-200, -200, 200, 200, Path.Direction.CW);
        // 画一个圆形路径
        pathCircle.addCircle(0, 0, 100, Path.Direction.CW);

        // 将圆形路径移动(0,200),再添加到矩形路径里
        pathRect.addPath(pathCircle, 0, 200);

        // 绘制合并后的路径
        canvas.drawPath(pathRect,paint);


    }

    private void drawArc(Canvas canvas) {
        // 将一个圆弧路径添加到一条直线路径里
        // 为了方便观察,平移坐标系
        canvas.translate(350, 500);

        // 先将原点(0,0)连接点(100,100)
        path.lineTo(50, 200);

        // 添加圆弧路径(2分之1圆弧)

        // 不连接最后一个点与圆弧起点
        path.addArc(new RectF(0, 0, 300, 300), 0, 360);
        // path.arcTo(oval,0,270,true);             // 与上面一句作用等价

        // 连接之前路径的结束点与圆弧起点
//        path.arcTo(new RectF(200, 200, 300, 300), 0, 350);
        // path.arcTo(oval,0,270,false);             // 与上面一句作用等价

        // 画出路径
        canvas.drawPath(path, paint);
    }

    private void drawCirCle(Canvas canvas) {
        // 将Canvas坐标系移到屏幕正中
        canvas.translate(400,500);

        // 起点是(0,0)，连接点(-100,0)
        path.lineTo(-100,0);
        // 画圆：圆心=(0,0)，半径=100px
        // 此时路径起点改变 = (0,100)（记为起点2）
        // 起点改变原则：新画图形在x轴正方向的最后一个坐标
        // 后面路径的变化以这个点继续下去
        path.addCircle(0,0,100, Path.Direction.CCW);

        // 起点为：(0,100)，连接 (-100,200)
        path.lineTo(-100,200);
        // 连接 (200,200)
        path.lineTo(200,200);

        // 闭合路径，即连接当前点和起点（注：闭合的是起点2）
        // 即连接(200,200)与起点2(0,100)
        path.close();

        // 画出路径
        canvas.drawPath(path,paint);
    }

    private void DrawTixing(Canvas canvas) {
        canvas.translate(400,500);

        // 起点是(0,0)，连接点(-100,0)
        path.lineTo(-100,0);
        // 连接点(-100,200)
        path.lineTo(-100,200);
        // 连接点(200,200)
        path.lineTo(200,200);
        // 闭合路径，即连接当前点和起点
        // 即连接(200,200)与起点是(0,0)
        path.close();

        // 画出路径
        canvas.drawPath(path,paint);
    }

    private void drawRect(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        canvas.translate(measuredWidth/2,measuredHeight/2);

        RectF rect=new RectF(0, 0, 400, 400);
//        顺时针
//        path.addRect(rect,Path.Direction.CW);
//        逆时针
        path.addRect(rect, Path.Direction.CCW);
        canvas.drawPath(path,paint);
    }

    private void DrawLine(Canvas canvas) {
        // 使用moveTo（）
        // 起点默认是(0,0)
        //连接点(400,500)

        path.lineTo(400, 500);

        // 将当前点移动到(300, 300)
        path.moveTo(300, 300);

        //连接点(900, 800)
        path.lineTo(900, 800);
        path.lineTo(200, 700);

        // 闭合路径，即连接当前点和起点
        // 即连接(200,700)与起点2(300, 300)
        // 注:此时起点已经进行变换

//        path.reset();
//        path.rewind();

        path.lineTo(100,100);
        path.close();
        // 画出路径
        canvas.drawPath(path, paint);
    }


}
