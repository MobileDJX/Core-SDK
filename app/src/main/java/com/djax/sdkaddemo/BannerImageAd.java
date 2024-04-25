package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.BannerImageAD;
import com.ad.sdk.adserver.BannerPosition;
import com.ad.sdk.adserver.Listener.BannerListener;


public class BannerImageAd extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_image_ad);

        ((TextView) findViewById(R.id.header)).setText("Banner Ad");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BannerImageAD.show(BannerImageAd.this, BannerPosition.BOTTOM, new BannerListener() {
                    @Override
                    public void onAdsAdLoaded() {

                    }

                    @Override
                    public void onAdsAdFailed() {

                    }
                });
            }
        }, 1000);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BannerImageAd.this, HomeActivity.class));
        finish();
    }
}