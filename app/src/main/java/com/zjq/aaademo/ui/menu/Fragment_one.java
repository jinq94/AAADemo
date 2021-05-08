package com.zjq.aaademo.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zjq.aaademo.BaseActivity;
import com.zjq.aaademo.R;
import com.zjq.aaademo.adapter.menuAdapter;
import com.zjq.aaademo.application.MyApplication;

import java.util.ArrayList;
import java.util.List;

public class Fragment_one extends BaseFragment {
    private View view;
    private ListView listfrag;
    private SwipeRefreshLayout layoutFresh;
private String packageName="com.zjq.aaademo.ui.";

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
        listfrag = view.findViewById(R.id.list_frag);
        setFresh();
        setList();

    }

    private void setList() {
        final List<String> menuList = new ArrayList<>();
        menuList.add("LoginActivity");
        menuList.add("ListViewActivity");
        menuList.add("RecyclerViewActivity");
        menuList.add("WebView");
        listfrag.setAdapter(new menuAdapter(menuList));
        listfrag.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyApplication.showToast(menuList.get(position));

                try {
                    BaseActivity activity = (BaseActivity) Class.forName(packageName+menuList.get(position)).newInstance();
                    startActivity(new Intent(getActivity(), activity.getClass()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setFresh() {
        layoutFresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                layoutFresh.setRefreshing(false);
            }
        });
    }
}