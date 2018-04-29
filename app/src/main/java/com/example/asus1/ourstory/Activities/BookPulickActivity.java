package com.example.asus1.ourstory.Activities;

import android.graphics.drawable.RippleDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.asus1.ourstory.R;

public class BookPulickActivity extends BaseActivity implements View.OnClickListener {

    private FrameLayout mPublic;
    private FrameLayout mFan;
    private FrameLayout mFriend;
    private ImageView mPulicImageView;
    private ImageView mFanImageView;
    private ImageView mFriendImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_pulick);
        init();
    }

    private void init(){
        mPublic = (FrameLayout)findViewById(R.id.frame_public);
        mPublic.setOnClickListener(this);
        mFan = (FrameLayout)findViewById(R.id.frame_fan);
        mFan.setOnClickListener(this);
        mFriend = (FrameLayout)findViewById(R.id.frame_friend);
        mFriend.setOnClickListener(this);
        mPulicImageView = (ImageView)findViewById(R.id.iv_public);
        mFanImageView = (ImageView)findViewById(R.id.iv_fan);
        mFriendImageView = (ImageView)findViewById(R.id.iv_friend);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frame_public:
                mPulicImageView.
                        setImageDrawable(getDrawable(R.drawable.radtio_button_selection));
                mFanImageView.
                        setImageDrawable(getDrawable(R.drawable.radtio_button));
                mFriendImageView.
                        setImageDrawable(getDrawable(R.drawable.radtio_button));
                break;
            case R.id.frame_fan:
                mPulicImageView.
                        setImageDrawable(getDrawable(R.drawable.radtio_button));
                mFanImageView.
                        setImageDrawable(getDrawable(R.drawable.radtio_button_selection));
                mFriendImageView.
                        setImageDrawable(getDrawable(R.drawable.radtio_button));
                break;
            case R.id.frame_friend:
                mPulicImageView.
                        setImageDrawable(getDrawable(R.drawable.radtio_button));
                mFanImageView.
                        setImageDrawable(getDrawable(R.drawable.radtio_button));
                mFriendImageView.
                        setImageDrawable(getDrawable(R.drawable.radtio_button_selection));
                break;
        }
    }
}
