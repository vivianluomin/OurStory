package com.example.asus1.ourstory.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.asus1.ourstory.R;

public class BookWriteTypeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mSingleImageView;
    private ImageView mDoubleImageView;
    private FrameLayout mSinggleFrame;
    private FrameLayout mDoubleFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_write_type);
        init();
    }

    private void init(){
        mSingleImageView = (ImageView)findViewById(R.id.iv_single_write);
        mDoubleImageView = (ImageView)findViewById(R.id.iv_double_write);

        mSinggleFrame = (FrameLayout)findViewById(R.id.frame_single);
        mSinggleFrame.setOnClickListener(this);

        mDoubleFrame = (FrameLayout)findViewById(R.id.frame_double);
        mDoubleFrame.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frame_single:
                mSingleImageView.setImageDrawable
                        (getResources().getDrawable(R.drawable.radtio_button_selection));
                mDoubleImageView.setImageDrawable
                        (getResources().getDrawable(R.drawable.radtio_button));
               break;
            case R.id.frame_double:
                mSingleImageView.setImageDrawable
                        (getResources().getDrawable(R.drawable.radtio_button));
                mDoubleImageView.setImageDrawable
                        (getResources().getDrawable(R.drawable.radtio_button_selection));
                break;
        }
    }
}
