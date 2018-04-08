package com.example.asus1.ourstory.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
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
import android.widget.TextView;

import com.example.asus1.ourstory.R;

import java.security.cert.PolicyNode;

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

    private Point A;
    private Point F;
    private Point C;
    private Point E;
    private Point B;
    private Point K;
    private Point J;
    private Point H;
    private Point G;
    private Point D;
    private Point I;
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

    private String style;
    public static final String STYLE_LEFT = "STYLE_LEFT";//点击左边区域
    public static final String STYLE_RIGHT = "STYLE_RIGHT";//点击右边区域
    public static final String STYLE_MIDDLE = "STYLE_MIDDLE";//点击中间区域
    public static final String STYLE_TOP_RIGHT = "STYLE_TOP_RIGHT";//f点在右上角
    public static final String STYLE_LOWER_LEFT = "STYLE_LOWER_LEFT";//f点在右下角
    public static final String STYLE_TOP_LEFT = "STYLE_TOP_LEFT";//f点在右下角
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
        mAPaint = new Paint();

        mBPaint = new Paint();
        mCPaint = new Paint();
        mTextPaint = new Paint();
        mTextPaint.setColor(getResources().getColor(R.color.Text_color));
        mTextPaint.setTextSize(16);
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
        A = new Point();
        B = new Point();
        C = new Point();
        E = new Point();
        K = new Point();
        J = new Point();
        H = new Point();
        G = new Point();
        F = new Point();
        D = new Point();
        I = new Point();

        A.x = -1;
        A.y = -1;

        porter =  new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
       // mCPaint.setXfermode(porter);
        mMatrix = new Matrix();
        style = STYLE_LOWER_RIGHT;

    }

    private void drawPathAContentBitmap(Bitmap bitmap,Paint pathPaint){
        Canvas canvas = new Canvas(bitmap);
        canvas.drawPath(getPathDefault(),pathPaint);
        canvas.drawText("AAAAAAAAAAA",mViewWidth/2,mVieHeight/2,mTextPaint);

    }

    private void drawPathBContentBitmap(Bitmap bitmap,Paint pathPaint){
        Canvas canvas = new Canvas(bitmap);
        canvas.drawPath(getPathDefault(),pathPaint);
        canvas.drawText("BBBBBBBBBBBB",mViewWidth/2,mVieHeight/2,mTextPaint);
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

        canvas.restore();
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

        canvas.restore();
    }


    private Path getPathB(){
        mBPath.reset();
        mBPath.lineTo(0, F.y);//移动到左下角
        mBPath.lineTo(F.x,F.y);//移动到右下角
        mBPath.lineTo(F.x,0);//移动到右上角
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
        mAPath.close();
        return mAPath;
    }


    private Path getPathAFromLowerLeft(){
        mAPath.reset();
        mAPath.lineTo(0,0);
        mAPath.lineTo(C.x,C.y);
        mAPath.quadTo(E.x,E.y,B.x,B.y);
        mAPath.lineTo(A.x,A.y);
        mAPath.lineTo(K.x,K.y);
        mAPath.quadTo(H.x,H.y,J.x,J.y);
        mAPath.lineTo(mViewWidth,mVieHeight);//移动到右下角
        mAPath.close();

        return mAPath;
    }

    private Path getPathAFromTopLeft(){
        mAPath.reset();
        mAPath.lineTo(C.x,C.y);//移动到c点
        mAPath.quadTo(E.x,E.y,B.x,B.y);//从c到b画贝塞尔曲线，控制点为e
        mAPath.lineTo(A.x,A.y);//移动到a点
        mAPath.lineTo(K.x,K.y);//移动到k点
        mAPath.quadTo(H.x,H.y,J.x,J.y);//从k到j画贝塞尔曲线，控制点为h
        mAPath.lineTo(0, mVieHeight);//移动到左下角
        mAPath.lineTo(mViewWidth,mVieHeight);//移动到右下角

        mAPath.close();

        return mAPath;
    }



    private Point getIntersectionPoint(Point lineOne_My_pointOne, Point lineOne_My_pointTwo, Point lineTwo_My_pointOne, Point lineTwo_My_pointTwo){
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

        return  new Point((int) pointX,(int) pointY);
    }



    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(x<=mViewWidth/3){//左
                    style = STYLE_LEFT;
                    setTouchPoint((int) x,(int) y,style);

                }else if(x>mViewWidth/3 && y<=mVieHeight/3){//上
                    style = STYLE_TOP_RIGHT;
                    setTouchPoint((int) x,(int) y,style);

                }else if(x>mViewWidth*2/3 && y>mVieHeight/3 && y<=mVieHeight*2/3){//右
                    style = STYLE_RIGHT;
                    setTouchPoint((int) x,(int) y,style);

                }else if(x>mViewWidth/3 && y>mVieHeight*2/3){//下
                    style = STYLE_LOWER_RIGHT;
                    setTouchPoint((int) x,(int) y,style);

                }else if(x>mViewWidth/3 && x<mViewWidth*2/3
                        && y>mVieHeight/3 && y<mVieHeight*2/3){//中
                    style = STYLE_MIDDLE;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                setTouchPoint((int) x,(int) y,style);
                break;
            case MotionEvent.ACTION_UP:
                //startCancelAnim();
                break;
        }
        return true;
    }


    public void setTouchPoint(int x, int y, String style){
        Point touchPoint = new Point();
        A.x =  x;
        A.y =  y;
        this.style = style;
        switch (style){
            case STYLE_TOP_RIGHT:
                F.x = mViewWidth;
                F.y = 0;
                calcPointsXY(A,F);
                touchPoint = new Point(x,y);
                if(calcPointCX(touchPoint,F)<0){//如果c点x坐标小于0则重新测量a点坐标
                    calcPointAByTouchPoint();
                    calcPointsXY(A,F);
                }
                postInvalidate();
                break;
            case STYLE_LEFT:
            case STYLE_RIGHT:
                A.y = mVieHeight-1;
                F.x = mViewWidth;
                F.y = mViewWidth;
                calcPointsXY(A,F);
                postInvalidate();
                break;
            case STYLE_LOWER_RIGHT:
                F.x = mViewWidth;
                F.y = mVieHeight;
                calcPointsXY(A,F);
                touchPoint = new Point(x,y);
                if(calcPointCX(touchPoint,F)<0){//如果c点x坐标小于0则重新测量a点坐标
                    calcPointAByTouchPoint();
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
        float w0 = mViewWidth - C.x;

        float w1 = Math.abs(F.x - A.x);
        float w2 = mViewWidth * w1 / w0;
        A.x =(int) Math.abs(F.x - w2);

        float h1 = Math.abs(F.y - A.y);
        float h2 = w2 * h1 / w1;
        A.y = (int) Math.abs(F.y - h2);
    }

    private void calcPointsXY(Point a, Point f){
        G.x = (a.x + f.x) / 2;
        G.y = (a.y + f.y) / 2;

        E.x = G.x - (f.y - G.y) * (f.y - G.y) / (f.x - G.x);
        E.y = f.y;

        H.x = f.x;
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

    private float calcPointCX(Point a, Point f){
        Point g,e;
        g = new Point();
        e = new Point();
        g.x = (a.x + f.x) / 2;
        g.y = (a.y + f.y) / 2;

        e.x = g.x - (f.y - g.y) * (f.y - g.y) / (f.x - g.x);
        e.y = f.y;

        return e.x - (f.x - e.x) / 2;
    }


}


