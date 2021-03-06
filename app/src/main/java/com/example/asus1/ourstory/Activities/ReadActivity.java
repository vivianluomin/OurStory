package com.example.asus1.ourstory.Activities;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.asus1.ourstory.R;
import com.example.asus1.ourstory.Views.ShowStoryView;

public class ReadActivity extends AppCompatActivity {

    private ShowStoryView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        mView = (ShowStoryView)findViewById(R.id.viewpager);
        setWindow();
    }

    private void setWindow(){
            View decorView = getWindow().getDecorView();
            mView.setWindow(getWindow());
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE|
                                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                            );

    }
}
