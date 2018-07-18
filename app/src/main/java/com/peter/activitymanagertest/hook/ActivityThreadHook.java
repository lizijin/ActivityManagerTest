package com.peter.activitymanagertest.hook;

import android.os.Handler;
import android.os.Message;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * Created by jiangbin on 2018/7/16.
 */

public class ActivityThreadHook {


    private static Object sActivityThread;
    private Handler.Callback mCallback = new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            System.out.println("jiangbin--> msg.what " + ActivityThreadUtils.codeToString(msg.what));
            if (msg.obj != null) {
                System.out.println("jiangbin--> msg.obj " + msg.obj + " " + msg.obj.getClass().getName());
                if ("android.app.ActivityThread$ActivityClientRecord".equals(msg.obj.getClass().getName())) {
                    ActivityClientRecordHook.print(msg.obj);
                }
//            System.out.println("jiangbin--> token " + new ActivityClientRecordHook(msg.obj).token);
                if (msg.obj.getClass().getName().equals("android.app.ActivityThread$ContextCleanupInfo")) {
                    System.out.println("jiangbin-->" + new ContextCleanupInfoHook(msg.obj));
                }
            }
            System.out.println();

            return false;
        }
    };

    /**
     * 通过反射获取ActivityThread
     **/
    public static Object getActivityThread() {
        if (sActivityThread == null) {
            try {
                Class clzz = Class.forName("android.app.ActivityThread");
                Field field = clzz.getDeclaredField("sCurrentActivityThread");
                field.setAccessible(true);
                Object obj = field.get(null);
                System.out.println("jiangbin -> " + obj.getClass());
                System.out.println("jiangbin -> " + obj);
                sActivityThread = obj;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sActivityThread;
    }


    /**
     * hook掉ActivityThread的mH对象的Callback
     **/
    public void hookHandlerCallback() {
        try {
            Object object = getActivityThread();

            Field field = object.getClass().getDeclaredField("mH");
            field.setAccessible(true);
            Object mH = field.get(object);
            Field mCallbackField = mH.getClass().getSuperclass().getDeclaredField("mCallback");
            mCallbackField.setAccessible(true);

            System.out.println("jiangbin -> mH is" + mCallbackField);
            mCallbackField.set(mH, mCallback);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void hookApplicationThread() {
        try {
            Object activityThread = getActivityThread();
            Field mAppThreadField = activityThread.getClass().getDeclaredField("mAppThread");
            mAppThreadField.setAccessible(true);
            Object appThread = mAppThreadField.get(activityThread);
            ClassLoader bootClassLoader = appThread.getClass().getClassLoader();
            System.out.println("jiangbin proxyAppThread --> "+appThread);

            Class bootClazz =  bootClassLoader.loadClass("android.app.IApplicationThread");
            System.out.println("jiangbin proxyAppThread bootClazz "+bootClazz.getClassLoader());


            Class forname =  Class.forName("android.app.IApplicationThread");
            System.out.println("jiangbin proxyAppThread forname "+forname.getClassLoader());
            Class[] interfaces = new Class[]{bootClazz};

            System.out.println("jiangbin proxyAppThread --> l1 " +appThread.getClass().getClassLoader());
            ApplicationThreadInvocationHandler invocationHandler = new ApplicationThreadInvocationHandler(appThread);
            System.out.println("jiangbin proxyAppThread --> l2 " +  invocationHandler.getClass().getClassLoader()
            );

            Object proxyAppThread = Proxy.newProxyInstance(bootClassLoader, interfaces, invocationHandler);
            Class clazz = bootClassLoader.loadClass("android.app.IApplicationThread");
//            Class clazz = Class.forName("android.app.ActivityThread$ApplicationThread");
            System.out.println("jiangbin proxyAppThread -->" +proxyAppThread);
            Object castedProxyAppThread  = clazz.cast(proxyAppThread);
            System.out.println("jiangbin proxyAppThread -->"+castedProxyAppThread);

            //想通过动态代理来替换 结果发现不行
//            mAppThreadField.set(activityThread, castedProxyAppThread);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
