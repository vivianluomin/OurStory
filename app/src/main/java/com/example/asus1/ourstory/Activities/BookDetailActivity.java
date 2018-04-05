package com.example.asus1.ourstory.Activities;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.asus1.ourstory.Adapters.RecyclerBookDetailAdpter;
import com.example.asus1.ourstory.Listeners.AppBarStateChangeListener;
import com.example.asus1.ourstory.R;
import com.example.asus1.ourstory.Views.BookDetailDecoration;

public class BookDetailActivity extends BaseActivity {

    private Toolbar mToolBar;

    private static final String TAG = "BookDetailActivity";

    private CollapsingToolbarLayout mToolbar_layout;
    private AppBarLayout mAppLayout;
    private RecyclerView mRecyclerView;
    private RecyclerBookDetailAdpter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);


        init();


    }


    private void init(){

        mToolbar_layout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_tool_bar);
        mAppLayout = (AppBarLayout)findViewById(R.id.app_bar);
        mToolbar_layout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        mAppLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChange(AppBarLayout appBarLayout, State state) {
                if(state == State.COLLAPSED){
                    mToolbar_layout.setTitleEnabled(true);
                    mToolbar_layout.setTitle("XXXXXXX");
                }else if(state == State.EXPANDED){
                    mToolbar_layout.setTitleEnabled(false);
                }else {
                    mToolbar_layout.setTitleEnabled(false);
                }
            }
        });

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerBookDetailAdpter(this);
        mRecyclerView.addItemDecoration(new BookDetailDecoration(this));
        mRecyclerView.setAdapter(mAdapter);

    }
}
