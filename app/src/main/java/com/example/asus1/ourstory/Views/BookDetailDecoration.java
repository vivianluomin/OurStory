package com.example.asus1.ourstory.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/4/5.
 */

public class BookDetailDecoration extends RecyclerView.ItemDecoration {

    private Drawable mWdithDivider;
    private Drawable mDivider;
    private ViewGroup.MarginLayoutParams mParams;
    public BookDetailDecoration(Context context){
        mWdithDivider = context.getDrawable(R.drawable.divider_width);
        mDivider = context.getDrawable(R.drawable.divider_line);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft()+150;
        int right = parent.getWidth()-parent.getPaddingRight();
        int childCount = parent.getChildCount();
        mParams = (ViewGroup.MarginLayoutParams) parent.getLayoutParams();
        for(int i =0;i<childCount;i++){
            View view = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)view.getLayoutParams();
            int top = view.getBottom()+params.bottomMargin;
            if(i == 0 || i == 1){
                int bottom = top+mWdithDivider.getIntrinsicHeight();
                mWdithDivider.setBounds(0,top,parent.getWidth(),bottom);
                mWdithDivider.draw(c);
            }else if(i != 2 && i!=childCount-1){
                int bottom = top+mDivider.getIntrinsicHeight();
                mDivider.setBounds(left,top,right,bottom);
                mDivider.draw(c);
            }
        }
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(view == parent.getChildAt(0) || view == parent.getChildAt(1)){
            outRect.set(0,0,0,mWdithDivider.getIntrinsicHeight());
        }else if(view!=parent.getChildAt(parent.getChildCount()-1)) {
            outRect.set(0,0,0,mDivider.getIntrinsicHeight());
        }
    }
}
