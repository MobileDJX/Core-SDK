package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String zone_id = AppApplication.sharedPreferences.getString("Zone_ID", "");
        System.out.println("@ zone_id " + zone_id);


        //Banner Image
        ((LinearLayout) findViewById(R.id.bannerImage)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeActivity.this, BannerImageAd.class));
                finish();
            }
        });


        //Top Banner
        ((LinearLayout) findViewById(R.id.topBanner)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeActivity.this, TopBanner.class));
                finish();
            }
        });


        //Redirect Ad
        ((LinearLayout) findViewById(R.id.redirectAd)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeActivity.this, Direct_link_ad.class));
                finish();
            }
        });


        //Html Ad
        ((LinearLayout) findViewById(R.id.htmlAd)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeActivity.this, HTML_Ads.class));
                finish();
            }
        });

        //Html 5 Ad
        ((LinearLayout) findViewById(R.id.html5Ad)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeActivity.this, HTML_5_Ads.class));
                finish();
            }
        });

        //Popup Ad
        ((LinearLayout) findViewById(R.id.popupAds)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeActivity.this, PopUpAd.class));
                finish();
            }
        });


        //Interstitial Ad
        ((LinearLayout) findViewById(R.id.interstitial_Ads)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeActivity.this, InterstitialActivity.class));
                finish();
            }
        });

        //Rewarded Ads
        ((LinearLayout) findViewById(R.id.rewardedAd)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeActivity.this, RewardActivity.class));
                finish();
            }
        });

        //Bottom Slider
        ((LinearLayout) findViewById(R.id.bottomSlider)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeActivity.this, BottomSlider.class));
                finish();
            }
        });

        //InArticle
        ((LinearLayout) findViewById(R.id.inArticle)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeActivity.this, InArticleVideo.class));
                finish();
            }
        });


        //VideoBanner
//        ((LinearLayout) findViewById(R.id.videBanner)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startActivity(new Intent(HomeActivity.this, BannerVideo.class));
//                finish();
//            }
//        });


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(HomeActivity.this, ZoneActivity.class));
        finish();
    }


}