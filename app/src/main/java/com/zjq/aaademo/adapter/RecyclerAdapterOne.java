package com.zjq.aaademo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zjq.aaademo.R;
import com.zjq.aaademo.basetools.baseadapter.BaseRecyclerViewAdapter;
import com.zjq.aaademo.basetools.baseadapter.BaseRecyclerViewHolder;

import java.util.List;

/**
 * Created by 10048 on 2018/4/13.
 */

public class RecyclerAdapterOne extends BaseRecyclerViewAdapter<String> {
    private  Context context;
    public RecyclerAdapterOne(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
        this.context=context;
    }

    @Override
    protected void bindData(final BaseRecyclerViewHolder holder, String data, final int position) {
        TextView tv = holder.getView(R.id.item_tv_menu);
        ImageView imageView=holder.getView(R.id.img_card);
        LinearLayout layout=holder.getView(R.id.item_layout1);
        tv.setText(data);
        Glide.with(this.context).load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fs13.sinaimg.cn%2Fbmiddle%2F4d049168cc5e11e7fb13c&refer=http%3A%2F%2Fs13.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1623400248&t=a4887153dab936552d327072c9de49bf").into(imageView);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListner != null) {
                    onItemClickListner.onItemClickListner(holder.getRootView(), position);
                }
            }
        });
    }


    //防止fragment内刷新不起作用
    public void freshAdapter() {
        notifyDataSetChanged();
    }



}
