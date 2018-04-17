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
 * Created by asus1 on 2018/4/17.
 */

public class MessageDecoration extends RecyclerView.ItemDecoration {


    private Context mContext;
    private Drawable mDivider;
    public MessageDecoration(Context context) {
        mContext = context;
        mDivider = mContext.getDrawable(R.drawable.divider_line);

    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
       int left = parent.getPaddingLeft()+160;
       int right = parent.getWidth()-parent.getPaddingRight();

        for(int i =0;i<parent.getChildCount();i++){
            View view = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)view.getLayoutParams();
                int top = view.getBottom()+params.bottomMargin;
                int bottom = top+mDivider.getIntrinsicHeight();
                mDivider.setBounds(left,top,right,bottom);
                mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0,0,0,mDivider.getIntrinsicHeight());
    }
}
