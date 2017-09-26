package com.example.yls.newsclient;

import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.yls.newsclient.bean.NewsEntity;

/**
 * Created by yls on 2017/6/28.
 */

public class NewsDetailActivity extends BaseActivity{

    private WebView webView;
    private ProgressBar progressBar;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_news_detail;
    }

    @Override
    public void initView() {
        progressBar = (ProgressBar) findViewById(R.id.pb_01);
        initWebView();
    }

    private void initWebView() {
        webView = (WebView) findViewById(R.id.web_view);

        // 当点击WebView显示的网页的链接时，禁止使用其它浏览器打开
        webView.setWebViewClient(new WebViewClient());

        //设置webview支持javascript脚本
        webView.getSettings().setJavaScriptEnabled(true);

        // 当WebView加载网页时，显示加载网页的进度
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {       // 加载完成，隐藏进度条
                    progressBar.setVisibility(View.GONE);
                } else {                        // 显示加载进度
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                    System.out.println("---------percent: " + newProgress);
                }
            }
        });
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
        NewsEntity.ResultBean newsBean = (NewsEntity.ResultBean)
                getIntent().getSerializableExtra("news");
        webView.loadUrl(newsBean.getUrl());

        // 显示标题栏左上角的返回图标
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // 显示标题栏
        getSupportActionBar().setTitle(newsBean.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();   // 标题栏左上角的返回按钮，退出当前界面
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
