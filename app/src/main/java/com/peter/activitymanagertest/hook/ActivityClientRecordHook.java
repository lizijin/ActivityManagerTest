package com.peter.activitymanagertest.hook;

import java.lang.reflect.Method;

/**
 * Created by jiangbin on 2018/7/16.
 */

public class ActivityClientRecordHook {
    public static void print(Object object){
        try {
            Method getStateStringMethod = object.getClass().getDeclaredMethod("getStateString");
            getStateStringMethod.setAccessible(true);
           String stateString = (String) getStateStringMethod.invoke(object);
            System.out.println("jiangbin-->stateString"+stateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
