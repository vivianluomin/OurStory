package com.example.asus1.ourstory.Holders;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/4/1.
 */

public class BookFoldHolder extends RecyclerView.ViewHolder  {

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
    private View mViewOne;

    private String mStart_text = "";
    private String mUpdate_text = "";

    private int mWidth;
    private int mHeight;
    private int mSpan = 10;

    private boolean mAnimStart = false;

    private int flag = 0;

    public BookFoldHolder(View itemView) {
        super(itemView);
        init(itemView);
    }


    public void  init (View view) {


        mView_one = view.findViewById(R.id.book_fold_item_one);

        mView_two = view.findViewById(R.id.view_two);
        mView_two.setPivotY(0);
        mView_two.setPivotX(0);
        mStart = (TextView)view. findViewById(R.id.tv_start);
        mStart.setPivotY(0);
        mStart.setPivotX(0);
        mUpdate = (TextView)view. findViewById(R.id.tv_update);
        mUpdate.setPivotX(0);
        mUpdate.setPivotY(0);

        mView_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mAnimStart){
                    if(flag == 0 ){
                        fold();
                        flag = 1;
                    }else {
                        expand();
                        flag = 0;
                    }
                }



            }



        });

        initfold();


    }


    private void initfold(){
        mAnimStart = true;
        flag = 1;
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mUpdate,
                "rotationX",0f,-90f)
                .setDuration(1);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mStart,
                "rotationX",0f,-90f)
                .setDuration(1);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mView_two,
                "rotationX",0f,-90f)
                .setDuration(1);

        animator1.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                mAnimStart = true;
                super.onAnimationStart(animation);

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mUpdate.setVisibility(View.GONE);
            }
        });

        animator2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mStart.setVisibility(View.GONE);
            }
        });

        animator3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mView_two.setVisibility(View.GONE);
                mAnimStart = false;
                mView_one.setBackgroundResource(R.drawable.bg_corner);


            }
        });
        set.play(animator1);
        set.play(animator2).after(animator1);
        set.play(animator3).after(animator2);

        set.start();
    }


    public void expand(){
        mAnimStart = true;
        mView_two.setVisibility(View.INVISIBLE);
        mStart.setVisibility(View.INVISIBLE);
        mUpdate.setVisibility(View.INVISIBLE);
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mUpdate,
                "rotationX",-90f,0f)
                .setDuration(800);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mStart,
                "rotationX",-90f,0f)
                .setDuration(800);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mView_two,
                "rotationX",-90f,0f)
                .setDuration(800);


        animator1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {

                mAnimStart = true;
                mUpdate.setVisibility(View.VISIBLE);
                super.onAnimationStart(animation);

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mAnimStart = false;

            }
        });

        animator2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                mStart.setVisibility(View.VISIBLE);
                super.onAnimationStart(animation);

            }
        });

        animator3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                mView_one.setBackgroundResource(R.drawable.bg_corner_1);
                mView_two.setVisibility(View.VISIBLE);
                super.onAnimationStart(animation);

            }


        });

        set.play(animator3);
        set.play(animator2).after(animator3);
        set.play(animator1).after(animator2);

        set.start();


    }

    public void fold(){


        mAnimStart = true;
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mUpdate,
                "rotationX",0f,-90f)
                .setDuration(800);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mStart,
                "rotationX",0f,-90f)
                .setDuration(800);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mView_two,
                "rotationX",0f,-90f)
                .setDuration(800);

        animator1.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                mAnimStart = true;
                super.onAnimationStart(animation);

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mUpdate.setVisibility(View.INVISIBLE);
            }
        });

        animator2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mStart.setVisibility(View.INVISIBLE);
            }
        });

        animator3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mView_two.setVisibility(View.INVISIBLE);
                mAnimStart = false;
                mView_two.setVisibility(View.GONE);
                mStart.setVisibility(View.GONE);
                mUpdate.setVisibility(View.GONE);
                mView_one.setBackgroundResource(R.drawable.bg_corner);


            }
        });
        set.play(animator1);
        set.play(animator2).after(animator1);
        set.play(animator3).after(animator2);

        set.start();


    }

}
