package com.badrulacademy.topnewsinternation.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.badrulacademy.topnewsinternation.R;

public class NewsWebView extends AppCompatActivity {

    Toolbar toolbar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_web_view);

        toolbar = findViewById(R.id.toolBar_id);
        webView = findViewById(R.id.webView_id);
        setSupportActionBar(toolbar);

        Log.d("INSIDEWEBVIEW", "onCreate: Inside-NEWSWEBVIEW");

        Intent intent = getIntent();
        String url = intent.getStringExtra("url"); //"url" spelling should be same "url" as given inside customAdapter
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}