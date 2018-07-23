package com.peter.activitymanagertest.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by jiangbin on 2018/7/22.
 */

public class MyFrameLayout extends FrameLayout {

    public MyFrameLayout(@NonNull Context context) {
        super(context);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println("jiangbin--> dispatchTouchEvent " + ev.toString());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        System.out.println("jiangbin--> onInterceptTouchEvent " + ev.toString());

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("jiangbin--> onTouchEvent " + event.toString());

        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        System.out.println("jiangbin--> " + MeasureSpec.toString(widthMeasureSpec) + " " + MeasureSpec.toString(heightMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        System.out.println("jiangbin--> after " + getMeasuredWidth() + "x" + getMeasuredHeight());

    }

    protected void measureChildWithMargins(View child,
                                           int parentWidthMeasureSpec, int widthUsed,
                                           int parentHeightMeasureSpec, int heightUsed) {
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        System.out.println("jiangbin-->child " + MeasureSpec.toString(childWidthMeasureSpec) + " " + MeasureSpec.toString(childHeightMeasureSpec));

        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }
}
