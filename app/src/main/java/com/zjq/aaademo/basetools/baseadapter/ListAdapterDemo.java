package com.zjq.aaademo.basetools.baseadapter;

import android.content.Context;

import java.util.List;

/**
 * Created by 10048 on 2018/4/13.
 */

//使用的时候只需要继承BaseCommAdapter<T>，泛型中传入数据类型，重写setUI、getLayoutId俩个方法就可
public class ListAdapterDemo extends BaseListViewAdapter<String> {
    public ListAdapterDemo(List<String> datas) {
        super(datas);
    }

    @Override
    protected void setUI(BaseListViewHolder holder, int position, Context context) {
//        TextView tvname = holder.getItemView(R.id.shu_line);
//        tvname.setText(getItem(position));
    }
    

    @Override
    protected int getLayoutId() {
        return 0;
//        return R.layout.layout_basic_click_view;
    }
}
