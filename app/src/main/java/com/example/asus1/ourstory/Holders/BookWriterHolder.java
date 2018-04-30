package com.example.asus1.ourstory.Holders;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/4/29.
 */

public class BookWriterHolder extends BaseHolder {

    private View mView;
    private ImageView mSelectImageView;
    private boolean mSelcet = false;
    private Context mContext;

    public BookWriterHolder(View itemView , Context context) {
        super(itemView);
        mView = itemView;
        mContext = context;
        init();
    }

    private  void  init(){
        mSelectImageView = (ImageView)(mView.findViewById(R.id.iv_select));
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSelcet){
                    mSelectImageView.setImageDrawable(mContext.
                            getResources().getDrawable(R.drawable.radtio_button));
                    mSelcet = false;
                }else {
                    mSelectImageView.setImageDrawable(mContext.
                            getResources().getDrawable(R.drawable.radtio_button_selection));
                    mSelcet = true;
                }
            }
        });
    }

    @Override
    public void setData() {

    }
}
