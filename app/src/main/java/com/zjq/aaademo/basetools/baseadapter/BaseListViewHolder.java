package com.zjq.aaademo.basetools.baseadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;

public class BaseListViewHolder {
    /**
     * 保存所有itemview的集合
     */
    private SparseArray<View> mViews;

    private View mConvertView;

    private BaseListViewHolder(Context context, int layoutId) {
        mConvertView = View.inflate(context, layoutId, null);
        mConvertView.setTag(this);

        mViews = new SparseArray<>();
    }

    public static BaseListViewHolder newsInstance(View convertView, Context context, int layoutId) {
        if (convertView == null)
        {
            return new BaseListViewHolder(context, layoutId);

        } else
        {
            return (BaseListViewHolder) convertView.getTag();
        }
    }

    /**
     * 获取根view
     * @author 漆可
     * @date 2016-6-28 下午3:29:21
     * @return
     */
    public View getConverView()
    {
        return mConvertView;
    }

    /**
     * 获取节点view
     * @author 漆可
     * @date 2016-6-28 下午4:24:26
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getItemView(int id) {
        View view =  mViews.get(id);
        if (view == null)
        {
            view = mConvertView.findViewById(id);
            mViews.append(id, view);
        }

        return (T) view;
    }

}