package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.HTMLAD;
import com.ad.sdk.adserver.Listener.BannerListener;


public class HTML_Ads extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_ads);
        ((TextView) findViewById(R.id.header)).setText("HTML Ad");
        HTMLAD.show(this, new BannerListener() {
            @Override
            public void onAdsAdLoaded() {

            }

            @Override
            public void onAdsAdFailed() {

            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(HTML_Ads.this, HomeActivity.class));
        finish();
    }
}