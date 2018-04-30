package com.example.asus1.ourstory.Holders;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus1.ourstory.Activities.ContinueWriteActivity;
import com.example.asus1.ourstory.R;


/**
 * Created by asus1 on 2018/3/26.
 */

public class BookItemHolder extends BaseHolder {

    private View mView;
    private ImageView mBookBg;
    private TextView mBookUser;
    private TextView mBookName;
    private TextView mUpdateNow;
    private TextView mBrief;
    private TextView mStartWork;
    private Context mContext;

    public BookItemHolder(View itemView, Context context) {
        super(itemView);
        mView = itemView;
        mContext = context;

        mBookBg = (ImageView)(mView.findViewById(R.id.iv_book_bg));
        mBookName = (TextView)(mView.findViewById(R.id.tv_bookname));
        mBookUser = (TextView)(mView.findViewById(R.id.tv_bookuser));
        mUpdateNow = (TextView)(mView.findViewById(R.id.tv_updatenow));
        mBrief = (TextView)(mView.findViewById(R.id.tv_book_brief));
        mStartWork = (TextView)(mView.findViewById(R.id.tv_start_work));
        mStartWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, ContinueWriteActivity.class));
            }
        });
    }

    @Override
    public void setData() {

    }
}
