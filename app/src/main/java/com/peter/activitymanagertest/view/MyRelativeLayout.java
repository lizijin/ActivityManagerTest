package com.peter.activitymanagertest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by jiangbin on 2018/7/22.
 */

public class MyRelativeLayout extends RelativeLayout {
    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        System.out.println("jiangbin--> mode "+MeasureSpec.getMode(widthMeasureSpec)+" width "+MeasureSpec.getSize(widthMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean dispatch = super.dispatchTouchEvent(ev);
        System.out.println("jiangbin-> dispatchTouchEvent "+ev.toString());
        System.out.println("jiangbin-> myRel "+dispatch);
        return dispatch;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        System.out.println("jiangbin-> onInterceptTouchEvent "+ev.toString());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("jiangbin-> onTouchEvent "+event.toString());

        return super.onTouchEvent(event);
    }
}
