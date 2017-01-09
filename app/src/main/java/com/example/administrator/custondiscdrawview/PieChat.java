package com.example.administrator.custondiscdrawview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/10/20.
 */
public class PieChat extends View {

    private Paint mPaint;
    private Paint mPaintCricle;
    private Paint mPaintText;
    private Paint mPaintWai1;

    public PieChat(Context context) {
        super(context);
    }

    public PieChat(Context context, AttributeSet attrs) {
        super(context, attrs);
        initview();
    }

    public PieChat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public  void initview(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        mPaintWai1 = new Paint();
        mPaintWai1.setAntiAlias(true);
        mPaintWai1.setColor(getResources().getColor(R.color.colorPrimaryDark));
        mPaintWai1.setStyle(Paint.Style.FILL);

        mPaintText = new Paint();
        mPaintText.setAntiAlias(true);
        mPaintText.setColor(getResources().getColor(R.color.colorPrimaryDark));

        mPaintCricle = new Paint();
        mPaintCricle.setAntiAlias(true);
        mPaintCricle.setColor(getResources().getColor(R.color.colorPrimaryDark));
        mPaintCricle.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        String fisrt = "一等奖";
        String second= "二等奖";
        String three  =  "三等奖";
        String other="优胜奖";

        int d=getWidth()>getHeight()?getHeight():getWidth();
        int leftheigt=Math.abs(getWidth()-getHeight());
        RectF rectF=new RectF(0+50,leftheigt/2+50,d-50,d+leftheigt/2-50);

        canvas.drawCircle(
                getWidth()/2,//圆心的x坐标
                getHeight()/2,//圆心的y轴坐标
                getHeight()/2-220,//圆形的半径=圆的半径减去刻度的厚度
                mPaintWai1
        );
        RectF rectFCricle=new RectF(0,0,getWidth(),getHeight());
        mPaint.setColor(Color.parseColor("#0000ff"));
        canvas.drawArc(rectF,0,60,true,mPaint);
        mPaint.setColor(Color.parseColor("#ff0000"));
        canvas.drawArc(rectF,60,60,true,mPaint);
        mPaint.setColor(Color.parseColor("#00ff00"));
        canvas.drawArc(rectF,120,60,true,mPaint);
        mPaint.setColor(Color.parseColor("#99cc99"));
        canvas.drawArc(rectF,180,60,true,mPaint);
        mPaint.setColor(Color.parseColor("#ff00ff"));
        canvas.drawArc(rectF,240,60,true,mPaint);
        mPaint.setColor(Color.parseColor("#ffff00"));
        canvas.drawArc(rectF,300,60,true,mPaint);

        canvas.drawCircle(
                getWidth()/2,//圆心的x坐标
                getHeight()/2,//圆心的y轴坐标
                getHeight()/2-450,//圆形的半径=圆的半径减去刻度的厚度
                mPaintCricle
        );

        Path path = new Path();
        path.moveTo(getWidth()/2, getHeight()/2);
        path.lineTo(getWidth()/2-30,  getHeight() / 2 - 400);
        path.close();
        mPaintText.setTextSize(32);

        // 沿路径绘制图片

        for (int j = 1; j < 7; j++) {
            canvas.save();

            canvas.rotate(60 * j, getWidth() / 2, getHeight() / 2);
            if (j == 1) {
                canvas.drawTextOnPath(second, path, 160, 0, mPaintText);//第三个参数为X坐标，第四个为Y坐标
            }
            if (j == 2) {
                canvas.drawTextOnPath(other, path, 160, 0, mPaintText);
            }
            if (j == 3) {
                canvas.drawTextOnPath(second, path, 160, 0, mPaintText);
            }
            if (j == 4) {
                canvas.drawTextOnPath(three, path, 160, 0, mPaintText);
            }
            if (j == 5) {
                canvas.drawTextOnPath(second, path, 160, 0, mPaintText);
            }
            if (j == 6) {
                canvas.drawTextOnPath(fisrt, path, 160, 0, mPaintText);
            }
            canvas.restore();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int h_hode=MeasureSpec.getMode(heightMeasureSpec);
        int w_hode=MeasureSpec.getMode(widthMeasureSpec);
        int height=0;
        if (h_hode==MeasureSpec.AT_MOST) {
            height = 200;
        }else if(h_hode==MeasureSpec.EXACTLY){
            height=MeasureSpec.getSize(heightMeasureSpec);
        }
        int width=0;
        if (w_hode==MeasureSpec.AT_MOST) {
            width = 200;
        }else if(w_hode==MeasureSpec.EXACTLY){
            width=MeasureSpec.getSize(widthMeasureSpec);
        }
        setMeasuredDimension(width,height);

            }
}
