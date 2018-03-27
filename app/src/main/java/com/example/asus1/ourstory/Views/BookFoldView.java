package com.example.asus1.ourstory.Views;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus1.ourstory.R;

/**
 * Created by asus1 on 2018/3/27.
 *
 *
 *  app:contentPadding="5dp"
 app:cardBackgroundColor="@color/bg_color"
 app:cardCornerRadius="5dp"
 android:layout_marginRight="16dp"
 android:layout_marginLeft="16dp"
 android:layout_marginBottom="16dp"
 app:cardElevation="4dp"
 */

public class BookFoldView extends CardView {
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
    private static final String TAG = "BookFoldView";

    public BookFoldView(Context context) {
        this(context,null);
    }

    public BookFoldView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BookFoldView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init(){
        mTextPaint = new Paint();

        mView_two = findViewById(R.id.view_two);
        mView_two.setPivotY(0);
        mView_two.setPivotX(0);
        mStart = (TextView) findViewById(R.id.tv_start);
        mStart.setPivotY(0);
        mStart.setPivotX(0);
        mUpdate = (TextView) findViewById(R.id.tv_update);
        mUpdate.setPivotX(0);
        mUpdate.setPivotY(0);



    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        int width = 0;
        int height = 0;
        int widthMode;
        int heightMode;
        int h= 0;

        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        heightMode = MeasureSpec.getMode(heightMeasureSpec);


        super.onMeasure(widthMeasureSpec,heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
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

        set.play(animator3).after(animator2).after(animator1);
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

        set.play(animator1).after(animator2).after(animator3);
        set.start();

        Log.d(TAG, "fold: 33333333333");

    }
}
