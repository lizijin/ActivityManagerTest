package com.peter.activitymanagertest.activity;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by jiangbin on 2018/8/18.
 */

public class RedBehavior extends CoordinatorLayout.Behavior<FrameLayout> {
    public RedBehavior() {}

    public RedBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, FrameLayout child, MotionEvent ev) {
        System.out.println("jiangbin --> redBehavior onInterceptTouchEvent " +ev.toString());
        return super.onInterceptTouchEvent(parent, child, ev);
    }

    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, FrameLayout child, MotionEvent ev) {
        System.out.println("jiangbin --> redBehavior onTouchEvent " +ev.toString());
        return super.onTouchEvent(parent, child, ev);
    }
}
