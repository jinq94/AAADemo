package com.zjq.aaademo.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zjq.aaademo.BaseActivity;
import com.zjq.aaademo.R;
import com.zjq.aaademo.adapter.RecyclerAdapterOne;
import com.zjq.aaademo.application.MyApplication;
import com.zjq.aaademo.basetools.baseadapter.BaseRecyclerViewAdapter;
import com.zjq.aaademo.basetools.itemanimator.SlideInOutRightItemAnimator;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_recycler_view)
public class RecyclerViewActivity extends BaseActivity {
    @ViewInject(R.id.recycler_view)
    private RecyclerView recyclerView;
    private RecyclerAdapterOne adapterOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initTitleBar(this, "RecyclerView");
        setRecycler();
    }

    private void setRecycler() {
        final List<String> listData = new ArrayList<>();
        for (int i = 0; i < 29; i++) {
            listData.add("item" + i);
        }

        recyclerView.setItemAnimator(new SlideInOutRightItemAnimator(recyclerView));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapterOne = new RecyclerAdapterOne(this, listData, R.layout.item_menu);
        recyclerView.setAdapter(adapterOne);
        adapterOne.setOnItemClickListner(new BaseRecyclerViewAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                MyApplication.showToast(String.valueOf(position));
                listData.remove(position);
                adapterOne.freshAdapter();
            }
        });

    }


}
