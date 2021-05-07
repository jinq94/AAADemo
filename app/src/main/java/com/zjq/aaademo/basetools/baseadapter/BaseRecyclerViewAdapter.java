package com.zjq.aaademo.basetools.baseadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dionew on 2018/3/12.
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<T> datas;
    private int layoutId;
    protected OnItemClickListner onItemClickListner;//单击事件
    protected OnItemLongClickListner onItemLongClickListner;//长按单击事件
    private boolean clickFlag = true;//单击事件和长单击事件的屏蔽标识
    public static final int TYPE_HEADER = 0;  //说明是带有Header的
    public static final int TYPE_NORMAL = 2;  //说明是不带有header和footer的
    //HeaderView, FooterView
    private View mHeaderView;


    //HeaderView和FooterView的get和set函数
    public View getHeaderView() {
        return mHeaderView;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }


    /**
     * 重写这个方法，很重要，是加入Header和Footer的关键，我们通过判断item的类型，从而绑定不同的view    *
     */
    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null) {
            return TYPE_NORMAL;
        }
        if (position == 0) {
            //第一个item应该加载Header
            return TYPE_HEADER;
        }
        return TYPE_NORMAL;
    }


    public BaseRecyclerViewAdapter(Context context, List<T> datas, int layoutId) {
        this.context = context;
        this.datas = datas;
        this.layoutId = layoutId;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == TYPE_HEADER) {
            return new BaseRecyclerViewHolder(mHeaderView);
        }

        BaseRecyclerViewHolder holder = new BaseRecyclerViewHolder(inflater.inflate(layoutId, parent, false));
        //水波纹动画设置
//        MaterialRippleLayout.on(holder.getView(R.id.ll_all))
//                .rippleOverlay(true)
//                .rippleAlpha(0.2f)
//                .rippleColor(context.getResources().getColor(R.color.colorAccent))
//                .rippleHover(true)
//                .create();
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
        if (getHeaderView() != null && position > 0) {
            bindData(holder, datas.get(position - 1), position);
        } else if (getHeaderView() != null && position == 0) {
            //有header时header不绑定id
        } else {
            bindData(holder, datas.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        if (datas != null) {
            if (mHeaderView == null) {
                return datas.size();
            } else {
                return datas.size() + 1;
            }
        }
        return 0;
    }

    protected abstract void bindData(BaseRecyclerViewHolder holder, T data, int position);

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public void setOnItemLongClickListner(OnItemLongClickListner onItemLongClickListner) {
        this.onItemLongClickListner = onItemLongClickListner;
    }

    public interface OnItemClickListner {
        void onItemClickListner(View v, int position);
    }

    public interface OnItemLongClickListner {
        void onItemLongClickListner(View v, int position);
    }


}
