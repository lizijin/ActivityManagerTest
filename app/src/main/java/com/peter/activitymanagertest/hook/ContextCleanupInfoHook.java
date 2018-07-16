package com.peter.activitymanagertest.hook;

import java.lang.reflect.Field;

/**
 * Created by jiangbin on 2018/7/16.
 */

public class ContextCleanupInfoHook {
    Object contextImpl;
    String what;
    String who;
    public ContextCleanupInfoHook(Object contextCleanupInfo){
        try {
            Class clazz = contextCleanupInfo.getClass();
            Field contextImplField = clazz.getDeclaredField("context");
            contextImplField.setAccessible(true);
            contextImpl = contextImplField.get(contextCleanupInfo);

            Field whatField = clazz.getDeclaredField("what");
            whatField.setAccessible(true);
            what = (String) whatField.get(contextCleanupInfo);

            Field whoField = clazz.getDeclaredField("who");
            whoField.setAccessible(true);
            who = (String) whoField.get(contextCleanupInfo);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ContextCleanupInfoHook{" +
                "contextImpl=" + contextImpl +
                ", what='" + what + '\'' +
                ", who='" + who + '\'' +
                '}';
    }
}
