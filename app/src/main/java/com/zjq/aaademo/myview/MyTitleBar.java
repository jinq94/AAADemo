package com.zjq.aaademo.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zjq.aaademo.R;


public class MyTitleBar extends LinearLayout {
    private LinearLayout layoutRoot;
    private TextView tvTitle;
    private ImageView imageReturn;
    private ImageView imageRight;
    private Button btnRight;
    private View line;


    public MyTitleBar(Context context) {
        super(context);
        init();
    }

    public MyTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        parseAttributes(context.obtainStyledAttributes(attrs, R.styleable.MyTitleBar));

    }


    private void parseAttributes(TypedArray a) {
        // 字体颜色大小

        Drawable back_root = a.getDrawable(R.styleable.MyTitleBar_background_root);
        Drawable image_right = a.getDrawable(R.styleable.MyTitleBar_image_right);
        Drawable image_left = a.getDrawable(R.styleable.MyTitleBar_image_left);
        String string_title = a.getString(R.styleable.MyTitleBar_text_title);
        String string_btn_right = a.getString(R.styleable.MyTitleBar_text_right_btn);
        boolean show_button_right = a.getBoolean(R.styleable.MyTitleBar_visibility_right_btn, false);
        boolean show_image_right = a.getBoolean(R.styleable.MyTitleBar_visibility_right_image, false);
        a.recycle();


        //左边按钮图标
        imageReturn.setImageDrawable(image_left);
        //布局底色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            layoutRoot.setBackground(back_root);
        }

        //标题文字
        if (string_title != null && string_title.length() > 0) tvTitle.setText(string_title);
        btnRight.setVisibility(show_button_right ? VISIBLE : GONE);
        //右边button文字
        btnRight.setText(string_btn_right);
        //右边button背景
        imageRight.setVisibility(show_image_right ? VISIBLE : GONE);
        //右边按钮图标
        imageRight.setImageDrawable(image_right);

    }

    /**
     * 添加布局文件
     */
    private void init() {
        //添加布局文件的操作
        //给转化的view对象，找个父控件，先转化成view对象，在添加到布局文件中
        View view = View.inflate(getContext(), R.layout.view_mytitlebar, this);
        //初始化控件
        layoutRoot = view.findViewById(R.id.titilbar_root);
        tvTitle = view.findViewById(R.id.tv_titil);
        imageReturn = view.findViewById(R.id.image_return);
        imageRight = view.findViewById(R.id.image_right);
        line = view.findViewById(R.id.shu_line);
        btnRight = view.findViewById(R.id.btn_right);
    }

    //设置标题
    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    //隐藏竖线
    public void hideLine() {
        imageReturn.setVisibility(GONE);
        line.setVisibility(INVISIBLE);
    }
    //隐藏竖线
    public void setRightBtnText(String text) {
      btnRight.setText(text);
        btnRight.setTextSize(10);
        btnRight.setVisibility(VISIBLE);
    }
    //返回监听
    public void setOnBackClickListener(OnClickListener listener) {
        imageReturn.setOnClickListener(listener);
    }

    //右边图标监听
    public void setOnRightImageClickListener(OnClickListener listener) {
        imageRight.setOnClickListener(listener);
    }

    //右边文字监听
    public void setOnRightBtnClickListener(OnClickListener listener) {
        btnRight.setOnClickListener(listener);
    }

}

