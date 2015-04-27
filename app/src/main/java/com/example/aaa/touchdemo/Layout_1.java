package com.example.aaa.touchdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by aaa on 15-4-21.
 */
public class Layout_1 extends FrameLayout {
    private static final String TAG="tag";
    public Layout_1(Context context) {
        super(context);
    }

    public Layout_1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout_1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//   触摸事件的分发,分配触摸事件
    //返回值是否完成分发,返回值不能改动,除非自定义分发规则
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG,"dispatchTouchEvent");
        boolean b = super.dispatchTouchEvent(ev);
        Log.d(TAG,b+"================");
        System.out.print(b+"================");
        return b;
    }


    //打断触摸事件
    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        Log.d(TAG,"onInterceptHoverEvent");
        return super.onInterceptHoverEvent(event);
    }

    //触摸事件的处理
    //返回值是否处理完事件
    //如果返回值是true,那么接下来的触摸事件都由该控件处理
    //返回值只有在ACTION_DWON有效
    @Override
    public boolean onTouchEvent(MotionEvent event) {
       // Log.d(TAG,"onTouchEvent");

        return false;
    }
}
