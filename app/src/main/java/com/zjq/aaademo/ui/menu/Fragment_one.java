package com.zjq.aaademo.ui.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zjq.aaademo.R;

public class Fragment_one extends BaseFragment {
    private View view;
    private ListView listfrag;
    private SwipeRefreshLayout layoutFresh;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layoutFresh = view.findViewById(R.id.swipfresh);
        setFresh(layoutFresh);
    }

    private void setFresh(SwipeRefreshLayout lyFresh) {
        lyFresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }
}