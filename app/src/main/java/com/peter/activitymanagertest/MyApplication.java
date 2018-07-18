package com.peter.activitymanagertest;

import android.app.Application;

import com.peter.activitymanagertest.hook.ActivityThreadHook;

/**
 * Created by jiangbin on 2018/7/18.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActivityThreadHook hook = new ActivityThreadHook();
        hook.hookHandlerCallback();
        hook.hookApplicationThread();
    }
}
