package com.example.asus1.ourstory.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/5/3.
 */

public class LoadBg extends View {

    private Paint mPaint;
    private Rect mRect;
    private int mWdith;
    private int mHeight;
    private Context mContext;
    private Path mPath;

    public LoadBg(Context context) {
        this(context,null);
    }

    public LoadBg(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoadBg(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mRect = new Rect();
        mPath = new Path();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int wdith = MeasureSpec.getSize(widthMeasureSpec);
        int wdithMode = MeasureSpec.getMode(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if(wdithMode == MeasureSpec.EXACTLY){
            mWdith = wdith;
        }else {
            mWdith = 600;
        }

        if(heightMode == MeasureSpec.EXACTLY){
            mHeight = height;
        }else {
            mHeight = 240;
        }

        setMeasuredDimension(mWdith,mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.parseColor("#26a69a"));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setDither(true);
        mPaint.setAntiAlias(true);
        mRect.set(0,0,mWdith,mHeight-150);
        canvas.drawRect(mRect,mPaint);
        mPath.moveTo(0,mHeight-150);
        mPath.quadTo(mWdith/2,mHeight,mWdith,mHeight-150);
        canvas.drawPath(mPath,mPaint);

    }
}
