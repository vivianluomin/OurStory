package com.example.asus1.ourstory.Fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alexvasilkov.foldablelayout.FoldableListLayout;
import com.alexvasilkov.foldablelayout.UnfoldableView;

import com.example.asus1.ourstory.Adapters.RecyclerBookFlodAdapter;
import com.example.asus1.ourstory.Adapters.RecyclerBookItemAdapter;
import com.example.asus1.ourstory.Holders.BookFoldHolder;
import com.example.asus1.ourstory.R;
import com.example.asus1.ourstory.Views.BookFoldView;

/**
 * Created by asus1 on 2018/3/25.
 */

public class IntroductionFragment extends Fragment {


    private static final String TAG = "IntroductionFragment";


    private Context mContext;
    private RecyclerView mRecyclerView;
    private RecyclerBookFlodAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_introduction,container,false);
        mRecyclerView = (RecyclerView)(view.findViewById(R.id.recycler_view));
        init();

        return view;
    }

    private void init(){
        mAdapter = new RecyclerBookFlodAdapter(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
