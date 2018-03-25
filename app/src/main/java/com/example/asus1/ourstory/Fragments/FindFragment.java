package com.example.asus1.ourstory.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.ourstory.Adapters.ViewPagerAdapter;
import com.example.asus1.ourstory.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus1 on 2018/3/25.
 */

public class FindFragment extends Fragment implements TabLayout.OnTabSelectedListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();
    private ViewPagerAdapter mPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container,false);
        mTabLayout = (TabLayout)(view.findViewById(R.id.tab_layout));
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.Todayintroduction));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.ranklist));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.allWorks));
        mViewPager = (ViewPager)(view.findViewById(R.id.viewpager));

        mFragments.add(new IntroductionFragment());
        mFragments.add(new RankListFragment());
        mFragments.add(new AllWorksFragment());
        mTitles.add(getResources().getString(R.string.Todayintroduction));
        mTitles.add(getResources().getString(R.string.ranklist));
        mTitles.add(getResources().getString(R.string.allWorks));

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

}
