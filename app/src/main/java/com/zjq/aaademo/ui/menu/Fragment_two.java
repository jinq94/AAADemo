package com.zjq.aaademo.ui.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.zjq.aaademo.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.fragment_web)
public class Fragment_two extends BaseFragment {
    @ViewInject(R.id.web_frag)
    private WebView webView;
    @ViewInject(R.id.swipfresh)
    private SwipeRefreshLayout layoutFresh;
    @ViewInject(R.id.titil)
    private TextView tvtitle;
    private String Url = "https://www.zhihu.com/";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        webView.loadUrl(Url);
        setWebview(webView);
        setFresh();
        tvtitle.setText("分类");
    }


    private void setWebview(WebView webview) {
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

    private void setFresh() {
        layoutFresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
                layoutFresh.setRefreshing(false);
            }
        });
    }
}