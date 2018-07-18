package com.peter.activitymanagertest.hook;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理hook掉ActivityThread的ApplicationThread
 * Created by jiangbin on 2018/7/18.
 */

public class ApplicationThreadInvocationHandler implements InvocationHandler {
    private Object applicationThread;
    public ApplicationThreadInvocationHandler(Object applicationThread){
        this.applicationThread = applicationThread;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jiangbin-->proxy "+method);
        method.invoke(applicationThread,args);
        return null;
    }
}
