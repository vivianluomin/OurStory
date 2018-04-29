package com.example.asus1.ourstory.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.ourstory.Holders.BaseHolder;
import com.example.asus1.ourstory.Holders.BookSearchHolder;
import com.example.asus1.ourstory.Holders.BookWriterHeaderHolder;
import com.example.asus1.ourstory.Holders.BookWriterHolder;
import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/4/29.
 */

public class RecyclerBookWriterAdater extends RecyclerView.Adapter<BaseHolder> {

    private Context mContext;

    private final int BOOKSEARCH = 1;
    private final  int BOOKHEADER = 2;
    private final  int BOOKITEM = 3;

    public RecyclerBookWriterAdater(Context context) {
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return  BOOKSEARCH;
        }else if(ifHeaderPosittion(position)){
            return BOOKHEADER;
        }else {
            return  BOOKITEM;
        }
    }

    private boolean ifHeaderPosittion(int position){

        switch (position){
            case 1:
            case 5:
            case 9:
            case 13:
            case 17:
            case 21:
            case 25:
            case 29:
            case 31:
            case 35:
            case 39:
            case 41:
            case 45:
            case 49:
            case 51:
            case 55:
            case 59:
            case 61:
            case 65:
            case 69:
            case 71:
            case 75:
            case 79:
            case 81:
            case 85:
            case 89:
            case 93:
             return true;
        }

        return false;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == BOOKSEARCH){
            View view = LayoutInflater.from(mContext).
                    inflate(R.layout.layout_search,parent,false);
            return new BookSearchHolder(view);
        }else if (viewType == BOOKHEADER){
            View view = LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_bookwirter_headitem,parent,false);
            return new BookWriterHeaderHolder(view);
        }else {
            View view = LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_bookwriter_item,parent,false);

            return new BookWriterHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 109;
    }
}
