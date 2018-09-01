package com.peter.activitymanagertest;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.peter.activitymanagertest.fragment.TestFragment;

public class MyFragmentActivity extends BaseActivity {
    static TestFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(fragment==null){
            fragment = (TestFragment) Fragment.instantiate(this,TestFragment.class.getName());
        }
        setContentView(R.layout.activity_my_fragment);
        System.out.println("jiangbin--> fragment "+fragment);
        getSupportFragmentManager().beginTransaction().add(R.id.root,fragment).commit();
    }
}
