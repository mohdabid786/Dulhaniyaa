package com.example.saquib.dulhaniyaacom.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saquib.dulhaniyaacom.R;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    String URL;
    TextView toolText;
    ImageView back_button;
    String tool_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);

        webView = findViewById(R.id.webview);
        toolText = findViewById(R.id.text_toolbar);
        back_button = findViewById(R.id.back_button);

        try{
            URL=getIntent().getStringExtra("url");
            tool_text=getIntent().getStringExtra("toolText");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            webView.getSettings().setSafeBrowsingEnabled(false);
        }

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        toolText.setText(tool_text);

        webView.loadUrl(URL);
        //myWebView.setBackgroundColor(Color.TRANSPARENT);
        webView.getSettings().setJavaScriptEnabled(true);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}


//if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//        view.getSettings().setSafeBrowsingEnabled(false);
//        }
//
//        WebSettings settings = view.getSettings();
//        settings.setJavaScriptEnabled(true);

