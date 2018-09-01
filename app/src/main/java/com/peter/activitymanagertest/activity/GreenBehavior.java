package com.peter.activitymanagertest.activity;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by jiangbin on 2018/8/18.
 */

public class GreenBehavior extends CoordinatorLayout.Behavior<FrameLayout> {
    public GreenBehavior() {}

    public GreenBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, FrameLayout child, MotionEvent ev) {
        System.out.println("jiangbin --> GreenBehavior onInterceptTouchEvent " +ev.toString());
        super.onInterceptTouchEvent(parent,child,ev);
        return true;
    }

    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, FrameLayout child, MotionEvent ev) {
        System.out.println("jiangbin --> GreenBehavior onTouchEvent " +ev.toString());
        super.onTouchEvent(parent,child,ev);
//        return super.onTouchEvent(parent, child, ev);
        return true;
    }

}
