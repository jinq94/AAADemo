package com.zjq.aaademo.basetools.baseadapter;

import android.view.View;

/**
 * Created by wangjitao on 2016/11/7 0007.
 * 万能的Viewholder
 */
public class BaseRecyclerViewHolderHeader extends BaseRecyclerViewHolder {


    public BaseRecyclerViewHolderHeader(View view) {
        super(view);

    }

    public <T extends View> T getView(int viewId) {
        return null;
    }

    public View getRootView() {
        return null;
    }
}