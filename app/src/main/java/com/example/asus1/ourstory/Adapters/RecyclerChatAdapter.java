package com.example.asus1.ourstory.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.ourstory.Activities.ChatContentActivity;
import com.example.asus1.ourstory.Holders.ChatHolder;
import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/4/17.
 */

public class RecyclerChatAdapter extends RecyclerView.Adapter<ChatHolder> {

    private Context mContext;

    public RecyclerChatAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_chat_item,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, ChatContentActivity.class));
            }
        });
        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
