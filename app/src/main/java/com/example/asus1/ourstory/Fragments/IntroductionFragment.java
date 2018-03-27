package com.example.asus1.ourstory.Fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus1.ourstory.R;
import com.example.asus1.ourstory.Views.BookFoldView;

/**
 * Created by asus1 on 2018/3/25.
 */

public class IntroductionFragment extends Fragment {
    int flag = 0;

    private static final String TAG = "IntroductionFragment";

    private Context mContext;
    private Paint mTextPaint;
    private ImageView mBookBg;
    private TextView mBookName;
    private  TextView  mBookBrief;
    private TextView mBookAuthor;
    private TextView mType;
    private View mView_one;
    private View mView_two;
    private TextView mUpdataNow;
    private TextView mJoinNumber;
    private TextView mWordCount;

    private TextView mStart;
    private TextView mUpdate;

    private String mStart_text = "";
    private String mUpdate_text = "";

    private int mWidth;
    private int mHeight;
    private int mSpan = 10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_introduction,container,false);
        final View bookFoldView =  view.findViewById(R.id.book_fold);

        mView_two = bookFoldView.findViewById(R.id.view_two);
        mView_two.setPivotY(0);
        mView_two.setPivotX(0);
        mStart = (TextView)bookFoldView. findViewById(R.id.tv_start);
        mStart.setPivotY(0);
        mStart.setPivotX(0);
        mUpdate = (TextView)bookFoldView. findViewById(R.id.tv_update);
        mUpdate.setPivotX(0);
        mUpdate.setPivotY(0);

        bookFoldView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 0){
                    fold();
                    flag = 1;
                }else {
                   expand();
                    flag = 0;
                }

                Log.d(TAG, "onClick: 1111111");
            }



        });

        return view;
    }


    public void expand(){
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mUpdate,
                "rotationX",180f,0f)
                .setDuration(500);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mStart,
                "rotationX",180f,0f)
                .setDuration(500);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mView_two,
                "rotationX",180f,0f)
                .setDuration(500);

        set.play(animator3).before(animator2).before(animator1);

        set.start();

        Log.d(TAG, "expand: 222222222");
    }

    public void fold(){

        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mUpdate,
                "rotationX",0f,-180f)
                .setDuration(500);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mStart,
                "rotationX",0f,-180f)
                .setDuration(500);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mView_two,
                "rotationX",0f,-180f)
                .setDuration(500);

        animator1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mUpdate.setVisibility(View.GONE);
            }
        });

        animator2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mStart.setVisibility(View.GONE);
            }
        });

        animator3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mView_two.setVisibility(View.GONE);
            }
        });
        set.play(animator1).before(animator2).before(animator3);

        set.start();

        Log.d(TAG, "fold: 33333333333");

    }
}
