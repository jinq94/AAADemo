package com.zjq.aaademo.ui;

import android.os.Bundle;

import com.zjq.aaademo.BaseActivity;
import com.zjq.aaademo.R;

public class ListViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initTitleBar(this,"ListView");
    }
}
