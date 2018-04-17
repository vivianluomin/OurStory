package com.example.asus1.ourstory.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.ourstory.Holders.NotifyHolder;
import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/4/17.
 */

public class RecyclerNotifyAdapter extends RecyclerView.Adapter<NotifyHolder> {

    private Context mContext;

    public RecyclerNotifyAdapter(Context context) {
        mContext = context;
    }

    @Override
    public NotifyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_notify_item,parent,false);
        return new NotifyHolder(view);
    }

    @Override
    public void onBindViewHolder(NotifyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
