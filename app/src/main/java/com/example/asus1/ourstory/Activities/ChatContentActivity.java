package com.example.asus1.ourstory.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.asus1.ourstory.Adapters.RecyclerChatContentAdpater;
import com.example.asus1.ourstory.Model.ChatMeassgeModel;
import com.example.asus1.ourstory.R;
import com.example.asus1.ourstory.Utils.AndroidBug5497Workaround;

import java.util.ArrayList;
import java.util.List;

public class ChatContentActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private ImageView mChatSend;
    private List<ChatMeassgeModel> mMeassages = new ArrayList<>();
    private RecyclerChatContentAdpater mAdater;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        AndroidBug5497Workaround.assistActivity(this);
        init();
    }

    private void  init(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mChatSend = (ImageView)findViewById(R.id.iv_chat_send);

        mMeassages.add(new ChatMeassgeModel(0));
        mMeassages.add(new ChatMeassgeModel(1));
        mMeassages.add(new ChatMeassgeModel(0));
        mMeassages.add(new ChatMeassgeModel(1));

        mAdater = new RecyclerChatContentAdpater(this,mMeassages);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdater);
    }
}
