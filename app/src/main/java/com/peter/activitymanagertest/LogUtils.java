package com.peter.activitymanagertest;

import android.util.Log;

/**
 * Created by jiangbin on 2018/9/1.
 */

public class LogUtils {
    public static final String TAG = "jbgod";
    public static final int DEBUG = 0;
    public static final int ERROR = 1;
    public static final int LEVEL = ERROR;


    public static void d(Class clazz, String message) {
        if (LEVEL <= DEBUG)
            Log.d(TAG, "jiangbin --> " + clazz.getSimpleName() + " " + message);
    }

    public static void e(Class clazz, String message) {
        if (LEVEL <= ERROR) {
            Log.e(TAG, "jiangbin --> " + clazz.getSimpleName() + " " + message);
        }
    }
}