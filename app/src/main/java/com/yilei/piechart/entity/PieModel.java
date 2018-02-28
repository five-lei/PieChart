package com.yilei.piechart.entity;

import java.io.Serializable;

/**
 * Created by lei on 2018/2/27.
 */

public class PieModel implements Serializable{
    private float percentage;//占比
    private String name;//名称
    private String color;//颜色

    @Override
    public String toString() {
        return "PieModel{" +
                "percentage=" + percentage +
                ", name='" + name + '\'' +
                ", color=" + color +
                '}';
    }

    public PieModel(float percentage, String name, String color) {
        this.percentage = percentage;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }


}
