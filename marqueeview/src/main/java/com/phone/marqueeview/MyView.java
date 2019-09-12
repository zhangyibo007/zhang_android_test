package com.phone.marqueeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static android.R.attr.angle;

/**
 * Created by zhang on 2018/6/18.
 */

public class MyView extends View {
    private Paint paint1;
    private Paint paint2;
    private Paint paint3;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        int height = getHeight();
        int width = getWidth();

        paint1.setColor(Color.rgb(205, 243, 246));
        paint2.setAlpha(200);
        paint2.setColor(Color.rgb(150, 206, 231));
        paint3.setAlpha(150);
        paint3.setColor(Color.rgb(89, 186, 231));
        double lineX = 0;
        double lineY1 = 0;
        double lineY2 = 0;
        double lineY3 = 0;
        for (int i = 0; i < width; i++) {
            lineX = i;
            if (true) {
                lineY1 = Math.sin((i + angle) * Math.PI / 180);
                lineY2 = 10 * Math.sin((i + angle) * Math.PI / 180) + 20;
                lineY3 = 20 * Math.sin((i + angle) * Math.PI / 180) + 50;
            } else {
                lineY1 = 0;
                lineY2 = 20;
                lineY3 = 50;
            }
            canvas.drawLine((int) lineX, (int) (lineY1 + height / 1.5),
                    (int) lineX + 1, (int) (lineY2 + height / 1.5), paint1);
            canvas.drawLine((int) lineX, (int) (lineY2 + height / 1.5),
                    (int) lineX + 1, (int) (lineY3 + height / 1.5), paint2);
            canvas.drawLine((int) lineX, (int) (lineY3 + height / 1.5),
                    (int) lineX + 1, height, paint3);
        }

    }

}
