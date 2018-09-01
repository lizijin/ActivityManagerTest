package com.peter.activitymanagertest.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jiangbin on 2018/7/31.
 */

public class TestFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        System.out.println("jiangbin--> fragment onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        System.out.println("jiangbin--> fragment onCreate");

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("jiangbin--> fragment onCreateView");

         super.onCreateView(inflater, container, savedInstanceState);
        TextView textView = new TextView(getActivity());
        textView.setText("hello");
         return textView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        System.out.println("jiangbin--> fragment onViewCreated");

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        System.out.println("jiangbin--> fragment onActivityCreated");

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        System.out.println("jiangbin--> fragment onStart");

        super.onStart();
    }

    @Override
    public void onResume() {
        System.out.println("jiangbin--> fragment onResume");

        super.onResume();
    }

    @Override
    public void onPause() {
        System.out.println("jiangbin--> fragment onPause");

        super.onPause();
    }

    @Override
    public void onStop() {
        System.out.println("jiangbin--> fragment onStop");

        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("jiangbin--> fragment onDestroyView "+getView());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("jiangbin--> fragment onDestroy "+getView());

    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("jiangbin--> fragment onDetach "+getView());

    }
}
