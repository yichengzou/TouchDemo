package com.example.aaa.touchdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by aaa on 15-4-21.
 */
public class Layout_3 extends FrameLayout {
    private static final String TAG="Layout_3";
    public Layout_3(Context context) {
        super(context);
    }

    public Layout_3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout_3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//   触摸事件的分发,分配触摸事件
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG,"dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }


    //打断触摸事件
    //是否终止本次事件的分发,有本控件处理触摸事件
    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        Log.d(TAG,"onInterceptHoverEvent");
        return super.onInterceptHoverEvent(event);
    }

    //触摸事件的处理
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG,"onTouchEvent");
        return super.onTouchEvent(event);
    }
}
