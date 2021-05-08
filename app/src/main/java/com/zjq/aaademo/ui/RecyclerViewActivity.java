package com.zjq.aaademo.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zjq.aaademo.BaseActivity;
import com.zjq.aaademo.R;
import com.zjq.aaademo.adapter.RecyclerAdapterOne;
import com.zjq.aaademo.application.MyApplication;
import com.zjq.aaademo.basetools.baseadapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends BaseActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initTitleBar(this, "RecyclerView");
        recyclerView = findViewById(R.id.recycler_view);
        setRecycler();
    }

    private void setRecycler() {
        List<String> listData = new ArrayList<>();
        for (int i = 0; i < 29; i++) {
            listData.add("item" + i);
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerAdapterOne adapterOne= new RecyclerAdapterOne(this, listData, R.layout.item_menu);
        recyclerView.setAdapter(adapterOne);
        //    在activity内监听点击项
        adapterOne.setOnItemClickListner(new BaseRecyclerViewAdapter.OnItemClickListner() {
        @Override
        public void onItemClickListner(View v, int position) {
            MyApplication.setToken(String.valueOf(v.getId()));
        }
    });
    }


}
