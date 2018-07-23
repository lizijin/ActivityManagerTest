package com.peter.activitymanagertest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.peter.activitymanagertest.hook.ActivityHook;

/**
 * Created by jiangbin on 2018/7/16.
 */

public class BaseActivity extends AppCompatActivity {
    public static  final String TAG_LIFE_RECYCLE = "jiangbin_life_recycle->";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(TAG_LIFE_RECYCLE + getClass().getName() + " onCreate");
        System.out.println("jiangbin--> the window "+getSystemService(Context.WINDOW_SERVICE));
        ActivityHook.printActivityWindowManager(this);
        ActivityHook.printActivityWindow(this);
    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        System.out.println(TAG_LIFE_RECYCLE + getClass().getName() + " onRestoreInstanceState");
//
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println(TAG_LIFE_RECYCLE + getClass().getName() + " onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println(TAG_LIFE_RECYCLE + getClass().getName() + " onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println(TAG_LIFE_RECYCLE + getClass().getName() + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println(TAG_LIFE_RECYCLE + getClass().getName() + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println(TAG_LIFE_RECYCLE + getClass().getName() + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println(TAG_LIFE_RECYCLE + getClass().getName() + " onDestroy");
    }
}
