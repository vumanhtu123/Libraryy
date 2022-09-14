package net.fpl.Tuvmph18579.webview;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import net.fpl.Tuvmph18579.R;
import net.fpl.Tuvmph18579.webview.PH18579_WebView;

public class PH18579_WebView extends AppCompatActivity {
    WebView webView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph18579_web_view);
        webView = findViewById(R.id.demo52Webview);
        intent = getIntent();
        String link = intent.getStringExtra("linkhttp");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
    }
}