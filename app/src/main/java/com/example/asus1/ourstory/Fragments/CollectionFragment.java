package com.example.asus1.ourstory.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.ourstory.Adapters.RecyclerBookItemAdapter;
import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/3/24.
 */

public class CollectionFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private RecyclerBookItemAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection,container,false);

        mRecyclerView = (RecyclerView)(view.findViewById(R.id.recycler_view));
        init();

        return view;
    }

    private void init(){
        mAdapter = new RecyclerBookItemAdapter(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
