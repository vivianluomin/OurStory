package com.example.asus1.ourstory.Utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/4/22.
 */

public class DialogFactory {

    private AlertDialog mDialog;
    private Context mContext;
    public DialogFactory(Context context) {
        mContext = context;
    }

    public Dialog createDialog(String title, String message,
                               DialogInterface.OnClickListener positiveCallback,
                               DialogInterface.OnClickListener negativeCallback
                               ){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        SpannableString string = new SpannableString(message);
        string.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.second_text_color))
                ,0,message.length(),
                Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        builder.setTitle(title)
                .setMessage(string)
                .setPositiveButton(R.string.yes,positiveCallback)
                .setNegativeButton(R.string.no,negativeCallback);
        mDialog = builder.create();
        return  mDialog;
    }
}
