package com.peter.activitymanagertest.activity;

import android.app.Application;

import com.peter.activitymanagertest.hook.ActivityThreadHook;
import com.sankuai.waimai.router.Router;
import com.sankuai.waimai.router.common.DefaultRootUriHandler;

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

        // 创建RootHandler
        DefaultRootUriHandler rootHandler = new DefaultRootUriHandler(this);

        // 初始化
        Router.init(rootHandler);
    }
}
