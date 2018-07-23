package com.peter.activitymanagertest.hook;

import android.app.Activity;
import android.graphics.Color;
import android.view.Window;

import java.lang.reflect.Field;

/**
 * Created by jiangbin on 2018/7/18.
 */

public class ActivityHook {
    public static void printActvity(Activity activity) {
        try {
            System.out.println("jiangbin activityHook--> " + activity.getClass().getName() );

            Field startedActivityField = Activity.class.getDeclaredField("mStartedActivity");
            startedActivityField.setAccessible(true);
            boolean mStartedActivity = (boolean) startedActivityField.get(activity);
            System.out.println("jiangbin--> " + activity.getClass().getName() + " " + mStartedActivity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printActivityWindowManager(Activity activity){
        try {
            Field windowManagerField =  Activity.class.getDeclaredField("mWindowManager");
            windowManagerField.setAccessible(true);
            System.out.println("jiangbin--> the windows"+windowManagerField.get(activity));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void printActivityWindow(Activity activity) {
        try {

            Field mWindowField =  Activity.class.getDeclaredField("mWindow");
            mWindowField.setAccessible(true);
            Window mWindow = (Window) mWindowField.get(activity);
            System.out.println("jiangbin--> window attr activity " + mWindow.getAttributes());
            mWindow.getDecorView().setBackgroundColor(Color.RED);
            System.out.println("jiangbin--> window in Dialog "+mWindow);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
