package com.peter.activitymanagertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jiangbin on 2018/7/16.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("jiangbin-->" + getClass().getName() + " onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("jiangbin-->" + getClass().getName() + " onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("jiangbin-->" + getClass().getName() + " onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("jiangbin-->" + getClass().getName() + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("jiangbin-->" + getClass().getName() + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("jiangbin-->" + getClass().getName() + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("jiangbin-->" + getClass().getName() + " onDestroy");
    }
}
