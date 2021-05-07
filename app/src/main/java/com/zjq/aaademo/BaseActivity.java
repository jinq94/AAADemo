package com.zjq.aaademo;

import android.app.Activity;
import android.view.View;

import com.zjq.aaademo.myview.MyTitleBar;
import com.zjq.aaademo.myview.SuccinctProgress;


/**
 * Created by 10048 on 2019/3/28.
 */

public class BaseActivity extends Activity {
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }
    public MyTitleBar titleBar;
    //________________________________
    //显示等待框
    public void showSuccinctProgressDefault() {
        SuccinctProgress.showSuccinctProgress(this, false, true);
    }

    //隐藏等待框
    public void unLoad() {
        if (SuccinctProgress.isShowing()) {
            SuccinctProgress.dismiss();
        }
    }
    //初始化标题栏
    public void initTitleBar(Activity activity, String title) {
//        初始化标题栏统一id命名
        titleBar = activity.findViewById(R.id.title_bar);
        titleBar.setTitle(title);
        titleBar.setOnBackClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClose();
            }
        });
        titleBar.setOnRightBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRigthBtn();
            }
        });
        titleBar.setOnRightImageClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRightImage();
            }
        });
    }

    //关闭事件
    protected void onClose() {
        onBackPressed();
    }

    //右边按钮点击
    protected void onRigthBtn() {
    }
    //右边图标点击
    protected void onRightImage() {
    }
}
