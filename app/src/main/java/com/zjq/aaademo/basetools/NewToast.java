package com.zjq.aaademo.basetools;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kunyang.cloudmerchant.R;
import com.kunyang.cloudmerchant.tools.UnitTool;


public class NewToast {
    private Toast mToast;
    private TextView textView;

    private NewToast(Context context, CharSequence text, int duration) {
        View v = LayoutInflater.from(context).inflate(R.layout.eplay_toast, null);
        textView = v.findViewById(R.id.textView1);
        textView.setText(text);
        mToast = new Toast(context);
        mToast.setDuration(duration);
        mToast.setGravity(Gravity.BOTTOM, 0, UnitTool.dip2px(120));
        mToast.setView(v);
    }

    public static NewToast makeText(Context context, CharSequence text, int duration) {
        return new NewToast(context, text, duration);
    }

    public void show() {
        if (mToast != null) {
            mToast.show();
        }
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        if (mToast != null) {
            mToast.setGravity(gravity, xOffset, yOffset);
        }
    }

    public void setText(String text) {
        textView.setText(text);
    }
}
