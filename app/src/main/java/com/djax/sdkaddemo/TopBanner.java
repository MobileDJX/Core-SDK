package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.Listener.BannerListener;
import com.ad.sdk.adserver.TopBannerAD;

public class TopBanner extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_banner);

        ((TextView) findViewById(R.id.header)).setText("Top Banner Ad");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TopBannerAD.show(TopBanner.this, new BannerListener() {
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
        startActivity(new Intent(TopBanner.this, HomeActivity.class));
        finish();
    }
}