package com.djax.sdkaddemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.ad.sdk.adserver.Listener.RewardedAdLoadListener;
import com.ad.sdk.adserver.Listener.RewardedAdShowListener;
import com.ad.sdk.adserver.RewardedVideo;

public class RewardActivity extends Activity {

    int current_points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);

        ((TextView) findViewById(R.id.header)).setText("Rewarded Video Ad");


        getPoint();


        RewardedVideo.load(RewardActivity.this, new RewardedAdLoadListener() {
            @Override
            public void onAdsAdLoaded() {

            }

            @Override
            public void onAdsAdFailed() {

            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                RewardedVideo.show(RewardActivity.this, new RewardedAdShowListener() {
                    @Override
                    public void onAdsShowFailure() {

                    }

                    @Override
                    public void onAdsShowStart() {

                    }

                    @Override
                    public void onAdsShowClicked() {

                    }

                    @Override
                    public void onAdsShowComplete() {

                    }

                    @Override
                    public void Rewarded(String rewardItem, int rewarded) {

                        System.out.println("@@ rewardvalue : " + rewarded);
                        SharedPreferences sharedPreferences = getSharedPreferences("RewardPoint", MODE_PRIVATE);
                        int point = sharedPreferences.getInt("Point", 0);
                        int c = rewarded + point;
                        addPoint(c);
                        ((TextView) findViewById(R.id.coins)).setText("" + c);


                        Toast.makeText(getApplicationContext(), "Reward Points : " + rewarded, Toast.LENGTH_SHORT).show();


                    }
                });
            }
        }, 1200);


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(RewardActivity.this, HomeActivity.class));
        finish();
    }


    void addPoint(int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("RewardPoint", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Point", i);
        editor.commit();

    }

    void getPoint() {
        SharedPreferences sharedPreferences = getSharedPreferences("RewardPoint", MODE_PRIVATE);
        int point = sharedPreferences.getInt("Point", 0);

        int c = current_points + point;
        // addPoint(c);
        ((TextView) findViewById(R.id.coins)).setText("" + c);
    }


}