package com.zjq.aaademo.basetools.baseadapter;

import android.content.Context;

import java.util.List;

/**
 * Created by 10048 on 2018/4/13.
 */

public class RecyclerAdapterDemo extends BaseRecyclerViewAdapter<String> {
    public RecyclerAdapterDemo(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
    }



    //防止fragment内刷新不起作用
    public void freshAdapter() {
        notifyDataSetChanged();
    }

    @Override
    protected void bindData(final BaseRecyclerViewHolder holder, String data, final int position) {

//        TextView tv = holder.getView(R.id.item_tv_message);
//        LinearLayout layout = holder.getView(R.id.item_layout_root);
//        tv.setText(data);
//        layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (onItemClickListner != null) {
//                    onItemClickListner.onItemClickListner(holder.getRootView(), position);
//                }
//            }
//        });
    }
}

//    在activity内监听点击项
//    adapter.setOnItemClickListner(new BaseRecyclerViewAdapter.OnItemClickListner() {
//        @Override
//        public void onItemClickListner(View v, int position) {
//            //   activity.ShowFragment(position);
//        }
//    });