package com.peter.activitymanagertest.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.peter.activitymanagertest.Const;
import com.peter.activitymanagertest.LogUtils;
import com.peter.activitymanagertest.R;
import com.peter.activitymanagertest.hook.RecyclerViewHook;
import com.sankuai.waimai.router.annotation.RouterUri;

@RouterUri(path = Const.RECYCLER_VIEW_ACTIVITY)
public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private static RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mRecyclerView = findViewById(R.id.recycler_view);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,10));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        mRecyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false)) {
                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                if (position % 2 == 0) {
                    holder.itemView.setBackgroundColor(Color.RED);
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
                    layoutParams.width=100;
                    layoutParams.height=150;
                } else {
                    holder.itemView.setBackgroundColor(Color.BLUE);
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
                    layoutParams.width=150;
                    layoutParams.height=100;
                }
                ((TextView) holder.itemView.findViewById(R.id.text_view)).setText("Item " + holder);
            }

            @Override
            public int getItemCount() {
                return 100;
            }
        });
        mRecyclerView.setRecycledViewPool(recycledViewPool);

        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                String message = RecyclerViewHook.getMessage(mRecyclerView);
                LogUtils.e(RecyclerViewActivity.class, message);
                return true;
            }
        });
    }
}
