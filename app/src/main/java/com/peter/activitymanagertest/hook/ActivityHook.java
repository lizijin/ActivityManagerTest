package com.peter.activitymanagertest.hook;

import android.app.Activity;

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
}
