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

public class Fragment_two extends BaseFragment {
    private View view;
    private WebView webView;
    private SwipeRefreshLayout layoutFresh;
    private String Url = "https://www.zhihu.com/";
    private TextView tvtitle;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_web, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvtitle = view.findViewById(R.id.titil);
        webView = view.findViewById(R.id.web_frag);
        layoutFresh = view.findViewById(R.id.swipfresh);
        webView.loadUrl(Url);
        setWebview(webView);
        setFresh();
        tvtitle.setText("我的");
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