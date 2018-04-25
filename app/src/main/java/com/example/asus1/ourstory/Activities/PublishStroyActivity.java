package com.example.asus1.ourstory.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.asus1.ourstory.R;

public class PublishStroyActivity extends BaseActivity implements View.OnClickListener{


    private RelativeLayout mBookBrief;
    private RelativeLayout mBookStart;
    private RelativeLayout mBookType;
    private RelativeLayout mBookWriter;
    private RelativeLayout mBookPublic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_stroy);
        init();
    }

    private void init(){
        mBookBrief = (RelativeLayout)findViewById(R.id.relat_book_brief);
        mBookBrief.setOnClickListener(this);
        mBookStart = (RelativeLayout)findViewById(R.id.relat_book_start);
        mBookStart.setOnClickListener(this);
        mBookType = (RelativeLayout)findViewById(R.id.relat_book_type);
        mBookType.setOnClickListener(this);
        mBookWriter = (RelativeLayout)findViewById(R.id.relat_book_writer);
        mBookWriter.setOnClickListener(this);
        mBookPublic = (RelativeLayout)findViewById(R.id.relat_book_public);
        mBookPublic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.relat_book_brief:
                 startActivity(new Intent(PublishStroyActivity.this,BookBriefActivity.class));
                break;
            case R.id.relat_book_start:
                startActivity(new Intent(PublishStroyActivity.this,BookStartActivity.class));
                break;
            case R.id.relat_book_type:
                break;
            case R.id.relat_book_writer:
                break;

            case R.id.relat_book_public:
                break;
        }
    }
}
