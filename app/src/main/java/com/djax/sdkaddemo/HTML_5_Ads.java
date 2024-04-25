package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.HTML_5_Ad;
import com.ad.sdk.adserver.Listener.BannerListener;


public class HTML_5_Ads extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html5_ads);
        ((TextView) findViewById(R.id.header)).setText("HTML 5 Ad");

        HTML_5_Ad.show(this, new BannerListener() {
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
        startActivity(new Intent(HTML_5_Ads.this, HomeActivity.class));
        finish();
    }
}