package com.fae.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar isLoading;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
        isLoading = (ProgressBar)findViewById(R.id.progressBar);
        progressBar = (ProgressBar)findViewById(R.id.progressBar2);

        //webView.setVisibility(View.INVISIBLE);
        isLoading.setVisibility(View.INVISIBLE);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://pt.wikipedia.org/wiki/Android");

        webView.setWebChromeClient(new WebChromeClient(){

            public void onProgressChanged(WebView view, int progress){
                progressBar.setProgress(progress);
            }
        });

        webView.setWebViewClient(new MyWebViewClient(){

            public void onPageFinished(WebView view, String url){
                isCharging(false);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                isCharging(true);
                return super.shouldOverrideUrlLoading(view, url);
            }
    
        });
    }

    @Override
    public void onBackPressed(){
        if(webView.canGoBack()){
            isCharging(true);
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }

    private void isCharging(boolean isCharging){
        if(isCharging){
            webView.setVisibility(View.INVISIBLE);
            isLoading.setVisibility(View.VISIBLE);
        }else{
            webView.setVisibility(View.VISIBLE);
            isLoading.setVisibility(View.INVISIBLE);
        }
    }

    private class MyWebViewClient extends WebViewClient{

    }
}
