package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.Interstitial;
import com.ad.sdk.adserver.Listener.InterstitialAdShowListener;
import com.ad.sdk.adserver.Listener.InterstitialLoadAdListener;


public class InterstitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);
        ((TextView) findViewById(R.id.header)).setText("Interstitial Ads");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Interstitial.load(InterstitialActivity.this, new InterstitialLoadAdListener() {
                    @Override
                    public void onAdsAdLoaded() {

                    }

                    @Override
                    public void onAdsAdFailed() {

                    }
                });

            }
        }, 1000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Interstitial.show(InterstitialActivity.this, new InterstitialAdShowListener() {
                    @Override
                    public void onAdsShowFailure() {

                    }

                    @Override
                    public void onAdsShowStart() {

                    }

                    @Override
                    public void onAdsShowClick() {

                    }

                    @Override
                    public void onAdsShowComplete() {

                    }

                    @Override
                    public void onAdsDismissed() {

                    }
                });
            }
        }, 2000);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(InterstitialActivity.this, HomeActivity.class));
        finish();
    }

}