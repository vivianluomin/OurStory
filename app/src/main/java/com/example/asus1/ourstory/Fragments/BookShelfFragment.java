package com.example.asus1.ourstory.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.asus1.ourstory.Activities.PublishStroyActivity;
import com.example.asus1.ourstory.Activities.WriteActivity;
import com.example.asus1.ourstory.Adapters.ViewPagerAdapter;
import com.example.asus1.ourstory.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus1 on 2018/3/24.
 */

public class BookShelfFragment extends Fragment implements TabLayout.OnTabSelectedListener,View.OnClickListener {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();
    private ViewPagerAdapter mPagerAdapter;
    private TextView mStartPublish;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookshelf, container,false);
        mTabLayout = (TabLayout)(view.findViewById(R.id.tab_layout));
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.collection));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.mypublish));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.myjoin));
        mViewPager = (ViewPager)(view.findViewById(R.id.viewpager));
        mStartPublish = (TextView)(view.findViewById(R.id.tv_start_publish));
        mStartPublish.setOnClickListener(this);

        mFragments.add(new CollectionFragment());
        mFragments.add(new PublishFragment());
        mFragments.add(new JoinFragment());
        mTitles.add(getResources().getString(R.string.collection));
        mTitles.add(getResources().getString(R.string.mypublish));
        mTitles.add(getResources().getString(R.string.myjoin));

        mPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(),mFragments,mTitles);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(3);

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(this);




        return view;

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_start_publish:
                startActivity(new Intent(getContext(), PublishStroyActivity.class));
        }
    }
}
