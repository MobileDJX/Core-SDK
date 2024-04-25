package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.Listener.PopupAdListener;
import com.ad.sdk.adserver.PopupAd;


public class PopUpAd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifpopup);

        ((TextView) findViewById(R.id.header)).setText("Popup Ad");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                PopupAd.load(PopUpAd.this, new PopupAdListener() {
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
        }, 1000);


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PopUpAd.this, HomeActivity.class));
        finish();
    }


}