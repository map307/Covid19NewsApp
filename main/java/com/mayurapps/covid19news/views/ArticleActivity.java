package com.mayurapps.covid19news.views;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mayurapps.covid19news.R;

public class ArticleActivity extends AppCompatActivity {

    private WebView mWebview ;
    private ProgressBar progressBar;
    private AppWebViewClients appWebViewClients;

    @SuppressLint("SetJavaScriptEnabled")
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_article);

            mWebview  = (WebView) findViewById(R.id.webView);
            progressBar = (ProgressBar) findViewById(R.id.progressBar);


            mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

            final Activity activity = this;

            mWebview.setWebViewClient(new WebViewClient() {
                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
                }
                @TargetApi(android.os.Build.VERSION_CODES.M)
                @Override
                public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                    // Redirect to deprecated method, so you can use it in all SDK versions
                    onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
                }
            });

            Intent intent = getIntent();

            mWebview .loadUrl(intent.getStringExtra("url"));
            mWebview.setWebViewClient(new AppWebViewClients(progressBar));

        }

    public class AppWebViewClients extends WebViewClient {
        private ProgressBar progressBar;

        public AppWebViewClients(ProgressBar progressBar) {
            this.progressBar=progressBar;
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }
}
