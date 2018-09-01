package com.peter.activitymanagertest.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.peter.activitymanagertest.Const;
import com.peter.activitymanagertest.R;
import com.peter.activitymanagertest.fragment.TestFragment;
import com.sankuai.waimai.router.annotation.RouterUri;

@RouterUri(path = Const.MY_FRAGMENT)
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
