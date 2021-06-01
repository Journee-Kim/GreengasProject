package com.carbonjava.tumblermileageapp;

import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // wide viewport를 사용하도록 설정
        webView.getSettings().setUseWideViewPort(true);

        // 컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
        webView.getSettings().setLoadWithOverviewMode(true);

        //zoom 허용
        webView.getSettings().setSupportZoom(true);

        // 앱에서 표시할 url 입력
        webView.loadUrl("http://ec2-13-209-156-187.ap-northeast-2.compute.amazonaws.com:8080/main");
        webView.setWebViewClient(new WebViewClient());
    }

    //폰의 뒤로가기 버튼의 동작 입력
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}