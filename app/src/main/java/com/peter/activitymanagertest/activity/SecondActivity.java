package com.peter.activitymanagertest.activity;

import android.os.Bundle;

import com.peter.activitymanagertest.Const;
import com.peter.activitymanagertest.R;
import com.sankuai.waimai.router.annotation.RouterUri;

@RouterUri(scheme = "jb",host = "peter" ,path = Const.SECOND)
public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        finish();
    }
}
