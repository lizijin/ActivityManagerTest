package com.peter.activitymanagertest.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.peter.activitymanagertest.Const;
import com.peter.activitymanagertest.R;
import com.sankuai.waimai.router.Router;

/**
 * Created by jiangbin on 2018/9/1.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.TextViewHolder> {
    private final String[] schemes;

    public MainAdapter() {
        schemes = Const.PATHS;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TextViewHolder holder, final int position) {
        holder.mTextView.setText(schemes[position]);
        final  String uri = schemes[position];
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.startUri(v.getContext(),uri);
            }
        });
        holder.mTextView.post(new Runnable() {
            @Override
            public void run() {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) holder.mTextView.getLayoutParams();
                layoutParams.height = holder.mTextView.getMeasuredWidth();
                layoutParams.width = holder.mTextView.getMeasuredWidth();
                holder.mTextView.setLayoutParams(layoutParams);
            }
        });


    }

    @Override
    public int getItemCount() {
        return schemes.length;
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public TextViewHolder(View itemView) {
            super(itemView);
            itemView.setPadding(10,10,10,10);
            mTextView = itemView.findViewById(R.id.text_view);
        }
    }
}
