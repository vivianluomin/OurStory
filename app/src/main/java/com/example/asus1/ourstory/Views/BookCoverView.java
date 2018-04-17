package com.example.asus1.ourstory.Views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by asus1 on 2018/4/17.
 */

public class BookCoverView extends AppCompatTextView {

    private Context mContext;

    public BookCoverView(Context context) {
        this(context,null);
    }

    public BookCoverView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BookCoverView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }
}
