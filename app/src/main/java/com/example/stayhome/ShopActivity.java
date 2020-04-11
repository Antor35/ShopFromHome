package com.example.stayhome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Bundle bundle = getIntent().getExtras();
        final String shopAddress = "https://"+bundle.getString("shopAddress");
        Log.d("Rafsan","link = "+shopAddress);
        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.loadingView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings ().setLoadsImagesAutomatically (true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(shopAddress);
        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
