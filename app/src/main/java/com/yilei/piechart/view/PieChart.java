package com.yilei.piechart.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.yilei.piechart.R;
import com.yilei.piechart.entity.PieModel;

import java.util.ArrayList;

/**
 * Created by lei on 2018/2/27.
 * 饼状图，根据百分比展示不同的扇形及颜色
 */

public class PieChart extends View{
    private Paint mPaint;
    private RectF rectF;
    private int radius;//半径
    private int interval;//每个区域之前得间隙
    private ArrayList<PieModel> pieModels;
    private int startingAngle = 0;//每个区域得起始角度


    public PieChart(Context context) {
        this(context, null);
    }

    public PieChart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PieChart);
        radius = typedArray.getInt(R.styleable.PieChart_radius, 0);
        interval = typedArray.getInt(R.styleable.PieChart_interval, 0);
        typedArray.recycle();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        rectF = new RectF(0, 0, 2 * radius, 2 * radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i = 0; i < pieModels.size(); i++){
            //设置每个区域画笔的颜色
            mPaint.setColor(Color.parseColor(pieModels.get(i).getColor()));
            canvas.drawArc(rectF,
                    startingAngle,
                    360*(pieModels.get(i).getPercentage()),
                    true,
                    mPaint);
            //每块区域的起始角度都不一样，所以需要计算
            startingAngle += 360*(pieModels.get(i).getPercentage());
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setPieList(ArrayList<PieModel> pieList){
        this.pieModels = pieList;
    }

    /**
     * 设置半径
     * @param radius
     */
    public void setRadius(int radius){
        this.radius = radius;
    }

    /**
     * 获取半径
     * @return
     */
    public int getRadius(){
        return this.radius;
    }

    /**
     * 设置每个区域之间的间隙
     * @param interval
     */
    public void setInterval(int interval){
        this.interval = interval;
    }

    /**
     * 获取每个区域之间的间隙
     * @return
     */
    public int getInterval(){
        return this.interval;
    }
}
