package com.example.asus1.ourstory.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by asus1 on 2018/3/26.
 */

public abstract class BaseHolder extends RecyclerView.ViewHolder {


    public BaseHolder(View itemView) {
        super(itemView);

    }

    public abstract void setData();
}
