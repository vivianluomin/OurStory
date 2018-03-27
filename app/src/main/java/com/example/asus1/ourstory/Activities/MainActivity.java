package com.example.asus1.ourstory.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.asus1.ourstory.Fragments.AccountFragment;
import com.example.asus1.ourstory.Fragments.BookShelfFragment;
import com.example.asus1.ourstory.Fragments.FindFragment;
import com.example.asus1.ourstory.R;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar mBottonBar;
    private FragmentManager mFragmentManger;
    private FragmentTransaction mFragmentTransaction;

    private int mNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManger = getSupportFragmentManager();

        init();
    }

    private void init(){

        mBottonBar = (BottomNavigationBar)findViewById(R.id.bottom_nav_bar);
        mBottonBar.setTabSelectedListener(this);
        mBottonBar.setMode(BottomNavigationBar.MODE_DEFAULT);
        mBottonBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottonBar.setBarBackgroundColor(R.color.bg_color);
        mBottonBar.addItem(new BottomNavigationItem(R.mipmap.ic_bookshelf,R.string.bookshelf)
                .setActiveColorResource(R.color.main_bule)
                .setInActiveColorResource(R.color.Text_color))
                .addItem(new BottomNavigationItem(R.mipmap.ic_find,R.string.find)
                        .setActiveColorResource(R.color.main_bule)
                        .setInActiveColorResource(R.color.Text_color))
                .addItem(new BottomNavigationItem(R.mipmap.ic_account1,R.string.account)
                        .setActiveColorResource(R.color.main_bule)
                        .setInActiveColorResource(R.color.Text_color))
                .setFirstSelectedPosition(0)
                .initialise();



        mFragmentTransaction = mFragmentManger.beginTransaction();
        mFragmentTransaction.add(R.id.frame_container,new BookShelfFragment());
        mFragmentTransaction.commit();
        mNow = 0;
    }

    @Override
    public void onTabSelected(int position) {
        mFragmentTransaction = mFragmentManger.beginTransaction();

        switch (position){
            case 0:
                if(mNow!=0){
                    mFragmentTransaction.replace(R.id.frame_container,new BookShelfFragment());
                    mFragmentTransaction.commit();
                    mNow = 0;
                }

                break;
            case 1:
                if(mNow!=1){
                    mFragmentTransaction.replace(R.id.frame_container,new FindFragment());
                    mFragmentTransaction.commit();
                    mNow = 1;
                }
                break;
            case 2:
                if(mNow!=2){
                    mFragmentTransaction.replace(R.id.frame_container,new AccountFragment());
                    mFragmentTransaction.commit();
                    mNow = 2;
                }
                break;
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onTabUnselected(int position) {

    }
}
