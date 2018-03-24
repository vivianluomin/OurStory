package com.example.asus1.ourstory.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/3/24.
 */

public class BookShelfFragment extends Fragment implements BottomNavigationBar.OnTabSelectedListener{

    private BottomNavigationBar mBottomBar;
    private ViewPager mViewPager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookshelf, container,false);
        mBottomBar = (BottomNavigationBar)(view.findViewById(R.id.bottom_nav_bar));
        mViewPager = (ViewPager)(view.findViewById(R.id.viewpager));

        mBottomBar.setTabSelectedListener(this);
        mBottomBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        mBottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomBar.setBackgroundColor(getResources().getColor(R.color.main_bule));
        mBottomBar.setBarBackgroundColor(R.color.main_bule);
        mBottomBar.addItem(new BottomNavigationItem(R.mipmap.ic_collection,R.string.bookshelf)
                .setActiveColorResource(R.color.white)
                .setInActiveColorResource(R.color.gray))
                .addItem(new BottomNavigationItem(R.mipmap.ic_publish,R.string.find)
                        .setActiveColorResource(R.color.white)
                        .setInActiveColorResource(R.color.gray))
                .addItem(new BottomNavigationItem(R.mipmap.ic_join,R.string.account)
                        .setActiveColorResource(R.color.white)
                        .setInActiveColorResource(R.color.gray))
                .setFirstSelectedPosition(0)
                .initialise();

        return view;

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onTabSelected(int position) {

    }

    @Override
    public void onTabUnselected(int position) {

    }



}
