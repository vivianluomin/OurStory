package com.example.asus1.ourstory.Views;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/4/19.
 */

public class BookPopupWIndow extends PopupWindow {

    private ImageView mShowMore;

    private Context mContext;
    private PopupWindow mMoreWindow;
    private FrameLayout mFrame;

    private static final String TAG = "BookPopupWIndow";

    public BookPopupWIndow(Context context, View contentView, int width, int height, boolean focusable) {
        super(contentView, width, height, focusable);
        mContext = context;
       View view = LayoutInflater.from(mContext).inflate(R.layout.layoutt_book_see_more,null);
        mMoreWindow = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT
                , WindowManager.LayoutParams.WRAP_CONTENT,true);
        mMoreWindow.setFocusable(true);
        mMoreWindow.setOutsideTouchable(true);

        mShowMore = (ImageView)(contentView.findViewById(R.id.iv_more));
        mShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoreWindow.showAsDropDown(mShowMore,-300,-120, Gravity.LEFT);
            }
        });

        mFrame = (FrameLayout)(contentView.findViewById(R.id.pop_frame));
        mFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookPopupWIndow.this.dismiss();
            }
        });
    }


}
