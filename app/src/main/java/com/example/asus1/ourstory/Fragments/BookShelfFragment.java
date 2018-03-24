package com.example.asus1.ourstory.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.asus1.ourstory.Adapters.ViewPagerAdapter;
import com.example.asus1.ourstory.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus1 on 2018/3/24.
 */

public class BookShelfFragment extends Fragment implements TabLayout.OnTabSelectedListener {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();
    private ViewPagerAdapter mPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookshelf, container,false);
        mTabLayout = (TabLayout)(view.findViewById(R.id.tab_layout));
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mViewPager = (ViewPager)(view.findViewById(R.id.viewpager));

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
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mViewPager.setCurrentItem(position+1);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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
