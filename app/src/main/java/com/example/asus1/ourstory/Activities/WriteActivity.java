package com.example.asus1.ourstory.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.asus1.ourstory.R;
import com.example.asus1.ourstory.Utils.DialogFactory;

public class WriteActivity extends BaseActivity implements View.OnClickListener{

    private EditText mEdiText;
    private ImageView mDustbin;
    private ImageView mSetting;
    private ImageView mWriteStory;
    private ImageView mHistory;
    private DialogFactory mFactory;
    private LinearLayout mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            getWindow().getDecorView().
                    setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.gray_200));
        }


        init();
    }

    private void init(){
        mRoot = (LinearLayout)findViewById(R.id.ll_root);
        mEdiText = (EditText)findViewById(R.id.et_write_story);
        mEdiText.setText(R.string.blank_spaces);
        mEdiText.setSelection(mEdiText.getText().length());
        mEdiText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    int selection = mEdiText.getSelectionEnd();
                    int prelength = mEdiText.getText().length();
                    mEdiText.setText(mEdiText.getText().insert(selection,"\r\n"+
                            getResources().getString(R.string.blank_spaces)));
                    if(selection!=prelength){
                        mEdiText.setSelection(selection+"\r\n".length()+4);
                    }else {
                        mEdiText.setSelection(mEdiText.length());
                    }

                    return  true;
                }
                return false;
            }
        });

        mDustbin = (ImageView)findViewById(R.id.iv_dustbin);
        mDustbin.setOnClickListener(this);
        mSetting = (ImageView)findViewById(R.id.iv_setting);
        mSetting.setOnClickListener(this);
        mWriteStory = (ImageView)findViewById(R.id.iv_write);
        mWriteStory.setOnClickListener(this);
        mHistory = (ImageView)findViewById(R.id.iv_history);
        mHistory.setOnClickListener(this);
        mFactory = new DialogFactory(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_dustbin:
              mFactory.createDialog(getResources().getString(R.string.dustbin_title),
                        getResources().getString(R.string.dustbin_message),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }
                ).show();

                break;
            case R.id.iv_setting:
              showSettingPopu();

                break;
            case R.id.iv_write:
                showSofeWare();
                break;
            case R.id.iv_history:
                break;
        }
    }

    private void showSettingPopu(){
        View view = LayoutInflater.from(this).inflate(R.layout.layout_writesetting_popu,null);
        PopupWindow window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT
                , WindowManager.LayoutParams.WRAP_CONTENT,true);
        setBackgroundAlpha(0.5f);
        window.setOutsideTouchable(true);
        window.setFocusable(true);
        window.setBackgroundDrawable(getDrawable(R.drawable.bg_popwindow));
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackgroundAlpha(1);
            }
        });
        window.showAtLocation(mRoot, Gravity.BOTTOM|Gravity.CENTER,0,0);
        //window.showAsDropDown(mSetting, 0,0,Gravity.TOP|Gravity.CENTER);


    }

    private void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp =this.getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        this.getWindow().setAttributes(lp);
    }

    private void showSofeWare(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);


    }
}
