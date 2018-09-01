package com.peter.activitymanagertest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jiangbin on 2018/7/24.
 */

public class LifeCycleView extends View {
    public LifeCycleView(Context context) {
        super(context);
    }

    public LifeCycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LifeCycleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LifeCycleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        System.out.println("jiangbin--> onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        System.out.println("jiangbin--> onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("jiangbin--> onDraw");
//        try {
//            Thread.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN)return true;
        boolean dispatch = super.dispatchTouchEvent(event);
        System.out.println("jiangbin-> dispatchTouchEvent life "+event.toString());
        System.out.println("jiangbin-> life "+dispatch);
        return false;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        System.out.println("jiangbin--> animation onDetachedFromWindow");

    }
}
