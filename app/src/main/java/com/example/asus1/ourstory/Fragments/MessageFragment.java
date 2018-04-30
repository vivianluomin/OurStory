package com.example.asus1.ourstory.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus1.ourstory.Activities.BookWriterActivity;
import com.example.asus1.ourstory.Adapters.ViewPagerAdapter;
import com.example.asus1.ourstory.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus1 on 2018/4/15.
 */

public class MessageFragment extends Fragment implements TabLayout.OnTabSelectedListener{

    private TabLayout mTabLayout;
    private ImageView mMessagePull;
    private ViewPager mViewPager;

    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();
    private ViewPagerAdapter mPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message,container,false);
        mTabLayout = (TabLayout)(view.findViewById(R.id.tab_layout));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.notify));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.chat));
        mViewPager = (ViewPager)(view.findViewById(R.id.viewpager));
        mMessagePull = (ImageView)(view.findViewById(R.id.iv_message_pull));
        mMessagePull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BookWriterActivity.class));
            }
        });

        mFragments.add(new NotifyFragment());
        mFragments.add(new ChatFragment());
        mTitles.add(getResources().getString(R.string.notify));
        mTitles.add(getResources().getString(R.string.chat));

        mPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(),mFragments,mTitles);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(2);

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(this);

        return view;
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }
}
