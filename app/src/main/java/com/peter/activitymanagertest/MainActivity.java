package com.peter.activitymanagertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.peter.activitymanagertest.hook.ActivityHook;
import com.peter.activitymanagertest.hook.ActivityThreadHook;

public class MainActivity extends AppCompatActivity {
    public static MainActivity  sMainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sMainActivity = this;
        //Hook ActivityThread的mH的callback对象
        ActivityThreadHook hook = new ActivityThreadHook();
        hook.hookHandlerCallback();

        findViewById(R.id.second_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        ActivityHook.printActvity(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
