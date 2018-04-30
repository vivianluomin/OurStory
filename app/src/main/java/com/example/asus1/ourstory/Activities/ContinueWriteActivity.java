package com.example.asus1.ourstory.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.asus1.ourstory.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContinueWriteActivity extends BaseActivity {

    private CircleImageView mContinuer_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_write);
        init();
    }

    private void init(){
        mContinuer_4 = (CircleImageView)findViewById(R.id.iv_user_continuer_4);
        mContinuer_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContinueWriteActivity.this,WriteActivity.class));
            }
        });
    }
}
