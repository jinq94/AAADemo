package com.zjq.aaademo.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;

import com.zjq.aaademo.basetools.MyToast;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zjq on 2017/3/16.
 */
public class MyApplication extends Application {
//    个推账号：kytx
//    个推密码：kytx123456@

    private static Context context;
    private static Context applicationContext;
    private static MyApplication instance;
    private static String showMessage = "";
    private List<Activity> oList;
//    public static Typeface texttypeface=null;
    static Handler handlerui = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                MyToast.showToast(getContext(), showMessage);
            }
        }
    };


    @Override
    public void onCreate() {
        super.onCreate();
        oList = new ArrayList<Activity>();
        applicationContext = this;
        instance = this;
        context = getApplicationContext();//获取当前activity的context
        x.Ext.init(this);
        x.Ext.setDebug(true); //是否输出debug日志，开启debug会影响性能。
    }

    //获取context对象
    public static Context getContext() {//提供一个Context方法
        return context;
    }

    /**
     * 保存token
     *
     * @param token
     */
    public static void setToken(String token) {
        SharedPreferences sp1 = MyApplication.getContext().getSharedPreferences("user",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp1.edit();
        editor.putString("token", token);
        editor.commit();
    }
    public static String getToken() {
        SharedPreferences sp1 = MyApplication.getContext().getSharedPreferences("user",
                Activity.MODE_PRIVATE);
        String token = sp1.getString("token", "");
        return token;
    }

    public static void showToast(String showMess) {
        showMessage = showMess;
        handlerui.sendEmptyMessage(0);
    }


}
