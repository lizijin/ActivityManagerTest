package com.peter.activitymanagertest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.peter.activitymanagertest.Const;
import com.peter.activitymanagertest.R;
import com.sankuai.waimai.router.annotation.RouterUri;

@RouterUri(path = Const.FRAME_LAYOUT)
public class FrameLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_frame_layout);

    }

}
