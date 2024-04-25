package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.VideoBanner;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class BannerVideo extends AppCompatActivity {

    FrameLayout frameLayout;
    StyledPlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_banner);

        frameLayout = findViewById(R.id.adFrame);
        playerView = findViewById(R.id.playerView);

        VideoBanner.loadAd(this, playerView);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BannerVideo.this, HomeActivity.class));
        finish();
    }
}