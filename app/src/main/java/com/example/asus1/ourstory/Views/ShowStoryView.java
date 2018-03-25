package com.example.asus1.ourstory.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by asus1 on 2018/3/25.
 */

public class ShowStoryView extends View {

    private Context mContext;
    private Paint mBgPaint;//背景
    private Paint mTurnPaint;//书的后面
    private Paint mAfterPaint;//下一页

    private int mWidth;
    private int mHeight;

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
        mBgPaint = new Paint();
        mTurnPaint = new Paint();
        mAfterPaint = new Paint();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

//        int width = MeasureSpec.getSize(widthMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int height = MeasureSpec.getSize(heightMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

//        mWidth =
//
//
//
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
