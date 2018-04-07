package com.example.asus1.ourstory.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/3/25.
 */

public class ShowStoryView extends AppCompatTextView{

    private Context mContext;

    private int mWidth;
    private int mHeight;

    private Path mLeftPath;
    private Path mRightPath;
    private Path mBottomPath;
    private Paint mPaint;

    private Point A;
    private Point F;
    private Point C;
    private Point E;
    private Point B;
    private Point K;
    private Point J;
    private Point H;
    private Point G;



    public ShowStoryView(Context context) {
        this(context,null);
    }

    public ShowStoryView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ShowStoryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        init();

    }

    private void init(){
        mPaint = new Paint();
        mLeftPath = new Path();
        mRightPath = new Path();
        mBottomPath = new Path();
        A = new Point();
        B = new Point();
        C = new Point();
        E = new Point();
        K = new Point();
        J = new Point();
        H = new Point();
        G = new Point();
        F = new Point();
        WindowManager manager = (WindowManager)
                mContext.getSystemService(Context.WINDOW_SERVICE);
        if(manager!=null){
            manager.getDefaultDisplay().getSize(F);

        }

    }



    @Override
    protected void onDraw(Canvas canvas) {
        if(mP1Y !=0&& mP1X !=0){
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(getResources().getColor(R.color.bg_gray));


        }else {
            super.onDraw(canvas);
        }



    }

    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                    A.set((int)x,(int)y);

                                case MotionEvent.ACTION_MOVE:

                invalidate();
            case MotionEvent.ACTION_UP:
        }

        return true;
    }
}


