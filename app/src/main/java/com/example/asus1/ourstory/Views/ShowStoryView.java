package com.example.asus1.ourstory.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.INotificationSideChannel;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;
import android.widget.TextView;

import com.example.asus1.ourstory.Model.FPoint;
import com.example.asus1.ourstory.R;

import java.security.cert.PolicyNode;
import java.util.LinkedList;

/**
 * Created by asus1 on 2018/3/25.
 */

public class ShowStoryView extends View{

    private Context mContext;

    private Path mAPath;
    private Path mBPath;
    private Path mCPath;
    private Paint mAPaint;
    private Paint mCPaint;
    private Paint mBPaint;

    private Paint mTextPaint;

    private FPoint A;
    private FPoint F;
    private FPoint C;
    private FPoint E;
    private FPoint B;
    private FPoint K;
    private FPoint J;
    private FPoint H;
    private FPoint G;
    private FPoint D;
    private FPoint I;
    private BitmapFactory.Options options;
    private  Bitmap mUpPager;
    private Bitmap mNowPager;
    private Bitmap mNextPager;
    private Bitmap mBg;
    private PorterDuffXfermode porter;
    private int mViewWidth;
    private int mVieHeight;

    private float[] mMatrixArray = { 0, 0, 0, 0, 0, 0, 0, 0, 1.0f };
    private Matrix mMatrix;

    private static final String TAG = "ShowStoryView";
    private int mPagerCount = 1;
    private String mNowContent = "AAAAAAAAAAAAAAAA,\n"+
                                   " AAAAAAAAAAAAAAAAA";
    private String mUpContent = "AAAAAAAAAAAAAAA";
    private String mNextContet = "BBBBBBBBBBBBBBBBBBB";
    private String mPreviousContent = "CCCCCCCCCCCCCCCCC";

    private String style;

    private Scroller mScroller;

    private GradientDrawable mDrawableBTopRight;
    private GradientDrawable mDrawableBLowerRight;

    private GradientDrawable mDrawableCTopRight;
    private GradientDrawable mDrawableCLowerRight;

    private GradientDrawable mDrawableBTopLeft;
    private GradientDrawable mDrawableBLowerLeft;

    private GradientDrawable mDrawableCTopLeft;
    private GradientDrawable mDrawableCLowerLeft;


    private LinkedList<String> mContents = new LinkedList<>();
    public static final String STYLE_LEFT = "STYLE_LEFT";//点击左边区域
    public static final String STYLE_RIGHT = "STYLE_RIGHT";//点击右边区域
    public static final String STYLE_MIDDLE = "STYLE_MIDDLE";//点击中间区域
    public static final String STYLE_TOP_RIGHT = "STYLE_TOP_RIGHT";//f点在右上角
    public static final String STYLE_LOWER_LEFT = "STYLE_LOWER_LEFT";//f点在左下角
    public static final String STYLE_TOP_LEFT = "STYLE_TOP_LEFT";//f点在左上角
    public static final String STYLE_LOWER_RIGHT = "STYLE_LOWER_RIGHT";//f点在右下角


    public ShowStoryView(Context context) {
        this(context,null);
    }

