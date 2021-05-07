package com.zjq.aaademo.basetools.baseadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by 10048 on 2018/4/13.
 */

public abstract class BaseListViewAdapter<T> extends BaseAdapter {
    private List<T> mDatas;

    public BaseListViewAdapter(List<T> datas) {
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseListViewHolder holder = BaseListViewHolder
                .newsInstance(convertView, parent.getContext(), getLayoutId());

        setUI(holder, position, parent.getContext());

        return holder.getConverView();
    }

    protected abstract void setUI(BaseListViewHolder holder, int position, Context context);

    protected abstract int getLayoutId();


}
