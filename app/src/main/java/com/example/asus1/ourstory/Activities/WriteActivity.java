package com.example.asus1.ourstory.Activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.example.asus1.ourstory.R;

public class WriteActivity extends BaseActivity {

    private EditText mEdiText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            getWindow().getDecorView().
                    setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.gray_200));
        }


        init();
    }

    private void init(){
        mEdiText = (EditText)findViewById(R.id.et_write_story);
        mEdiText.setText(R.string.blank_spaces);
        mEdiText.setSelection(mEdiText.getText().length());
        mEdiText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    mEdiText.setText(mEdiText.getText()+"\r\n"+getResources().getString(R.string.blank_spaces));
                    mEdiText.setSelection(mEdiText.getText().length());
                    return  true;
                }
                return false;
            }
        });
    }
}