    public ShowStoryView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ShowStoryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        init();

    }

    private void init(){
        mScroller = new Scroller(mContext);
        mAPaint = new Paint();

        mBPaint = new Paint();
        mCPaint = new Paint();
        mTextPaint = new Paint();
        mTextPaint.setColor(getResources().getColor(R.color.Text_color));
        mTextPaint.setTextSize(24);

        mAPaint.setAntiAlias(true);
        mAPaint.setStyle(Paint.Style.STROKE);
        mAPaint.setStrokeWidth(2);
        mAPaint.setColor(Color.rgb(192,150,76));
        mBPaint.setAntiAlias(true);
        mBPaint.setStyle(Paint.Style.STROKE);
        mBPaint.setColor(Color.rgb(192,150,76));
        mCPaint.setAntiAlias(true);
        mCPaint.setStyle(Paint.Style.FILL);
        mCPaint.setColor(Color.rgb(192,150,100));
        mAPath = new Path();
        mBPath = new Path();
        mCPath = new Path();
        A = new FPoint();
        B = new FPoint();
        C = new FPoint();
        E = new FPoint();
        K = new FPoint();
        J = new FPoint();
        H = new FPoint();
        G = new FPoint();
        F = new FPoint();
        D = new FPoint();
        I = new FPoint();

        A.x = -1;
        A.y = -1;

        porter =  new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
       // mCPaint.setXfermode(porter);
        mMatrix = new Matrix();
        createGradientDrawable();
        style = STYLE_LOWER_RIGHT;

    }


    private void createGradientDrawable(){
        int deepColor = 0x33333333;
        int lightColor = 0x01333333;
        int[] gradientColors = new int[]{lightColor,deepColor};//渐变颜色数组

        deepColor = 0x55111111;
        lightColor = 0x00111111;
        gradientColors = new int[] {deepColor,lightColor};//渐变颜色数组
        mDrawableBTopRight =new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,gradientColors);
        mDrawableBTopRight.setGradientType(GradientDrawable.LINEAR_GRADIENT);//线性渐变
        mDrawableBTopRight =new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT,gradientColors);
        mDrawableBTopRight.setGradientType(GradientDrawable.LINEAR_GRADIENT);

        mDrawableBTopLeft =new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,gradientColors);
        mDrawableBTopLeft.setGradientType(GradientDrawable.LINEAR_GRADIENT);//线性渐变
        mDrawableBTopLeft =new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT,gradientColors);
        mDrawableBTopLeft.setGradientType(GradientDrawable.LINEAR_GRADIENT);

        mDrawableBLowerRight =new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,gradientColors);
        mDrawableBLowerRight.setGradientType(GradientDrawable.LINEAR_GRADIENT);//线性渐变
        mDrawableBLowerRight =new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT,gradientColors);
        mDrawableBLowerRight.setGradientType(GradientDrawable.LINEAR_GRADIENT);


        mDrawableBLowerLeft =new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,gradientColors);
        mDrawableBLowerLeft.setGradientType(GradientDrawable.LINEAR_GRADIENT);//线性渐变
        mDrawableBLowerLeft =new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT,gradientColors);
        mDrawableBLowerLeft.setGradientType(GradientDrawable.LINEAR_GRADIENT);



        deepColor = 0x55333333;
        lightColor = 0x00333333;
        gradientColors = new int[]{lightColor,deepColor};//渐变颜色数组
        mDrawableCTopRight = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, gradientColors);
        mDrawableCTopRight.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        mDrawableCTopRight = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, gradientColors);
        mDrawableCTopRight.setGradientType(GradientDrawable.LINEAR_GRADIENT);

        mDrawableCTopLeft = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, gradientColors);
        mDrawableCTopLeft.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        mDrawableCTopLeft = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, gradientColors);
        mDrawableCTopLeft.setGradientType(GradientDrawable.LINEAR_GRADIENT);


        mDrawableCLowerLeft = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, gradientColors);
        mDrawableCLowerLeft.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        mDrawableCLowerLeft= new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, gradientColors);
        mDrawableCLowerLeft.setGradientType(GradientDrawable.LINEAR_GRADIENT);

        mDrawableCLowerRight = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, gradientColors);
        mDrawableCLowerRight.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        mDrawableCLowerRight= new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, gradientColors);
        mDrawableCLowerRight.setGradientType(GradientDrawable.LINEAR_GRADIENT);

    }

    private void drawPathAContentBitmap(Bitmap bitmap,Paint pathPaint){
        Canvas canvas = new Canvas(bitmap);
        canvas.drawPath(getPathDefault(),pathPaint);
        canvas.drawText(mNowContent,50,50,mTextPaint);

    }

    private void drawPathBContentBitmap(Bitmap bitmap,Paint pathPaint){
        Canvas canvas = new Canvas(bitmap);
        canvas.drawPath(getPathDefault(),pathPaint);
        canvas.drawText(mNextContet,50,50,mTextPaint);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mViewWidth = MeasureSpec.getSize(widthMeasureSpec);
        mVieHeight = MeasureSpec.getSize(heightMeasureSpec);
        F.x = mViewWidth;
        F.y = mVieHeight;
        A.x = -1;
        A.y = -1;
        options = new BitmapFactory.Options();
        options.outHeight = mVieHeight;
        options.outWidth = mViewWidth;
        mBg = BitmapFactory.decodeResource(getResources(),R.drawable.bg_read,options);
       // mNowPager = Bitmap.createBitmap(mViewWidth,mVieHeight, Bitmap.Config.RGB_565);
        mNowPager = mBg.copy(Bitmap.Config.RGB_565,true);
        drawPathAContentBitmap(mNowPager,mAPaint);
        mUpPager = Bitmap.createBitmap(mViewWidth,mVieHeight, Bitmap.Config.RGB_565);
        drawPathAContentBitmap(mUpPager,mCPaint);
       // mNextPager = Bitmap.createBitmap(mViewWidth,mVieHeight, Bitmap.Config.RGB_565);
        mNextPager = mBg.copy(Bitmap.Config.RGB_565,true);
        drawPathBContentBitmap(mNextPager,mBPaint);

    }


    private int measureSize(int defaultSize,int measureSpec) {
        int result = defaultSize;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);

        if (specMode == View.MeasureSpec.EXACTLY) {
            result = specSize;
        } else if (specMode == View.MeasureSpec.AT_MOST) {
            result = Math.min(result, specSize);
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {

            canvas.drawColor(Color.rgb(192,150,100));

            if(A.x == -1&&A.y ==-1){
               drawPathAContent(canvas,getPathDefault());
            }else {
                if(F.x == mViewWidth && F.y==0){
                    drawPathAContent(canvas,getPathAFromTopRight());
                    drawPathCContent(canvas,getPathAFromTopRight());
                    drawPathBContent(canvas,getPathAFromTopRight());
                }else if(F.x == mViewWidth &&F.y == mVieHeight){
                    //beginTrace("drawPathA");
                    drawPathAContent(canvas,getPathAFromLowerRight());
                   // endTrace();

                  //  beginTrace("drawPathC");
                    drawPathCContent(canvas,getPathAFromLowerRight());
                  //  endTrace();

                  //  beginTrace("drawPathB");
                    drawPathBContent(canvas,getPathAFromLowerRight());
                  //  endTrace();
                }else if (F.x ==0&&F.y == mVieHeight){
                    drawPathAContent(canvas,getPathAFromLowerLeft());
                    drawPathCContent(canvas,getPathAFromLowerLeft());
                    drawPathBContent(canvas,getPathAFromLowerLeft());
                }else if(F.x == 0&&F.y ==0){
                    drawPathAContent(canvas,getPathAFromTopLeft());
                    drawPathCContent(canvas,getPathAFromTopLeft());
                    drawPathBContent(canvas,getPathAFromTopLeft());
                }
            }



    }

    private void drawPathAContent(Canvas canvas,Path path){
        canvas.save();
        canvas.clipPath(path, Region.Op.INTERSECT);
        canvas.drawBitmap(mNowPager,0,0,null);
        canvas.restore();
    }

    private void drawPathBContent(Canvas canvas, Path pathA){
        canvas.save();
        canvas.clipPath(pathA);//裁剪出A区域
        canvas.clipPath(getPathC(),Region.Op.UNION);//裁剪出A和C区域的全集
        canvas.clipPath(getPathB(), Region.Op.REVERSE_DIFFERENCE);//裁剪出B区域中不同于与AC区域的部分
        canvas.drawBitmap(mNextPager, 0, 0, null);

        drawPathBShaow(canvas);
        canvas.restore();
    }

    private void drawPathBShaow(Canvas canvas){
        int deepColor = 0x55111111;
        int lightColor = 0x11111111;
        int[] gradientColors = new int[]{deepColor,lightColor};

        int deepOffset = 0;
        int lightOffset = 0;
        float aTof = (float)Math.hypot(A.x-F.x,A.y-F.y);
        float viewDiagonaLength =(float)Math.hypot(mViewWidth,mVieHeight);

        int left=0;
        int right=0;
        int top = (int)C.y;
        int bottom = (int) (viewDiagonaLength+C.y);
        GradientDrawable gradientDrawable;
        if(style.equals(STYLE_TOP_RIGHT)){//f点在右上角
            //从左向右线性渐变
          gradientDrawable = mDrawableBTopRight;
            left = (int) (C.x - deepOffset);//c点位于左上角
            right = (int) (C.x + aTof/6 + lightOffset);
        }else if(style.equals(STYLE_LOWER_RIGHT)){
            //从右向左线性渐变
           gradientDrawable = mDrawableBLowerRight;

            left = (int) (C.x - aTof/6 - lightOffset);//c点位于左下角
            right = (int) (C.x + deepOffset);
        }else if(style.equals(STYLE_TOP_LEFT)){
            gradientDrawable = mDrawableBTopLeft;

        }else {
            gradientDrawable = mDrawableBLowerLeft;
        }
        gradientDrawable.setBounds(left,top,right,bottom);//设置阴影矩形

        float rotateDegrees = (float) Math.toDegrees(Math.atan2(E.x- F.x, H.y - F.y));//旋转角度
        canvas.rotate(rotateDegrees, C.x, C.y);//以c为中心点旋转
        gradientDrawable.draw(canvas);


    }

    private void drawPathCContent(Canvas canvas, Path pathA){
        canvas.save();
        canvas.clipPath(pathA);
        canvas.clipPath(getPathC(), Region.Op.REVERSE_DIFFERENCE);//裁剪出C区域不同于A区域的部分
//        canvas.drawPath(getPathC(),pathCPaint);

        float eh = (float) Math.hypot(F.x - E.x,H.y - F.y);
        float sin0 = (F.x - E.x) / eh;
        float cos0 = (H.y - F.y) / eh;
        //设置翻转和旋转矩阵
        mMatrixArray[0] = -(1-2 * sin0 * sin0);
        mMatrixArray[1] = 2 * sin0 * cos0;
        mMatrixArray[3] = 2 * sin0 * cos0;
        mMatrixArray[4] = 1 - 2 * sin0 * sin0;

        mMatrix.reset();
        mMatrix.setValues(mMatrixArray);//翻转和旋转
        mMatrix.preTranslate(-E.x, -E.y);//沿当前XY轴负方向位移得到 矩形A₃B₃C₃D₃
        mMatrix.postTranslate(E.x, E.y);//沿原XY轴方向位移得到 矩形A4 B4 C4 D4
        canvas.drawBitmap(mUpPager, mMatrix, null);

        drawPathCShadow(canvas);

        canvas.restore();
    }


    private void drawPathCShadow(Canvas canvas){
        int deepColor = 0x55111111;//为了让效果更明显使用此颜色代码，具体可根据实际情况调整
//        int deepColor = 0x55333333;
        int lightColor = 0x00333333;
        int[] gradientColors = {lightColor,deepColor};//渐变颜色数组

        int deepOffset = 1;//深色端的偏移值
        int lightOffset = -30;//浅色端的偏移值
        float viewDiagonalLength = (float) Math.hypot(mViewWidth, mVieHeight);//view对角线长度
        int midpoint_ce = (int) (C.x + E.x) / 2;//ce中点
        int midpoint_jh = (int) (J.y + H.y) / 2;//jh中点
        float minDisToControlPoint = Math.min(Math.abs(midpoint_ce - E.x), Math.abs(midpoint_jh - H.y));//中点到控制点的最小值

        int left;
        int right;
        int top = (int) C.y;
        int bottom = (int) (viewDiagonalLength + C.y);
        GradientDrawable gradientDrawable;
        if (style.equals(STYLE_TOP_RIGHT)) {
            gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, gradientColors);
            gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);

            left = (int) (C.x - lightOffset);
            right = (int) (C.x + minDisToControlPoint + deepOffset);
        } else {
            gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, gradientColors);
            gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);

            left = (int) (C.x - minDisToControlPoint - deepOffset);
            right = (int) (C.x + lightOffset);
        }
        gradientDrawable.setBounds(left,top,right,bottom);

        float mDegrees = (float) Math.toDegrees(Math.atan2(E.x- F.x, H.y - F.y));
        canvas.rotate(mDegrees, C.x, C.y);
        gradientDrawable.draw(canvas);
    }



    private Path getPathB(){
        mBPath.reset();
        mBPath.moveTo(0,0);
        mBPath.lineTo(0, mVieHeight);
        mBPath.lineTo(mViewWidth,mVieHeight);
        mBPath.lineTo(mViewWidth,0);
        mBPath.close();//闭合区域
        return mBPath;
    }

    public void setDefaultPath(){
        A.x = -1;
        A.y = -1;
        postInvalidate();
    }

    private Path getPathDefault(){
        mAPath.reset();
        mAPath.lineTo(0, mVieHeight);
        mAPath.lineTo(mViewWidth,mVieHeight);
        mAPath.lineTo(mViewWidth,0);
        mAPath.close();
        return mAPath;
    }


    private Path getPathC(){
        mCPath.reset();
        mCPath.moveTo(I.x,I.y);
        mCPath.lineTo(D.x,D.y);
        mCPath.lineTo(B.x,B.y);
        mCPath.lineTo(A.x,A.y);
        mCPath.lineTo(K.x,K.y);
        mCPath.close();
        return mCPath;
    }

    private Path getPathAFromTopRight(){
        mAPath.reset();
        mAPath.lineTo(C.x,C.y);//移动到c点
        mAPath.quadTo(E.x,E.y,B.x,B.y);//从c到b画贝塞尔曲线，控制点为e
        mAPath.lineTo(A.x,A.y);//移动到a点
        mAPath.lineTo(K.x,K.y);//移动到k点
        mAPath.quadTo(H.x,H.y,J.x,J.y);//从k到j画贝塞尔曲线，控制点为h
        mAPath.lineTo(mViewWidth,mVieHeight);//移动到右下角
        mAPath.lineTo(0,mVieHeight);
        mAPath.lineTo(0,0);
        mAPath.close();
        return mAPath;
    }

    private Path getPathAFromLowerRight(){
        mAPath.reset();
        mAPath.lineTo(0,F.y);
        mAPath.lineTo(C.x,C.y);
        mAPath.quadTo(E.x,E.y,B.x,B.y);
        mAPath.lineTo(A.x,A.y);
        mAPath.lineTo(K.x,K.y);
        mAPath.quadTo(H.x,H.y,J.x,J.y);
        mAPath.lineTo(F.x,0);
        mAPath.lineTo(0,0);
        mAPath.close();
        return mAPath;
    }


    private Path getPathAFromLowerLeft(){
        mAPath.reset();
        mAPath.moveTo(0,0);
        mAPath.lineTo(J.x,J.y);
        mAPath.quadTo(H.x,H.y,K.x,K.y);
        mAPath.lineTo(A.x,A.y);
        mAPath.lineTo(B.x,B.y);
        mAPath.quadTo(E.x,E.y,C.x,C.y);
        mAPath.lineTo(mViewWidth,mVieHeight);
        mAPath.lineTo(mViewWidth,0);


        mAPath.close();

        return mAPath;
    }

    private Path getPathAFromTopLeft(){


        mAPath.reset();
        mAPath.moveTo(0,mVieHeight);
        mAPath.lineTo(J.x,J.y);
        mAPath.quadTo(H.x,H.y,K.x,K.y);
        mAPath.lineTo(A.x,A.y);
        mAPath.lineTo(B.x,B.y);
        mAPath.quadTo(E.x,E.y,C.x,C.y);
        mAPath.lineTo(mViewWidth,0);
        mAPath.lineTo(mViewWidth,mVieHeight);

        mAPath.close();


        return mAPath;

    }



    private FPoint getIntersectionPoint(FPoint lineOne_My_pointOne, FPoint lineOne_My_pointTwo, FPoint lineTwo_My_pointOne, FPoint lineTwo_My_pointTwo){
        float x1,y1,x2,y2,x3,y3,x4,y4;
        x1 = lineOne_My_pointOne.x;
        y1 = lineOne_My_pointOne.y;
        x2 = lineOne_My_pointTwo.x;
        y2 = lineOne_My_pointTwo.y;
        x3 = lineTwo_My_pointOne.x;
        y3 = lineTwo_My_pointOne.y;
        x4 = lineTwo_My_pointTwo.x;
        y4 = lineTwo_My_pointTwo.y;

        float pointX =((x1 - x2) * (x3 * y4 - x4 * y3) - (x3 - x4) * (x1 * y2 - x2 * y1))
                / ((x3 - x4) * (y1 - y2) - (x1 - x2) * (y3 - y4));
        float pointY =((y1 - y2) * (x3 * y4 - x4 * y3) - (x1 * y2 - x2 * y1) * (y3 - y4))
                / ((y1 - y2) * (x3 - x4) - (x1 - x2) * (y3 - y4));

        return  new FPoint( pointX, pointY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
               if(x>mViewWidth/3 && y<=mVieHeight/3) {//右上角
                   style = STYLE_TOP_RIGHT;
                   setTouchPoint(x, y, style,false);

               }else if(x>mViewWidth/3 && y>mVieHeight*2/3){//右下角
                    style = STYLE_LOWER_RIGHT;
                    setTouchPoint( x,y,style,false);

                }else if(x>mViewWidth/3 && x<mViewWidth*2/3
                        && y>mVieHeight/3 && y<mVieHeight*2/3){//中
                    style = STYLE_MIDDLE;
                }else if (x<mViewWidth/3&&y<mVieHeight/3){//左上角

                    style = STYLE_TOP_LEFT;
                    setTouchPoint( x,y,style,false);

                }else if(x<mViewWidth/2&&y>mVieHeight*2/3){
                    style = STYLE_LOWER_LEFT;
                    setTouchPoint( x,y,style,false);

                }else if(x>mViewWidth*2/3&&y>mVieHeight/3&&y<mVieHeight*2/3){
                    style = STYLE_RIGHT;
                    setTouchPoint( x,y,style,false);

                }
                break;
            case MotionEvent.ACTION_MOVE:
                setTouchPoint((int) x,(int) y,style,false);
                break;
            case MotionEvent.ACTION_UP:
                startCancelAnim();
                break;
        }
        return true;
    }

    /**
     * 取消翻页动画,计算滑动位置与时间
     */
    public void startCancelAnim(){
        int dx=0,dy=0;

        if(style.equals(STYLE_TOP_RIGHT)){
           dx= (int)(-A.x-mViewWidth);
            dy = (int) (-A.y);
        }else if(style.equals(STYLE_LOWER_RIGHT)){
            dx= (int)(-A.x-mViewWidth);
            dy = (int) (mVieHeight-A.y);
        }else if(style.equals(STYLE_TOP_LEFT)){
            dx = (int) (mViewWidth*2-A.x);
            dy = (int)(1-A.y);
        }else if(style.equals(STYLE_LOWER_LEFT)){
            dx = (int) (mViewWidth*2-A.x);
            dy = (int) (mVieHeight-A.y);
        }
        mScroller.startScroll((int) A.x, (int) A.y, dx, dy, 400);
    }


    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            float x = mScroller.getCurrX();
            float y = mScroller.getCurrY();
            if(style.equals(STYLE_TOP_RIGHT)){
                setTouchPoint(x,y,STYLE_TOP_RIGHT,true);

            }else if(style.equals(STYLE_LOWER_RIGHT)) {
                setTouchPoint(x,y,STYLE_LOWER_RIGHT,true);

            }else if(style.equals(STYLE_TOP_LEFT)){
                setTouchPoint(x,y,STYLE_TOP_LEFT,true);

            }else if(style.equals(STYLE_LOWER_LEFT)){
                setTouchPoint(x,y,STYLE_LOWER_LEFT,true);
            }
            if (mScroller.getFinalX() == x && mScroller.getFinalY() == y){
                setDefaultPath();
            }
        }
    }

    public void setTouchPoint(float x, float y, String style,boolean scroll){
        FPoint touchPoint = new FPoint();
        A.x =  x;
        A.y =  y;
        this.style = style;
        switch (style){
            case STYLE_TOP_RIGHT:
                F.x = mViewWidth;
                F.y = 0;
                calcPointsXY(A,F);
                touchPoint = new FPoint(x,y);
                if(!scroll&&calcPointCX(touchPoint,F)<0){//如果c点x坐标小于0则重新测量a点坐标
                    calcPointAByTouchPoint();
                    calcPointsXY(A,F);
                }
                postInvalidate();
                break;
//            case STYLE_LEFT:
//                A.y = mVieHeight-1;
//                F.x = 0;
//                F.y = mVieHeight;
//                calcPointsXY(A,F);
//                postInvalidate();
//                break;
//            case STYLE_RIGHT:
//
//                A.y = mVieHeight-1;
//                F.x = mViewWidth;
//                F.y = mVieHeight;
//                calcPointsXY(A,F);
//                postInvalidate();
//                break;

            case STYLE_LOWER_RIGHT:
                F.x = mViewWidth;
                F.y = mVieHeight;

                calcPointsXY(A,F);
                touchPoint = new FPoint(x,y);
                if(!scroll&&calcPointCX(touchPoint,F)<0){//如果c点x坐标小于0则重新测量a点坐标
                    calcPointAByTouchPoint();
                    calcPointsXY(A,F);
                }
                postInvalidate();
                break;
            case STYLE_LOWER_LEFT:
                F.x = 0;
                F.y = mVieHeight;
                calcPointsXY(A,F);
                touchPoint = new FPoint(x,y);
                if(!scroll&&calcPointCX(touchPoint,F)>mViewWidth){
                    calcPointAByTouchPointLeft();
                    calcPointsXY(A,F);
                }
                postInvalidate();
                break;
            case STYLE_TOP_LEFT:
                F.x = 0;
                F.y = 0;
                calcPointsXY(A,F);
                touchPoint = new FPoint(x,y);
                if(!scroll&&calcPointCX(touchPoint,F)>mViewWidth){
                    calcPointAByTouchPointLeft();
                    calcPointsXY(A,F);
                }
                postInvalidate();
                break;

            default:
                break;
        }
    }

    /**
     * 如果c点x坐标小于0,根据触摸点重新测量a点坐标
     */
    private void calcPointAByTouchPoint(){
        float w0 =Math.abs(mViewWidth - C.x);

        float w1 = Math.abs(F.x - A.x);
        float w2 = mViewWidth * w1 / w0;
        A.x = Math.abs(F.x - w2);

        float h1 = Math.abs(F.y - A.y);
        float h2 = w2 * h1 / w1;
        A.y =  Math.abs(F.y - h2);
    }


    private void calcPointAByTouchPointLeft(){
        float w0 =C.x;

        float w1 = Math.abs(F.x - A.x);
        float w2 = mViewWidth * w1 / w0;
        A.x = Math.abs(F.x - w2);

        float h1 = Math.abs(F.y - A.y);
        float h2 = w2 * h1 / w1;
        A.y =  Math.abs(F.y - h2);
    }

    private void calcPointsXY(FPoint a, FPoint f){
        G.x = (a.x + f.x) / 2;
        G.y = (a.y + f.y) / 2;

        E.x = G.x - (f.y - G.y) * (f.y - G.y) / (f.x - G.x);
        E.y = f.y;

        H.x = f.x;
        Log.e(TAG, "calcPointsXY: "+f.y+" "+f.x);
        H.y = G.y - (f.x - G.x) * (f.x - G.x) / (f.y - G.y);

        C.x = E.x - (f.x - E.x) / 2;
        C.y = f.y;

        J.x = f.x;
        J.y = H.y - (f.y - H.y) / 2;

        B = getIntersectionPoint(a,E,C,J);
        K = getIntersectionPoint(a,H,C,J);

        D.x = (C.x + 2 * E.x + B.x) / 4;
        D.y = (2 * E.y + C.y + B.y) / 4;

        I.x = (J.x + 2 * H.x + K.x) / 4;
        I.y = (2 * H.y + J.y + K.y) / 4;

//        //计算d点到ae的距离
//        float lA = a.y-e.y;
//        float lB = e.x-a.x;
//        float lC = a.x*e.y-e.x*a.y;
//        lPathAShadowDis = Math.abs((lA*d.x+lB*d.y+lC)/(float) Math.hypot(lA,lB));
//
//        //计算i点到ah的距离
//        float rA = a.y-h.y;
//        float rB = h.x-a.x;
//        float rC = a.x*h.y-h.x*a.y;
//        rPathAShadowDis = Math.abs((rA*i.x+rB*i.y+rC)/(float) Math.hypot(rA,rB));
    }

    private float calcPointCX(FPoint a, FPoint f){
        FPoint g,e;
        g = new FPoint();
        e = new FPoint();
        g.x = (a.x + f.x) / 2;
        g.y = (a.y + f.y) / 2;

        e.x = g.x - (f.y - g.y) * (f.y - g.y) / (f.x - g.x);
        e.y = f.y;

        return e.x - (f.x - e.x) / 2;
    }

    public void setData(LinkedList<String> contents){
        mContents = contents;
    }




}


