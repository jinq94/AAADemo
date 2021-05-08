package com.zjq.aaademo.adapter;

import android.content.Context;
import android.widget.TextView;

import com.zjq.aaademo.R;
import com.zjq.aaademo.basetools.baseadapter.BaseListViewAdapter;
import com.zjq.aaademo.basetools.baseadapter.BaseListViewHolder;

import java.util.List;

/**
 * Created  in 2021/5/8.
 */

public class menuAdapter extends BaseListViewAdapter<String> {

    public menuAdapter(List<String> datas) {
        super(datas);
    }

    @Override
    protected void setUI(BaseListViewHolder holder, int position, Context context) {
        TextView tvname = holder.getItemView(R.id.item_tv_menu);
        tvname.setText(getItem(position));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_menu;
    }
}
