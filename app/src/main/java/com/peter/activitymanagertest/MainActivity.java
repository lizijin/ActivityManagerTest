package com.peter.activitymanagertest;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.peter.activitymanagertest.hook.DialogHook;
import com.peter.activitymanagertest.view.LifeCycleView;

public class MainActivity extends BaseActivity {
    public static MainActivity sMainActivity;

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
//                ViewHook.printViewRootImpl(getWindow().getDecorView());
//                ViewHook.printViewRootImpl(secondActivity);


                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.frame_layout_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.frame_show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("hello");
//               TextView textView =  new TextView(MainActivity.this);
//               textView.setText("hello");
//               dialog.setContentView(textView);
                dialog.setContentView(LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null));
                dialog.show();
                DialogHook.printDialogWindowManager(dialog);
                DialogHook.printDialogPhoneWindow(dialog);

            }
        });
        final LifeCycleView lifeCycleView = findViewById(R.id.life_view);
        lifeCycleView.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                if (count % 2 == 0) {
                    lifeCycleView.requestLayout();
                    System.out.println("jiangbin--> requestLayout");
                } else {
                    lifeCycleView.invalidate();
                    System.out.println("jiangbin--> invalidate");

                }
                count++;
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
