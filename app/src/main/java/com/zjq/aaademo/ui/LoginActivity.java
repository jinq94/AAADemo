package com.zjq.aaademo.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.zjq.aaademo.BaseActivity;
import com.zjq.aaademo.R;
import com.zjq.aaademo.basetools.Println__;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity {
    @ViewInject(R.id.tvmessage)
    private TextView tvmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initTitleBar(this, "登录");
        getRequest();
    }

    private void getRequest() {
        String url = "https://biaozhunshijian.bmcx.com/";
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {
                new Println__("缓存");
                tvmessage.setText(result);
                return true;
            }

            @Override
            public void onSuccess(String result) {
                if (result!=null){
                    new Println__("新数据");
                    tvmessage.setText(result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
