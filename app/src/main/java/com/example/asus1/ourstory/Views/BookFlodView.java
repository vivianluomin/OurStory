package com.example.asus1.ourstory.Views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/4/19.
 */

public class BookFlodView extends LinearLayout {

    private Context mContext;
    private View mViewMain;
    private View mStart;
    private View mView_two;
    private View mUpdate;

    private static final String TAG = "BookFlodView";
    private boolean mAnimStart = false;

    public BookFlodView(Context context) {
        this(context,null);
    }

    public BookFlodView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BookFlodView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mViewMain = getChildAt(0);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int measureWidth = 0;
//        int measureHeight = 0;
//        int childcount = getChildCount();
//        Log.d(TAG, "onMeasure: childCount "+childcount);
//        measureChildren(widthMeasureSpec,heightMeasureSpec);
//
//        int width = MeasureSpec.getSize(widthMeasureSpec);
//        int height = MeasureSpec.getSize(heightMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        if(widthMode == MeasureSpec.AT_MOST){
//            measureWidth = 1024;
//        }else {
//            measureWidth = width;
//        }
//
//        if(heightMode == MeasureSpec.AT_MOST){
//            for(int i =0;i<childcount;i++){
//                    measureHeight+=getChildAt(i).getMeasuredHeight();
//            }
//        }else {
//            measureHeight = height;
//        }
//
//        Log.d(TAG, "onMeasure: wdith+height "+measureWidth+"+"+measureHeight);
//        setMeasuredDimension(measureWidth,measureHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childtop = 0;
        int childCount = getChildCount();
        for(int i =0;i<childCount;i++){
            View child = getChildAt(i);
            if(child.getVisibility()!=GONE){
                int childHeight = child.getMeasuredHeight();
                child.layout(0,childtop,child.getMeasuredWidth(),childtop+childHeight);
                childtop+=childHeight;
            }
        }
    }

    public boolean ifHasViews(){
        if(mView_two!=null&&mStart!=null&&mUpdate!=null){
            return true;
        }

        return false;
    }

    public void addViews(View one,View two,View threed){
        mView_two = one;
        mStart = two;
        mUpdate = threed;
       addView(mView_two,1);
        addView(mStart,2);
        addView(mUpdate,3);
        mView_two.setVisibility(GONE);
        mStart.setVisibility(GONE);
        mUpdate.setVisibility(GONE);
        postInvalidate();

    }



}
