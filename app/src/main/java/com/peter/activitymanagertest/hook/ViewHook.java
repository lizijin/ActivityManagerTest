package com.peter.activitymanagertest.hook;

import android.view.View;

import java.lang.reflect.Method;

/**
 * Created by jiangbin on 2018/7/22.
 */

public class ViewHook {
    public static void printViewRootImpl(View view) {
        try {
            Method method = View.class.getDeclaredMethod("getViewRootImpl");
            method.setAccessible(true);
            System.out.println("jiangbin--> the ViewRootImpl is " + view + " " + method.invoke(view));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
