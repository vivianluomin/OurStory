package com.example.asus1.ourstory.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.ourstory.Activities.SearchActivity;
import com.example.asus1.ourstory.Adapters.RecyclerNotifyAdapter;
import com.example.asus1.ourstory.R;
import com.example.asus1.ourstory.Views.BookDetailDecoration;
import com.example.asus1.ourstory.Views.MessageDecoration;

/**
 * Created by asus1 on 2018/4/16.
 */

public class NotifyFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerNotifyAdapter mAdapter;

    private View mSearch;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notify,container,false);
        mRecyclerView = (RecyclerView)(view.findViewById(R.id.recycler_view));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new MessageDecoration(getContext()));
        mAdapter = new RecyclerNotifyAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);

        mSearch = (View)(view.findViewById(R.id.layout_search));
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SearchActivity.class));
            }
        });

        return view;
    }


}
