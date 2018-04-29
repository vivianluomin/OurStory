package com.example.asus1.ourstory.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.asus1.ourstory.Adapters.RecyclerBookWriterAdater;
import com.example.asus1.ourstory.R;

public class BookWriterActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private RecyclerBookWriterAdater mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_writer);
        init();
    }

    private void init(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mAdapter = new RecyclerBookWriterAdater(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
