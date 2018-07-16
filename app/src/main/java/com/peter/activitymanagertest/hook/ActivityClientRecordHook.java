package com.peter.activitymanagertest.hook;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by jiangbin on 2018/7/16.
 */

public class ActivityClientRecordHook {
    IBinder token;
    int ident;
    Intent intent;
    String referrer;
    Bundle state;
    PersistableBundle persistentState;
    Activity activity;
    Window window;
    Activity parent;
    String embeddedID;
    boolean paused;
    boolean stopped;
    boolean hideForNow;
    Configuration newConfig;
    Configuration createdConfig;
    Configuration overrideConfig;
    boolean startsNotResumed;
//    ActivityClientRecord nextIdle;
//
//    ProfilerInfo profilerInfo;
//
//    ActivityInfo activityInfo;
//    CompatibilityInfo compatInfo;
//    LoadedApk packageInfo;
//
//    List<ResultInfo> pendingResults;
//    List<ReferrerIntent> pendingIntents;
    boolean isForward;
    int pendingConfigChanges;
    boolean onlyLocalRequest;
    Window mPendingRemoveWindow;
    WindowManager mPendingRemoveWindowManager;
    boolean mPreserveWindow;
    // Set for relaunch requests, indicates the order number of the relaunch operation, so it
    // can be compared with other lifecycle operations.
    int relaunchSeq = 0;
    // Can only be accessed from the UI thread. This represents the latest processed message
    // that is related to lifecycle events/
    int lastProcessedSeq = 0;
    Object activityClientRecord;
    // Used for consolidating configs before sending on to Activity.
    private Configuration tmpConfig = new Configuration();

    public ActivityClientRecordHook(Object object) {
        activityClientRecord = object;
        init();
    }

    private void init() {
        Class activityClientRecordClzz = activityClientRecord.getClass();
        try {
            System.out.println("jiangbin--> the class "+activityClientRecordClzz);
            Field tokenField = activityClientRecordClzz.getDeclaredField("token");
            tokenField.setAccessible(true);
            token = (IBinder) tokenField.get(activityClientRecord);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
