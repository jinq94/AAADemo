package com.zjq.aaademo.adapter;

import android.content.Context;
import android.widget.TextView;

import com.zjq.aaademo.R;
import com.zjq.aaademo.basetools.baseadapter.BaseRecyclerViewAdapter;
import com.zjq.aaademo.basetools.baseadapter.BaseRecyclerViewHolder;

import java.util.List;

/**
 * Created by 10048 on 2018/4/13.
 */

public class RecyclerAdapterOne extends BaseRecyclerViewAdapter<String> {
    public RecyclerAdapterOne(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
    }



    //防止fragment内刷新不起作用
    public void freshAdapter() {
        notifyDataSetChanged();
    }

    @Override
    protected void bindData(final BaseRecyclerViewHolder holder, String data, final int position) {
        TextView tv = holder.getView(R.id.item_tv_menu);
        tv.setText(data);
    }
}
