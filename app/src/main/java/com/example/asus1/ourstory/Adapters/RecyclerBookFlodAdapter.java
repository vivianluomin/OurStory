package com.example.asus1.ourstory.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.ourstory.Holders.BookFoldHolder;
import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/4/1.
 */

public class RecyclerBookFlodAdapter extends RecyclerView.Adapter<BookFoldHolder>  {

    private Context mContext;

    public RecyclerBookFlodAdapter(Context context) {
        mContext = context;
    }

    @Override
    public BookFoldHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(mContext).inflate(R.layout.layout_book_fold,parent,false);
        return new BookFoldHolder(view,mContext);
    }

    @Override
    public void onBindViewHolder(BookFoldHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 3;
    }



}
