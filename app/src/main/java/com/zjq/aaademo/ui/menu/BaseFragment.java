package com.zjq.aaademo.ui.menu;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;

import com.zjq.aaademo.myview.SuccinctProgress;


/**
 * Created by dionew on 2017/12/26.
 */

public class BaseFragment extends Fragment {
    private Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    //显示等待框
    public void showSuccinctProgressDefault() {
        SuccinctProgress.showSuccinctProgress(activity, false, true);
    }

    //隐藏等待框
    public void unLoad() {
        if (SuccinctProgress.isShowing()) {
            SuccinctProgress.dismiss();
        }
    }

    //隐藏等待框
    public void unLoadDelay() {
        //延时1秒关闭
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (SuccinctProgress.isShowing()) {
                    SuccinctProgress.dismiss();
                }
            }
        }, 1000);

    }
}
