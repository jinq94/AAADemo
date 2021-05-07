package com.zjq.aaademo.basetools.baseadapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by wangjitao on 2016/11/7 0007.
 * 万能的Viewholder
 */
public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views;

    public BaseRecyclerViewHolder(View view) {
        super(view);
        this.views = new SparseArray<>();
    }

    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public View getRootView() {
        return itemView;
    }
}