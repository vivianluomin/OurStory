package com.example.asus1.ourstory.Activities;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.asus1.ourstory.R;

public class ReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        setWindow();
    }

    private void setWindow(){
            View decorView = getWindow().getDecorView();
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE|
                                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                            );

    }
}
