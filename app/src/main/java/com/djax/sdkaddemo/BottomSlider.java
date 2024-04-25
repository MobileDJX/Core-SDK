package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.BottomSliderAd;
import com.ad.sdk.adserver.Listener.BottomSliderAdListener;


public class BottomSlider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_slider);
        ((TextView) findViewById(R.id.header)).setText("Bottom Slider Ad");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BottomSliderAd.show(BottomSlider.this, new BottomSliderAdListener() {
                    @Override
                    public void onAdsAdLoaded() {

                    }

                    @Override
                    public void onAdsAdFailed() {

                    }

                    @Override
                    public void onAdsAdShown() {

                    }

                    @Override
                    public void onAdsAdClicked() {

                    }

                    @Override
                    public void onAdsAdDismissed() {

                    }
                });
            }
        }, 1200);


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BottomSlider.this, HomeActivity.class));
        finish();
    }
}