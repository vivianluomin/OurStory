package com.example.asus1.ourstory.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.ourstory.Holders.BaseHolder;
import com.example.asus1.ourstory.Holders.BookCommentHolder;
import com.example.asus1.ourstory.Holders.CatalogHolder;
import com.example.asus1.ourstory.Holders.CommentHolder;
import com.example.asus1.ourstory.Holders.StartEndHolder;
import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/4/4.
 */

public class RecyclerBookDetailAdpter extends RecyclerView.Adapter<BaseHolder> {

    private final int START_END_VIEW_TYPE = 0;
    private final int CATALOG_VIEW_TYPE = 1;
    private final int COMMMENT_VIEW_TYPE = 2;
    private final int BOOK_COMMENT_VIEW_TYPE = 3;

    private Context mContext;


    public RecyclerBookDetailAdpter(Context context) {

        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return START_END_VIEW_TYPE;
        }else if(position == 1){
            return  CATALOG_VIEW_TYPE;

        }else if (position == 2){
            return COMMMENT_VIEW_TYPE;
        }else {
            return BOOK_COMMENT_VIEW_TYPE;
        }
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case START_END_VIEW_TYPE:
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.layout_recycler_d_startend,
                                parent,false);
                return new StartEndHolder(view);

            case CATALOG_VIEW_TYPE:
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.layout_recycler_d_catalog,
                                parent,false);
                return new CatalogHolder(view);

            case COMMMENT_VIEW_TYPE:
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.layout_recycler_d_catalog,
                                parent,false);
                return new CommentHolder(view);
            case BOOK_COMMENT_VIEW_TYPE:
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.layout_book_comment,
                                parent,false);
                return new BookCommentHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
