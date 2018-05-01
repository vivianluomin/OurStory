package com.example.asus1.ourstory.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.ourstory.Holders.ChatContentHolder;
import com.example.asus1.ourstory.Model.ChatMeassgeModel;
import com.example.asus1.ourstory.R;

import java.util.List;

/**
 * Created by asus1 on 2018/5/1.
 */

public class RecyclerChatContentAdpater extends RecyclerView.Adapter<ChatContentHolder> {


    private Context mContext;
    private List<ChatMeassgeModel> mMeassages;

    public RecyclerChatContentAdpater(Context context, List<ChatMeassgeModel> models) {
        mContext = context;
        mMeassages = models;
    }


    @Override
    public int getItemViewType(int position) {
        return mMeassages.get(position).getLocation();
    }

    @Override
    public ChatContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == ChatMeassgeModel.LEFT){
            view = LayoutInflater.from(mContext).
                    inflate(R.layout.lauyout_chat_left,parent,false);
        }else {
            view = LayoutInflater.from(mContext).
                    inflate(R.layout.layout_chat_right,parent,false);
        }
        return new ChatContentHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatContentHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mMeassages.size();
    }

}
