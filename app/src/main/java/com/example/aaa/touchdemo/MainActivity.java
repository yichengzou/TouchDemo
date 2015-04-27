package com.example.aaa.touchdemo;

import android.gesture.GestureOverlayView;
import android.media.Image;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity implements View.OnTouchListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private float x;
    private float y;
    private ImageView image;
    private GestureDetector detetor;
    private double dis;
    private float scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_text);
        View view = findViewById(R.id.layout);
        image = (ImageView) findViewById(R.id.imagev);

        view.setOnTouchListener(this);

        detetor = new GestureDetector(this, this);
        detetor.setOnDoubleTapListener(this);


    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {


//        switch (event.getAction()){
//            case MotionEvent.ACTION_MOVE:
//                ViewCompat.setTranslationX(image,event.getX()-x+ViewCompat.getTranslationX(image));
//                ViewCompat.setTranslationY(image,event.getY()-y+ViewCompat.getTranslationY(image));
//                break;
//        }
//        x = event.getX();
//        y = event.getY();

        if (event.getPointerCount()==2){
            switch (event.getAction()&MotionEvent.ACTION_MASK){
                case MotionEvent.ACTION_POINTER_DOWN:
                    dis = Math.sqrt(Math.pow(event.getX(1)-event.getX(0),2)+Math.pow(event.getY(1)-event.getY(0),2));
                    scale = ViewCompat.getScaleX(image);
                    break;
                case MotionEvent.ACTION_MOVE:
                    double sqrt = Math.sqrt(Math.pow(event.getX(0) - event.getX(1), 2) + Math.pow(event.getY(0) - event.getY(1), 2));
                    ViewCompat.setScaleX(image, (float) (sqrt/dis)*scale);
                    ViewCompat.setScaleY(image, (float) (sqrt/dis)*scale);
                    break;
            }
        }




        return detetor.onTouchEvent(event);

    }

    //按下事件
    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    //短按事件
    //再按下后100毫秒触发
    @Override
    public void onShowPress(MotionEvent e) {
        
    }

    //单击事件
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    /**
     * e1 开始得点
     * e2结束的点
     * distanceX x轴方向的位移距离
     * distancey  y轴上的位移距离
     */
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        ViewCompat.setTranslationX(image, -distanceX + ViewCompat.getTranslationX(image));
//        ViewCompat.setTranslationY(image, -distanceY + ViewCompat.getTranslationY(image));
        return false;
    }

    //长按事件
    //短按后500毫秒触发
    //该方法出发后就不会触发onSingleTapUp方法
    @Override
    public void onLongPress(MotionEvent e) {

    }

    //抛出事件
    //velocityX x轴上的速度
    //velocityy  y轴上的速度
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (Math.abs(velocityX) > Math.abs(velocityY)) {
            ViewCompat.animate(image).translationX(velocityX/10).setDuration(5000).start();
        } else {
            ViewCompat.animate(image).translationY(velocityY/10).setDuration(5000).start();
        }
        return false;
    }


    //单击完成(在一次单击后没有马上再次触摸屏幕)
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    //双击按下(一次双击中只会调用一次)
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    //双击事件(一次双击中调用两回)
    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
}

