package com.example.asus1.ourstory.Holders;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/4/17.
 */

public class NotifyHolder extends RecyclerView.ViewHolder {

    private TextView mUserName;
    private View view;

    public NotifyHolder(View itemView) {
        super(itemView);
        view = itemView;
        mUserName = (TextView)(view.findViewById(R.id.tv_username));
        SpannableString string = new SpannableString("XXX回复了你");
        ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#00868B"));
        string.setSpan(span,0,3, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mUserName.setText(string);

    }

    public void setData(){

    }
}
