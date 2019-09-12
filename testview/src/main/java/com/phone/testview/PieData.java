package com.phone.testview;

/**
 * Created by zhang on 2018/7/18.
 */

public class PieData  {
//    名字
    private String name;
//    值
    private float  value;
//    颜色
    private int color;
//     角度
    private float angle;

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public PieData() {
    }

    public PieData(String name, float value, int color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    public int getColor() {
        return color;
    }
}
