package com.peter.activitymanagertest;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.peter.activitymanagertest.hook.DialogHook;
import com.peter.activitymanagertest.view.LifeCycleView;

public class MainActivity extends BaseActivity {
    public static MainActivity sMainActivity;
    private ViewGroup mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        sMainActivity = this;
        mRoot = findViewById(R.id.root);
        //Hook ActivityThread的mH的callback对象

//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

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
        Button button = findViewById(R.id.main_activity);
        System.out.println("jiangbin--> main_Activity "+button);
        findViewById(R.id.frame_layout_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyFragmentActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.animation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                public TranslateAnimation(int fromXType, float fromXValue, int toXType, float toXValue,
//                int fromYType, float fromYValue, int toYType, float toYValue) {
               TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,100,Animation.RELATIVE_TO_SELF,50,Animation.RELATIVE_TO_SELF,100,Animation.RELATIVE_TO_SELF,50);
               translateAnimation.setDuration(4000);
                findViewById(R.id.animation).startAnimation(translateAnimation);
               getWindow().getDecorView().startAnimation(translateAnimation);
               getWindow().getDecorView().setTranslationX(100);
                getWindow().getDecorView().setTranslationY(100);
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


        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation animation = new TranslateAnimation(0,500,0,500);
                animation.setDuration(5000);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        System.out.println("jiangbin-->animation start");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        System.out.println("jiangbin-->animation end");

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
//                lifeCycleView.startAnimation(animation);
                lifeCycleView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        ( (ViewGroup)lifeCycleView.getParent()).removeView(lifeCycleView);
                        mRoot.removeView(lifeCycleView);
                        System.out.println("jiangbin--> animation remove");
                    }
                },2000);
            }
        });

        findViewById(R.id.coordinator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TestCoordinatorLayout.class);
                startActivity(intent);
            }
        });
        //测试
//        final Handler mHandler = new Handler();
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                while(true){
////                    try {
////                        Thread.sleep(10);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
//                    mHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            lifeCycleView.invalidate();
//                        }
//                    });
//                }
//            }
//        }.start();
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
