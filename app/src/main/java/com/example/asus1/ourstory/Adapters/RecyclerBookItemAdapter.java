package com.example.asus1.ourstory.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.ourstory.Holders.BaseHolder;
import com.example.asus1.ourstory.Holders.BookItemHolder;
import com.example.asus1.ourstory.R;


/**
 * Created by asus1 on 2018/3/26.
 */

public class RecyclerBookItemAdapter extends RecyclerView.Adapter<BaseHolder> {

    private Context mContext;

    public RecyclerBookItemAdapter(Context context) {
        mContext = context;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_book_item,parent,false);
        return new BookItemHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        holder.setData();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
