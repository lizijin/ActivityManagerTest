package com.peter.activitymanagertest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.peter.activitymanagertest.hook.ViewHook;

public class MainActivity extends BaseActivity {
    public static MainActivity  sMainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        sMainActivity = this;
        //Hook ActivityThread的mH的callback对象

        final View secondActivity = findViewById(R.id.second_activity);
        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHook.printViewRootImpl(getWindow().getDecorView());
                ViewHook.printViewRootImpl(secondActivity);


//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                startActivity(intent);
            }
        });
        findViewById(R.id.main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.frame_layout_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FrameLayoutActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
//        ActivityHook.printActvity(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
