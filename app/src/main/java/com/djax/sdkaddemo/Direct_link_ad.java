package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.DirectLinkAd;
import com.ad.sdk.adserver.Listener.BannerListener;


public class Direct_link_ad extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        ((TextView) findViewById(R.id.header)).setText("Direct Link Ad");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DirectLinkAd.show(Direct_link_ad.this, "Go To Browser", new BannerListener() {
                    @Override
                    public void onAdsAdLoaded() {

                    }

                    @Override
                    public void onAdsAdFailed() {

                    }
                });
            }
        }, 1200);


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Direct_link_ad.this, HomeActivity.class));
        finish();
    }

}